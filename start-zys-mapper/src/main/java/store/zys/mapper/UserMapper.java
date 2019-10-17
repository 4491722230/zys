package store.zys.mapper;


import org.springframework.stereotype.Repository;
import store.zys.entity.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author: zengyusheng
 * @Date: 2019/9/24 16:23
 * @Version 1.0
 */

@Repository
public interface UserMapper extends Mapper<User> {
    //User getUserDTO(String username);
}


