package org.yu.serviceIml;

import javax.servlet.http.HttpSession;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
public interface LoginService {

    /**
     *   @Description:
     *   @Author:俞竞雄
     *   @Param:
     *   @return:
     *   @Date:2017-04-14
    */
    boolean login(String inputEamil, String inputPWD, HttpSession session);

}
