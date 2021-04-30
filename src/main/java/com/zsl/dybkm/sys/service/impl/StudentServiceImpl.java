package com.zsl.dybkm.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsl.dybkm.sys.entity.Student;
import com.zsl.dybkm.sys.mapper.StudentMapper;
import com.zsl.dybkm.sys.service.IStudentService;
import com.zsl.dybkm.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lidong
 * @since 2021-04-29
 */
@Service
@Slf4j
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<Student> getAll() {
        log.info("未使用缓存");
        return studentMapper.selectList(null);
    }

    @Override
    @Cacheable(value = "student",key = "#id")
    public Student getByKey(Integer id) {
        log.info("未使用缓存");
        return studentMapper.selectById(id);
    }

    @Override
    public IPage<Student> selectByPage(IPage<Student> page) {
        return studentMapper.selectPage(page, null);
    }
}
