package com.zsl.dybkm.sys.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色权限关系表
 * </p>
 *
 * @author lidong
 * @since 2021-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRolePerm implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 权限ID
     */
    private Long permId;


}
