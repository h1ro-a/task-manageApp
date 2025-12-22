package com.task_manager.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.task_manager.mapper.UserMapper;
@Configuration
public class MybatisConfig {
	@Bean
	public SqlSessionFactory sessionFactory(DataSource dataSource) throws Exception {
		
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		
		//SpringのConfigurationと競合するのでフルパスで指定
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		configuration.setMapUnderscoreToCamelCase(true);
		factoryBean.setConfiguration(configuration);
		
		factoryBean.setTypeAliasesPackage("com.task_manager.entity");
	
		//Mapper.xmlの場所
		factoryBean.setMapperLocations(
				new PathMatchingResourcePatternResolver()
				.getResources("classpath:/com/task_manager/mapper/*.xml")
		);
		
		return factoryBean.getObject();
	}
}
