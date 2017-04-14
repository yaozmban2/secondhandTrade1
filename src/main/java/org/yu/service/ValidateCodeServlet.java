package org.yu.service;

import org.yu.utils.DrawCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */

public class ValidateCodeServlet extends HttpServlet {

    private static int WIDTH = 60;
    private static int HEIGHT = 30;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         *   @Description:       创建验证码
         *   @Author:俞竞雄
         *   @Param:[request]
         *   @Param:[response]
         *   @return:void
         *   @Date:2017-04-14
        */

        DrawCode drawCode = new DrawCode();


        //创建画板对象
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        //获得画笔对象
        Graphics g = image.getGraphics();

        //设置背景颜色
        drawCode.setBackGround(g, WIDTH, HEIGHT);
        //设置边框
        drawCode.setBorder(g, WIDTH, HEIGHT);
        //画干扰线
        drawCode.drawRandomLine(g, WIDTH, HEIGHT);
        //写随机数字
        String code = drawCode.drawRandomNum((Graphics2D)g);

        //将验证码写入session中以便验证
        HttpSession session = request.getSession();
        session.setAttribute("validateCode", code);

        //图形写给浏览器
        response.setContentType("image/jpeg");
        ImageIO.write(image, "jpg", response.getOutputStream());

        //发头控制浏览器不缓存
        response.setDateHeader("Expires", -1);
        response.setHeader("Cache-control", "no-cache");
        response.setHeader("Pragma", "no-cache");


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
