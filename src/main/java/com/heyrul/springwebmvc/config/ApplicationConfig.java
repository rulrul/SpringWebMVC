/*
 * @Author Rully Andhika a.k.a jarul
 * www.heyrul.com-2017
 */
package com.heyrul.springwebmvc.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.heyrul.springwebmvc.models.Karyawan;

@Configuration
@PropertySource({ "classpath:database.properties" })
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.heyrul.springwebmvc" })
public class ApplicationConfig {
	
	@Autowired
	private Environment environment;
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(environment.getProperty("database.driver"));
		dataSource.setUrl(environment.getProperty("database.url"));
		dataSource.setUsername(environment.getProperty("database.username"));
		dataSource.setPassword(environment.getProperty("database.password"));
		return dataSource;
	}
	
	@Bean(name = "sessionFactory")
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(getDataSource());
		
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		lsfb.setHibernateProperties(properties);
		
		lsfb.setAnnotatedClasses(Karyawan.class);
		
		return lsfb;
	}
	
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(getSessionFactory().getObject());
		return htm;
	}

}
