package com.zr.security.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zr.security.config.security.user.UserDetail;
import com.zr.security.entity.SysUser;
import com.zr.security.mapper.SysUserMapper;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser sysUser = sysUserMapper.selectOne(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getUsername, username));

        if (Objects.isNull(sysUser)) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        // 查询账号信息及权限列表等 模拟
        UserDetail userDetail = new UserDetail();
        userDetail.setUsername(sysUser.getUsername());
        userDetail.setPassword(sysUser.getPassword());
        return userDetail;
    }
}
