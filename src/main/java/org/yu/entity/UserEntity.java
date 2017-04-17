package org.yu.entity;

import javax.persistence.*;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
@Entity
@Table(name = "user", schema = "secondhandtrade", catalog = "")
public class UserEntity {
    private String img;
    private int id;
    private String email;
    private String pwd;
    private String name;
    private String stuNum;
    private String qq;
    private String phone;
    private int messNum;

    @Basic
    @Column(name = "img", nullable = true, length = 255)
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "pwd", nullable = false, length = 255)
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "stu_num", nullable = true, length = 255)
    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    @Basic
    @Column(name = "qq", nullable = true, length = 255)
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 255)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "mess_num", nullable = false)
    public int getMessNum() {
        return messNum;
    }

    public void setMessNum(int messNum) {
        this.messNum = messNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (messNum != that.messNum) return false;
        if (img != null ? !img.equals(that.img) : that.img != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (pwd != null ? !pwd.equals(that.pwd) : that.pwd != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (stuNum != null ? !stuNum.equals(that.stuNum) : that.stuNum != null) return false;
        if (qq != null ? !qq.equals(that.qq) : that.qq != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = img != null ? img.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (stuNum != null ? stuNum.hashCode() : 0);
        result = 31 * result + (qq != null ? qq.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + messNum;
        return result;
    }
}
