package com.zsl.dybkm.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zsl.dybkm.sys.entity.Student;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lidong
 * @since 2021-04-29
 */
public interface IStudentService extends IService<Student> {

    List<Student> getAll();

    Student getByKey(Integer id);

    IPage<Student> selectByPage(IPage<Student> page);
}
