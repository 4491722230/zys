package store.zys.mapper;

import org.springframework.stereotype.Repository;
import store.zys.entity.UserRole;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Repository
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 获取用户角色
     *
     * @param userId
     * @return
     */
    List<String> roles(String userId);
}

