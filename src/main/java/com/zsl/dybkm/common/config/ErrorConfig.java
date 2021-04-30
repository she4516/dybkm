package com.zsl.dybkm.common.config;


import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * created with IntelliJ IDEA
 *
 * @author: create by limu
 * Date: 2020/7/21
 * Time：10:50
 */
@Component
public class ErrorConfig implements ErrorPageRegistrar {

    /**
     * 设置404and500页面指向
     *
     * @param registry 注册表
     */
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/hplus/400");
        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/hplus/500");
        registry.addErrorPages(error404Page, error500Page);
    }
}
