package store.zys.mapper;

import org.springframework.stereotype.Repository;
import store.zys.dto.UserDTO;
import store.zys.entity.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author: zengyusheng
 * @Date: 2019/10/14 10:55
 * @Version 1.0
 */

@Repository
public interface UserForLoginMapper extends Mapper<UserDTO> {

    UserDTO getUserDto1(String username);

    UserDTO updateById(User user);

    List<UserDTO> findAll();
}
