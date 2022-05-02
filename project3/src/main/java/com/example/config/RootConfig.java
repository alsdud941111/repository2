package com.example.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"com.example.sample"})
@MapperScan(basePackages= {"com.example.mapper"})
public class RootConfig {

	 @Bean
	  public DataSource dataSource() 
	  {
	    HikariConfig hikariConfig = new HikariConfig();
	    hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	    hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");

	    hikariConfig.setUsername("madang");
	    hikariConfig.setPassword("madang");

	    HikariDataSource dataSource = new HikariDataSource(hikariConfig);

	    return dataSource;
	  }
	 
	 @Bean
	 public SqlSessionFactory sqlSessionFactory() throws Exception{
		 SqlSessionFactoryBean SqlSessionFactory = new SqlSessionFactoryBean();
		 SqlSessionFactory.setDataSource(dataSource());
		 return (SqlSessionFactory) SqlSessionFactory.getObject();
	 }
}