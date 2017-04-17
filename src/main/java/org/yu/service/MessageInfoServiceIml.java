package org.yu.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.yu.dao.SHTDao;
import org.yu.entity.MessageCustom;
import org.yu.entity.MessageEntity;
import org.yu.entity.UserEntity;
import org.yu.serviceIml.MessageInfoService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
@Service(value = "messageInfoServiceIml")
public class MessageInfoServiceIml implements MessageInfoService {

    @Resource(name = "shtDao")
    private SHTDao shtDao;

    public boolean showMessageInfo(HttpSession session, Integer pageNum) {

        UserEntity user = null;
        List<MessageCustom> messageCustomList = new ArrayList<MessageCustom>();


        if (session.getAttribute("user") != null)
        {
            //将新的分页值存入session中以便查询上下页
            session.setAttribute("pageNum", pageNum);
            user = (UserEntity) session.getAttribute("user");
            //获得分页的信息列表
            List<MessageEntity> list = shtDao.selectMessageInfo(user.getId(), pageNum);
            for(MessageEntity message:list)
            {
                MessageCustom messageCustom = new MessageCustom();
                //如果user中放的信息和发送的用户一致则不用去查询数据库
                if (user.getId() != message.getMessFromId())
                {
                    user = shtDao.selectUserById(message.getMessFromId());
                }
                messageCustom.setMessText(message.getMessText());
                messageCustom.setMessId(message.getMessId());
                messageCustom.setSendTime(message.getSendTime());
                messageCustom.setMessType(message.getMessType());
                messageCustom.setEmail(user.getEmail());
                messageCustom.setImg(user.getImg());

                messageCustomList.add(messageCustom);
            }
            session.setAttribute("messageList", messageCustomList);

            return true;
        }else {
            return false;
        }
    }

    public boolean sendMessage(HttpServletRequest request, String inputMess, String inputEmailToSend, ModelAndView modelAndView) {

        //如果用户输入的消息正文为空
        if (inputMess == null || "".equals(inputMess))
        {
            modelAndView.addObject("sendMessageResult", "消息正文不能为空");
            return false;
        }
        //如果接收消息的用户不存在
        else if (shtDao.selectUserByEmail(inputEmailToSend) == null)
        {
            modelAndView.addObject("sendMessageResult", "用户不存在");
            return  false;
        }
        //消息发送成功
        else
        {
            //获得接收消息的用户的信息
            UserEntity user = shtDao.selectUserByEmail(inputEmailToSend);
            MessageEntity messageEntity = new MessageEntity();
            //将所有站内信的信息放入一个MessageEntity中
            messageEntity.setMessText(inputMess);
            messageEntity.setMessToId(user.getId());
            messageEntity.setMessType(2);
            Date date = new Date();
            messageEntity.setSendTime(date);
            user = (UserEntity) request.getSession().getAttribute("user");
            messageEntity.setMessFromId(user.getId());
            //将该站内信存入数据库中
            shtDao.insertMessage(messageEntity);

            return true;
        }
    }
}
