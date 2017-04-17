package org.yu.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.yu.dao.SHTDao;
import org.yu.entity.UserEntity;
import org.yu.serviceIml.ChangePersonlInfoService;
import org.yu.utils.MD5Encrypt;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
@Service(value = "changePersonalInfoServicceIml")
public class ChangePersonalInfoServicceIml implements ChangePersonlInfoService {

    @Resource(name = "shtDao")
    private SHTDao shtDao;
    @Resource(name = "md5Encrypt")
    private MD5Encrypt md5Encrypt;

    public boolean changePersonalPWD(UserEntity inputUser, ModelAndView modelAndView, String validatePWD, String newPWD, HttpServletRequest request) {

        //判断用户密码是否符合格式
        if(newPWD == null || newPWD.equals("") || newPWD.length() < 6)
        {
            modelAndView.addObject("checkNewPWD", "密码格式不正确");

            return false;
        }
        //判断用户输入两次密码是否一致
        else if (!newPWD.equals(validatePWD))
        {

            modelAndView.addObject("checkValidatePWD", "两次密码不一致");

            return false;
        }
        //判断用户输入的旧密码是否正确
        else if(request.getSession().getAttribute("user") != null)
        {
            UserEntity user = (UserEntity) request.getSession().getAttribute("user");
            boolean checkPWD = false;
            try {
                checkPWD = md5Encrypt.checkpassword(inputUser.getPwd(), user.getPwd());
            } catch (Exception e) {
                e.printStackTrace();
            }
            //用户输入旧密码不正确的情况
            if(!checkPWD)
            {
                modelAndView.addObject("checkOldPWD", "旧密码输入错误");

                return false;
            }
            //用户输入旧密码正确的情况
            else {

                //更新用户密码
                try {
                    user.setPwd(md5Encrypt.encoderByMd5(newPWD));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                shtDao.updateUser(user);

                return true;
            }
        }else {
            return false;
        }
    }

    public boolean changePersonalInfo(UserEntity inputUser, HttpSession session) {

        if(session.getAttribute("user") != null)
        {
            UserEntity user = (UserEntity)session.getAttribute("user");
            user.setName(inputUser.getName());
            user.setPhone(inputUser.getPhone());
            session.setAttribute("user", user);
            shtDao.updateUser(user);

            return true;
        }else {
            return false;
        }
    }

    public boolean uploadAvatar(HttpSession session, MultipartFile itemPic) {

        //存储图片文件夹的物理路径
        String picPath = "E:\\secondhandTrade2\\image\\avatar";
        //原始名称
        String originalFileName = itemPic.getOriginalFilename();
        //新的图片名称
        String newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
        //定义旧文件路径名
        String oldPicPath = null;
        //获得日期
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //新图片的物理路径
        String newPicPath = picPath + "\\" + date + "\\" + newFileName;
        //新图片
        File newFile = new File(newPicPath);
        //创建每日对应的文件夹
        newFile.getParentFile().mkdir();
        //将内存中的数据写入磁盘
        try {
            itemPic.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将图片路径放到session中uer对象中去
        if (session.getAttribute("user") != null)
        {
            UserEntity user = (UserEntity) session.getAttribute("user");
            //获得旧文件的物理路径
            if (user.getImg() != null)
            {
                oldPicPath = picPath + "\\" + date + "\\" + user.getImg().substring(user.getImg().lastIndexOf("/"));
                //删除旧的头像图片
                File file = new File(oldPicPath);
                if (file.exists()) {
                    file.delete();
                }
            }
            //将图片存到数据库中
            user.setImg("/avatar/" + date + "/" + newFileName);
            session.setAttribute("user", user);
            shtDao.updateUser(user);

            return true;
        }else {
            return false;
        }
    }
}
