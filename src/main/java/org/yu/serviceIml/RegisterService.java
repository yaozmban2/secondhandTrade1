package org.yu.serviceIml;

import org.yu.entity.UserEntity;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
public interface RegisterService {

    boolean validateCode(String sessionCode, String inputCode);

    boolean validatePwd(String pwd);

    boolean validateTwicePwd(String pwd, String validatePwd);

    boolean validateEmail(UserEntity user);

    void insertUser(UserEntity user);

}
