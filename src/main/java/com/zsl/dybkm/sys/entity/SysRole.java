package com.zsl.dybkm.sys.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色信息表
 * </p>
 *
 * @author lidong
 * @since 2021-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 名称
     */
    private String name;

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
