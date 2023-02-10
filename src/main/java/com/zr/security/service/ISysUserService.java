package com.zr.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zr.security.entity.SysUser;
import com.zr.security.entity.SysUserAddDTO;

public interface ISysUserService extends IService<SysUser> {
    void add(SysUserAddDTO addDTO);
}
