package store.zys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import store.zys.common.util.Dates;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: zengyusheng
 * @Date: 2019/10/14 10:28
 * @Version 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "sys_user")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderBy("DESC")
    @Id
    private String userId;
    // 用户id
    private String username;
    // 用户名
    private String password;
    // 密码
    private String nickname;
    // 昵称
    @JsonFormat(pattern = Dates.DEFAULT_PATTERN)
    private Date birthday;
    // 生日
    private Integer sex;
    // 性别 1-男/0-女
    private Integer enabled;
    // 是否启用：1/0
    private String UserLastLoginTime;

    public String getUserLastLoginTime() {
        return UserLastLoginTime;
    }

    public void setUserLastLoginTime(String userLastLoginTime) {
        UserLastLoginTime = userLastLoginTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getEnable() {
        return enabled;
    }

    public void setEnable(Integer enable) {
        this.enabled = enable;
    }
}