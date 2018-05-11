package org.cloud.jlzm.config;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan(basePackages = "org.cloud.jlzm.mapper")
@EnableTransactionManagement
public class DataConfiguration implements EnvironmentAware {

	private RelaxedPropertyResolver propertyResolver;

	@Bean(destroyMethod = "close", initMethod = "init")
	public DataSource dataSource() throws SQLException {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(propertyResolver.getProperty("url"));
		dataSource.setUsername(propertyResolver.getProperty("username"));// 用户名
		dataSource.setPassword(propertyResolver.getProperty("password"));// 密码
		dataSource.setDriverClassName(propertyResolver.getProperty("driver-class-name"));
		dataSource.setInitialSize(1);
		dataSource.setMaxActive(20);
		dataSource.setMinIdle(1);
		dataSource.setMaxWait(60000);
		dataSource.setTimeBetweenEvictionRunsMillis(60000);
		dataSource.setMinEvictableIdleTimeMillis(300000);
		dataSource.setValidationQuery("select 'x'");
		dataSource.setTestOnBorrow(true);
		dataSource.setTestWhileIdle(false);
		dataSource.setTestOnReturn(false);
		dataSource.setPoolPreparedStatements(true);
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
		// 配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
		dataSource.setFilters("stat");
		return dataSource;
	}

	@Override
	public void setEnvironment(Environment env) {
		this.propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
	}

	@Bean(name = "transactionManager")
	public DataSourceTransactionManager dataSourceTransactionManager() throws PropertyVetoException, SQLException {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public SpringManagedTransactionFactory springManagedTransactionFactory() {
		return new SpringManagedTransactionFactory();
	}
}
