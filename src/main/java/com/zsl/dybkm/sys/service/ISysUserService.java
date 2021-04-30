package com.zsl.dybkm.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zsl.dybkm.sys.entity.SysUser;

import java.util.List;

public interface ISysUserService extends IService<SysUser>{

    SysUser getByUserName(String username);

    List<SysUser> getAll();
}
