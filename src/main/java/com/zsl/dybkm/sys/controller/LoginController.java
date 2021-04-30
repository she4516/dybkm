package com.zsl.dybkm.sys.controller;

import cn.hutool.core.lang.Assert;
import com.zsl.dybkm.common.domain.BizResult;
import com.zsl.dybkm.common.jwt.JwtUtils;
import com.zsl.dybkm.utils.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

	@PostMapping(value = "/login")
	public Object userLogin(@RequestParam(name = "username", required = true) String userName,
                            @RequestParam(name = "password", required = true) String password, ServletResponse response) {
		Assert.notBlank(userName);
		Assert.notBlank(password);
		// 将用户名和密码封装成 UsernamePasswordToken 对象
		UsernamePasswordToken token = new UsernamePasswordToken(userName, MD5Utils.encrypt(password));
		SecurityUtils.getSubject().login(token);
		// 若登录成功，签发 JWT token
		String jwtToken = JwtUtils.sign(userName, JwtUtils.SECRET);
		// 将签发的 JWT token 设置到 HttpServletResponse 的 Header 中
		((HttpServletResponse) response).setHeader(JwtUtils.AUTH_HEADER, jwtToken);
		//
		return BizResult.success();
	}

	@GetMapping("/logout")
	public Object logout() {
		return BizResult.success();
	}
}
