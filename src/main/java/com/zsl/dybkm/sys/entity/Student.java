package com.zsl.dybkm.sys.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lidong
 * @since 2021-04-29
 */
@Data
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String name;

    private Integer age;


}
