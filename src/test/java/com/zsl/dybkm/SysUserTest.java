package com.zsl.dybkm;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zsl.dybkm.sys.entity.SysUser;
import com.zsl.dybkm.sys.service.ISysUserService;
import com.zsl.dybkm.utils.IdGeneratorUtil;
import com.zsl.dybkm.utils.MD5Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserTest {

    @Autowired
    private ISysUserService sysUserService;



    @Test
    public void getSysUserList(){
        System.out.println();
    }

    @Test
    public void saveUserTest(){
        String password = MD5Utils.encrypt("123456");
        SysUser sysUser = new SysUser();
        Long nextId = IdGeneratorUtil.nextId();
        sysUser.setId(nextId);
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());
        sysUser.setCreateId(nextId);
        sysUser.setUpdateId(nextId);
        sysUser.setUsername("root");
        sysUser.setName("李四");
        sysUser.setMobile("15812341234");
        sysUser.setPassword(password);
        sysUser.setStatus(0);
    }

    @Test
    public void getByIdTest(){
        Page<SysUser> page = new Page<>();
        page.setCurrent(1L);
        page.setSize(10);
        Page<SysUser> data = sysUserService.page(page);
        System.out.println();
    }
}
