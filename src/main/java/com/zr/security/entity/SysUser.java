package com.zr.security.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class SysUser {

    private Long id;

    private String username;

    private String password;

    @TableField("is_delete")
    private Integer isDelete;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
