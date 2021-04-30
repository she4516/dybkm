package com.zsl.dybkm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableCaching
@MapperScan("com.zsl.dybkm.sys.mapper")
public class DybkmApplication {

	public static void main(String[] args) {
		SpringApplication.run(DybkmApplication.class, args);
	}

}
