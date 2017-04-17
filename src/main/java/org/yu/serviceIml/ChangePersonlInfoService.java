package org.yu.serviceIml;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.yu.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */

public interface ChangePersonlInfoService {

    boolean changePersonalPWD(UserEntity inputUser, ModelAndView modelAndView, String validatePWD, String newPWD, HttpServletRequest request);

    boolean changePersonalInfo(UserEntity inputUser, HttpSession session);

    boolean uploadAvatar(HttpSession session, MultipartFile itemPic);
}
