package store.zys.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author Lan
 * @since 2019-04-04
 */
@Table(name = "role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色编号
     */
    @Id
    private String roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色状态，0正常，-1删除
     */
    private String roleStatus;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }
}
