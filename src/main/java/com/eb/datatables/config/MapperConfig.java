package com.eb.datatables.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
		configurer.setBasePackage("com.eb.datatables");
		configurer.setAnnotationClass(Mapper.class);
		return configurer;
	}
}
