package org.yu.serviceIml;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
public interface MessageInfoService {

    /**
     *   @Description:      查询发给用户的消息并按pageNum分页，将消息list存入session中的MessageInfo属性中
     *   @Author:俞竞雄
     *   @Param:[session]   用户的session
     *   @Param:[pageNum]   第几个分页
     *   @return:[boolean]  查询成功返回true，不成功返回false
     *   @Date:2017-04-16
    */
    boolean showMessageInfo(HttpSession session, Integer pageNum);

    /**
     *   @Description:        发送站内信
     *   @Author:俞竞雄
     *   @Param:[request]
     *   @Param:[inputMess]            用户输入的消息正文
     *   @Param:[inputEmailToSend]    接收站内信的用户的邮箱
     *   @return:
     *   @Date:2017-04-16
    */
    boolean sendMessage(HttpServletRequest request, String inputMess, String inputEmailToSend, ModelAndView modelAndView);

}
