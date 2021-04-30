package com.zsl.dybkm.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zsl.dybkm.sys.entity.Student;
import com.zsl.dybkm.sys.service.IStudentService;
import com.zsl.dybkm.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lidong
 * @since 2021-04-29
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/getByKey")
    public Student getByKey(Integer id){
        return studentService.getByKey(id);
    }

    @RequestMapping("/getAll")
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/selectPage")
    public IPage<Student> selectPage(Page<Student> page){
        return studentService.page(page);
    }
}
