package store.zys.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import store.zys.dto.UserDTO;
import store.zys.mapper.RoleMapper;
import store.zys.mapper.UserForLoginMapper;


/**
 * @Author: zengyusheng
 * @Date: 2019/10/14 10:52
 * @Version 1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserForLoginMapper userForLoginMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String roleName = roleMapper.findAll().get(0).getRoleName();
        //String roleName = roleMapper.selectAll().get(0).getRoleName();

        System.out.println("角色名"+roleName);
        UserDTO userDto = userForLoginMapper.getUserDto1(username);
        if(userDto==null) {
            return null;
        }
        userDto.setRemember(true);
        userDto.setName(userDto.getUserName());
        userDto.setUserName(username);
        return userDto;
    }
}
