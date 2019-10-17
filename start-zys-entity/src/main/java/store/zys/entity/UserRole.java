package store.zys.entity;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author Lan
 * @since 2019-04-04
 */
@Table(name = "user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户角色编号
     */
    @Id
    private String userRoleId;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 角色编号
     */
    private String roleId;

    /**
     * 用户角色状态，0正常，-1删除
     */
    private String userRoleStatus;

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserRoleStatus() {
        return userRoleStatus;
    }

    public void setUserRoleStatus(String userRoleStatus) {
        this.userRoleStatus = userRoleStatus;
    }
}
