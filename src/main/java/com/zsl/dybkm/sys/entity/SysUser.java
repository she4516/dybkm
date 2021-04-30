package com.zsl.dybkm.sys.entity;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description 用户表
 * @author BEJSON
 * @date 2021-04-02
 */
@Data
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Long id;

    /**
     * 账号
     */
    private String username;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态 0:有效 1:无效
     */
    private int status;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 添加时间
     */
    private Date createTime;

    /**
     * 操作人
     */
    private Long createId;

    /**
     * 操作人
     */
    private Long updateId;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否删除 0:否 1:是
     */
    private int deleted;

}
