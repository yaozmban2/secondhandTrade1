package org.yu.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/4/11.
 */
@Entity
@Table(name = "message", schema = "secondhandtrade", catalog = "")
public class MessageEntity {
    private int messFromId;
    private int messToId;
    private String messText;
    private Timestamp sendTime;
    private int messId;
    private Integer messType;

    @Basic
    @Column(name = "mess_from_id")
    public int getMessFromId() {
        return messFromId;
    }

    public void setMessFromId(int messFromId) {
        this.messFromId = messFromId;
    }

    @Basic
    @Column(name = "mess_to_id")
    public int getMessToId() {
        return messToId;
    }

    public void setMessToId(int messToId) {
        this.messToId = messToId;
    }

    @Basic
    @Column(name = "mess_text")
    public String getMessText() {
        return messText;
    }

    public void setMessText(String messText) {
        this.messText = messText;
    }

    @Basic
    @Column(name = "send_time")
    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    @Id
    @Column(name = "mess_id")
    public int getMessId() {
        return messId;
    }

    public void setMessId(int messId) {
        this.messId = messId;
    }

    @Basic
    @Column(name = "mess_type")
    public Integer getMessType() {
        return messType;
    }

    public void setMessType(Integer messType) {
        this.messType = messType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (messFromId != that.messFromId) return false;
        if (messToId != that.messToId) return false;
        if (messId != that.messId) return false;
        if (messText != null ? !messText.equals(that.messText) : that.messText != null) return false;
        if (sendTime != null ? !sendTime.equals(that.sendTime) : that.sendTime != null) return false;
        if (messType != null ? !messType.equals(that.messType) : that.messType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = messFromId;
        result = 31 * result + messToId;
        result = 31 * result + (messText != null ? messText.hashCode() : 0);
        result = 31 * result + (sendTime != null ? sendTime.hashCode() : 0);
        result = 31 * result + messId;
        result = 31 * result + (messType != null ? messType.hashCode() : 0);
        return result;
    }
}
