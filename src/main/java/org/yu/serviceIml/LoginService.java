package org.yu.serviceIml;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
public interface LoginService {

    /**
     *   @Description:     登录并验证用户密码，若正确则把用户存入session中
     *   @Author:俞竞雄
     *   @Param:[inputEamil]  用户输入的email
     *   @Param:[inputPWD]    用户输入的密码
     *   @Param:[session]     用户的HttpSession
     *   @return:boolean      成功则返回true，失败返回false
     *   @Date:2017-04-14
    */
    boolean login(String inputEamil, String inputPWD, HttpSession session);

    /**
     *   @Description:          通过Cookie里面的email和密码检查是否正确
     *   @Author:俞竞雄
     *   @Param:[inputEamil]   用户输入的email
     *   @Param:[inputPWD]     用户输入的密码
     *   @Param:[session]       用户的HttpSession（存入user）
     *   @return:boolean        如果Cookie保存的用户密码正确就返回true，否则返回false
     *   @Date:2017-04-14
    */
    boolean checkAutoLogin(String inputEamil, String inputPWD, HttpSession session);

    /**
     *   @Description:           设置自动登录（往Cookie中填入用户的email和密码）
     *   @Author:俞竞雄
     *   @Param:[inputEamil]    用户输入的email
     *   @Param:[inputPWD]      用户输入的密码
     *   @Param:[response]
     *   @return:
     *   @Date:2017-04-14   
    */
    void setAutoLogin(String inputEamil, String inputPWD, HttpServletResponse response);

    /**
     *   @Description:       根据session中保存的userID查询有多少接受信息
     *   @Author:俞竞雄
     *   @Param:[session]
     *   @return:
     *   @Date:2017-04-14   
    */
    Integer selectMessageCount(HttpSession session);

}
