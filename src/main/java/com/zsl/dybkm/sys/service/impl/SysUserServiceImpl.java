package com.zsl.dybkm.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.zsl.dybkm.sys.mapper.SysUserMapper;
import com.zsl.dybkm.sys.entity.SysUser;
import com.zsl.dybkm.sys.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getByUserName(String username) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getUsername,username);
        return sysUserMapper.selectOne(queryWrapper);
    }

    @Override
    @Cacheable(value = "sysUser")
    public List<SysUser> getAll() {
        return sysUserMapper.selectList(null);
    }
}
