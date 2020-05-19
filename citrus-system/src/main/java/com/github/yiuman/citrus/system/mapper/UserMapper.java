package com.github.yiuman.citrus.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.yiuman.citrus.system.entity.Role;
import com.github.yiuman.citrus.system.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yiuman
 * @date 2020/3/23
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from sys_user user where user.uuid = '${uuid}'")
    User getUserByUUID(@Param("uuid") String uuid);

    @Select("select * from sys_user user where user.login_id = '${loginId}'")
    User getUserByLoginId(@Param("loginId") String loginId);

    @Select("select * from sys_role role where role.role_id in (select ur.role_id from sys_user_role ur where ur.user_id = ${userId})")
    List<Role> getRolesByUserId(Long userId);
}