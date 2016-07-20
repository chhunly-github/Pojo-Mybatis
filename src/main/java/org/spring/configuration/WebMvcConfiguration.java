package org.spring.configuration;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan("org.spring")
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
}
