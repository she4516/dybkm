package com.zsl.dybkm.common.handler;

import com.zsl.dybkm.common.domain.BizResult;
import com.zsl.dybkm.exception.BizAssertException;
import com.zsl.dybkm.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.connection.PoolException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 异常处理器
 * 
 * @Author scott
 * @Date 2019
 */
@RestControllerAdvice
@Slf4j
public class BizExceptionHandler {


	@ExceptionHandler(BizException.class)
	public BizResult<?> handleRRException(BizException e){
		log.error(e.getMessage(), e);
		return BizResult.error(e.getMessage());
	}

	@ExceptionHandler(BizAssertException.class)
	public BizResult<?> handleRRException(BizAssertException e){
		log.error(e.getMessage(), e);
		return BizResult.error(e.getMessage());
	}


	@ExceptionHandler({UnauthorizedException.class, AuthorizationException.class})
	public BizResult<?> handleAuthorizationException(AuthorizationException e){
		log.error(e.getMessage(), e);
		return BizResult.noauth("没有权限，请联系管理员授权");
	}

	@ExceptionHandler(Exception.class)
	public BizResult<?> handleException(Exception e){
		log.error(e.getMessage(), e);
		return BizResult.error("操作失败，"+e.getMessage());
	}
	

    @ExceptionHandler(PoolException.class)
    public BizResult<?> handlePoolException(PoolException e) {
    	log.error(e.getMessage(), e);
        return BizResult.error("Redis 连接异常!");
    }

}
