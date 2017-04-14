package org.yu.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.yu.entity.UserEntity;
import org.yu.service.LoginServiceIml;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:俞竞雄
 * @Description:     自动登录的拦截器
 * @Date: ${date}
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Resource(name = "loginServiceIml")
    private LoginServiceIml loginServiceIml;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         *   @Description:      在进入Controller前执行，执行拦截功能
         *   @Author:俞竞雄
         *   @Param:[request]
         *   @Param:[response]
         *   @Param:[handler]
         *   @return:boolean     返回true才会继续执行，返回false则中断执行
         *   @Date:2017-03-17
        */

        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView modelAndView) throws Exception {
        /**
         *   @Description:          在Controller之后，视图渲染器之前，在该方法可以修改ModelAndView
         *   @Author:俞竞雄
         *   @Param:[request]
         *   @Param:[response]
         *   @Param:[obj]
         *   @Param:[modelAndView]
         *   @return:void
         *   @Date:2017-04-14
        */

        UserEntity loginUser = null;

        //如果session中有user的属性
        if(request.getSession().getAttribute("user") != null ) {
            //从session中获得user属性
            loginUser = (UserEntity) request.getSession().getAttribute("user");

            //session中还有用户信息，没有注销的情况下
            if(loginUser != null)
            {
                modelAndView.addObject("messCount", loginServiceIml.selectMessageCount(request.getSession()));
                modelAndView.addObject("aotuLogin", "true");
            }
            //session中没有用户信息（可能用户登录被注销，可能用户的session超过时间被注销）
            else
            {
                String loginCookieUserEmail = "";
                String loginCookiePassword = "";

                //判断在cookies中是否存有用户的用户名和密码
                Cookie[] cookies = request.getCookies();
                if(cookies != null)
                {
                    //将用户名和用户密码存入cookie中以便自动登录
                    for(Cookie cookie:cookies)
                    {
                        if("loginEmail".equals(cookie.getName()))
                        {
                            loginCookieUserEmail = cookie.getValue();
                        }else if("loginPWD".equals(cookie.getName()))
                        {
                            loginCookiePassword = cookie.getValue();
                        }
                    }
                }
                //有用户的用户名和密码的情况（用户设置了自动登录）
                if(!"".equals(loginCookiePassword) && !"".equals(loginCookieUserEmail))
                {
                    if(loginServiceIml.checkAutoLogin(loginCookieUserEmail, loginCookiePassword, request.getSession()))
                    {
                        modelAndView.addObject("messCount", loginServiceIml.selectMessageCount(request.getSession()));
                        modelAndView.addObject("aotuLogin", "true");
                    }
                }
            }
        }

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
