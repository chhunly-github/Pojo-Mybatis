package org.spring.configuration;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@MapperScan("org.spring")
@EnableSwagger2
public class WebMvcConfiguration {
	
	@Autowired
	private DataSource datasource;
	
	@Bean
	public SqlSessionFactoryBean sqlsessionfactorybean(){
		SqlSessionFactoryBean sqlsessionfactoryBean = new SqlSessionFactoryBean();
		sqlsessionfactoryBean.setDataSource(datasource);
		return sqlsessionfactoryBean;
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager(){
		return new DataSourceTransactionManager(datasource);
	}
	@Bean
	 public Docket api() {                
	     return new Docket(DocumentationType.SWAGGER_2)          
	       .select()                                       
	       .apis(RequestHandlerSelectors.any())
	       .paths(PathSelectors.any())                     
	       .build();
	 }
}
