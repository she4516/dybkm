package com.zsl.dybkm;


import com.zsl.dybkm.sys.entity.SysRole;
import com.zsl.dybkm.sys.service.ISysRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysRoleTest {

    @Autowired
    private ISysRoleService sysRoleService;

    @Test
    public void findRoleListTest(){
        List<SysRole> list = sysRoleService.list();
        System.out.println();
    }
}
