package com.zsl.dybkm.common.domain;

import cn.hutool.http.HttpStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *   接口返回数据格式
 * @author scott
 * @email jeecgos@163.com
 * @date  2019年1月19日
 */
@Data
@ApiModel(value="接口返回对象", description="接口返回对象")
public class BizResult<T> implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * 返回处理消息
	 */
	@ApiModelProperty(value = "返回处理消息")
	private String message = "操作成功！";

	/**
	 * 返回代码
	 */
	@ApiModelProperty(value = "返回代码")
	private Integer code = 0;
	
	/**
	 * 返回数据对象 data
	 */
	@ApiModelProperty(value = "返回数据对象")
	private T result;
	
	/**
	 * 时间戳
	 */
	@ApiModelProperty(value = "时间戳")
	private long timestamp = System.currentTimeMillis();

	public BizResult() {
		
	}


	public static<T> BizResult<T> success() {
		BizResult<T> r = new BizResult<T>();
		r.setCode(HttpStatus.HTTP_OK);
		r.setMessage("成功");
		return r;
	}

	public static<T> BizResult<T> success(T data) {
		BizResult<T> r = new BizResult<T>();
		r.setCode(HttpStatus.HTTP_OK);
		r.setResult(data);
		return r;
	}

	public static<T> BizResult<T> success(String msg, T data) {
		BizResult<T> r = new BizResult<T>();
		r.setCode(HttpStatus.HTTP_OK);
		r.setMessage(msg);
		r.setResult(data);
		return r;
	}
	
	public static BizResult<Object> error(String msg) {
		return error(HttpStatus.HTTP_INTERNAL_ERROR, msg);
	}
	
	public static BizResult<Object> error(int code, String msg) {
		BizResult<Object> r = new BizResult<Object>();
		r.setCode(code);
		r.setMessage(msg);
		return r;
	}

	public BizResult<T> error500(String message) {
		this.message = message;
		this.code = HttpStatus.HTTP_INTERNAL_ERROR;
		return this;
	}
	/**
	 * 无权限访问返回结果
	 */
	public static BizResult<Object> noauth(String msg) {
		return error(HttpStatus.HTTP_UNAUTHORIZED, msg);
	}

}