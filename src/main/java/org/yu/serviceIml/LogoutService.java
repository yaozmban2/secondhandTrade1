package org.yu.serviceIml;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
public interface LogoutService {

    /**
     *   @Description:     取消自动登录
     *   @Author:俞竞雄
     *   @Param:[request]
     *   @return:
     *   @Date:2017-04-14   
    */
    void quitAutoLogin(HttpServletRequest request, HttpServletResponse response);
}
