package com.zsl.dybkm.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zsl.dybkm.common.domain.BizAssert;
import com.zsl.dybkm.common.domain.BizResult;
import com.zsl.dybkm.sys.entity.SysUser;
import com.zsl.dybkm.sys.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/sysUser")
@Slf4j
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @GetMapping("/findUserList")
    //@RequiresPermissions(value = { "sysUser:findUserList" })
    public BizResult<List<SysUser>> findUserList(){
        List<SysUser> list = sysUserService.getAll();
        log.info("查询用户信:{}", JSONObject.toJSONString(list));
        return BizResult.success(list);
    }

    @GetMapping("/getByUserName")
    public BizResult<SysUser> getByUserName(String username){
        BizAssert.notEmpty(username,"用户名称不能为空");
        return BizResult.success(sysUserService.getByUserName(username));
    }

    @GetMapping("/selectPage")
    public BizResult<IPage<SysUser>> selectPage(Page<SysUser> page){
        return BizResult.success(sysUserService.page(page));
    }

    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("hplus/index");
    }
}
