package org.yu.entity;

import java.util.Date;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
public class MessageCustom {

    private int messFromId;
    private int messToId;
    private String messText;
    private Date sendTime;
    private int messId;
    private Integer messType;
    private String email;
    private String img;

    public int getMessFromId() {
        return messFromId;
    }

    public void setMessFromId(int messFromId) {
        this.messFromId = messFromId;
    }

    public int getMessToId() {
        return messToId;
    }

    public void setMessToId(int messToId) {
        this.messToId = messToId;
    }

    public String getMessText() {
        return messText;
    }

    public void setMessText(String messText) {
        this.messText = messText;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public int getMessId() {
        return messId;
    }

    public void setMessId(int messId) {
        this.messId = messId;
    }

    public Integer getMessType() {
        return messType;
    }

    public void setMessType(Integer messType) {
        this.messType = messType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


}
