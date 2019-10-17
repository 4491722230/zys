package store.zys.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import store.zys.vo.LoginSuccessVO;

import javax.persistence.Table;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @Author: zengyusheng
 * @Date: 2019/10/14 10:56
 * @Version 1.0
 */
@Table(name = "sys_user")
public class UserDTO extends LoginSuccessVO implements UserDetails {
    private Boolean remember;

    /**
     * 用户名
     */

    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = getRoles().stream().map(roleName -> new SimpleGrantedAuthority("ROLE_" + roleName)).collect(Collectors.toList());
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Boolean getRemember() {
        return remember;
    }

    public void setRemember(Boolean remember) {
        this.remember = remember;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
