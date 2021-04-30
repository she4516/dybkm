package com.zsl.dybkm.sys.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author lidong
 * @since 2021-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父ID
     */
    private Long pid;

    /**
     * 菜单类型 1:目录 2:菜单 3;按钮
     */
    private Integer type;

    /**
     * 菜单Url
     */
    private String url;

    /**
     * 权限标识
     */
    private String permFlag;

    /**
     * 添加时间
     */
    private LocalDateTime createTime;

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
    private LocalDateTime updateTime;

    /**
     * 是否删除 0:否 1:是
     */
    private Integer deleted;


}
