package com.zr.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zr.security.entity.SysUser;
import com.zr.security.entity.SysUserAddDTO;
import com.zr.security.mapper.SysUserMapper;
import com.zr.security.service.ISysUserService;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Resource
    SysUserMapper sysUserMapper;

    @Resource
    PasswordEncoder passwordEncoder;


    @Override
    public void add(SysUserAddDTO addDTO) {
        SysUser sysUser = new SysUser();
        sysUser.setUsername(addDTO.getUsername())
                .setPassword(passwordEncoder.encode(addDTO.getPassword()))
                .setIsDelete(0)
                .setCreateTime(LocalDateTime.now())
                .setUpdateTime(LocalDateTime.now());
        sysUserMapper.insert(sysUser);
    }
}
