package store.zys.mapper;

import org.springframework.stereotype.Repository;
import store.zys.entity.Role;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author Lan
 * @since 2019-04-04
 */
@Repository
public interface RoleMapper extends Mapper<Role> {
    List<Role> findAll();
}
