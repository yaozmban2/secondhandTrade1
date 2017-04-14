package org.yu.serviceIml;

import org.yu.entity.UserEntity;

import javax.servlet.http.HttpSession;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
public interface RegisterService {

    /**
     *   @Description:           验证码检验
     *   @Author:俞竞雄
     *   @Param:[sessionCode]   存放在session中系统生成的验证码
     *   @Param:[inputCode]     用户输入的验证码
     *   @return:[boolean]      验证码输入正确返回true，错误返回false
     *   @Date:2017-04-14
    */
    boolean validateCode(String sessionCode, String inputCode);

    /**
     *   @Description:         检验密码合法性
     *   @Author:俞竞雄
     *   @Param:[pwd]          用户输入的密码
     *   @return:[boolean]     若密码合法则返回true，否则返回false
     *   @Date:2017-04-14   
    */
    boolean validatePwd(String pwd);

    /**
     *   @Description:           检验二次输入的密码是否相同
     *   @Author:俞竞雄
     *   @Param:[pwd]             用户输入的密码
     *   @Param:[validatePwd]    用户第二次输入的密码
     *   @return:[boolean]       若两次输入相同返回true，不相同返回false
     *   @Date:2017-04-14
    */
    boolean validateTwicePwd(String pwd, String validatePwd);

    /**
     *   @Description:      检验用户输入的email是否有重复
     *   @Author:俞竞雄
     *   @Param:[user]      存放用户输入的信息
     *   @return:[boolean] 若有重复则返回ftrue，没有重复返回false
     *   @Date:2017-04-14   
    */
    boolean validateEmail(UserEntity user);

    /**
     *   @Description:     插入用户
     *   @Author:俞竞雄
     *   @Param:[user]    存放用户输入的信息
     *   @return:
     *   @Date:2017-04-15
    */
    void insertUser(UserEntity user);

    /**
     *   @Description:       设置自动登录，将用户信息放入session中
     *   @Author:俞竞雄
     *   @Param:[user]        存放用户输入的信息
     *   @Param:[session]
     *   @return:
     *   @Date:2017-04-15
    */
    void setAutoLogin(UserEntity user, HttpSession session);

}
