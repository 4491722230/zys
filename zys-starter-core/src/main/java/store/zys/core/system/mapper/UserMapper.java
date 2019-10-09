package store.zys.core.system.mapper;


import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Repository;
import store.zys.core.system.dto.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author: zengyusheng
 * @Date: 2019/9/24 16:23
 * @Version 1.0
 */

@Repository
public interface UserMapper extends Mapper<User> {
}
