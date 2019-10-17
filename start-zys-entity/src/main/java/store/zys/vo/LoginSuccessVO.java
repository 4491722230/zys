package store.zys.vo;

import java.util.List;

/**
 * @Author: zengyusheng
 * @Date: 2019/10/14 10:59
 * @Version 1.0
 */
public class LoginSuccessVO {
    private String userId;
    private String name;
    private List<String> roles;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = name;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
