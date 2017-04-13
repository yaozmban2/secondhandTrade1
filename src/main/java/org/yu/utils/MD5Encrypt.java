package org.yu.utils;

import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
@Component(value = "md5Encrypt")
public class MD5Encrypt {

    public String encoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        /**
         *   @Description:利用MD5进行加密
         *   @Author:俞竞雄
         *   @Param:[str] 待加密的字符串
         *   @return:java.lang.String 加密后的字符串
         *   @Date:2017-03-13
         */

        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));

        return newstr;
    }

    public boolean checkpassword(String newpasswd, String oldpasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        /**
         *   @Description: 判断用户输入的密码是否正确
         *   @Author:俞竞雄
         *   @Param:[newpasswd] 用户输入密码
         *   @Param:[oldpasswd] 数据库中存储的密码- - 用户密码的摘要
         *   @return:boolean 返回true则密码正确，返回false则密码错误
         *   @Date:2017-04-13
         */

        if (encoderByMd5(newpasswd).equals(oldpasswd)) {
            return true;
        } else {
            return false;
        }
    }
}
