package com.config;

import java.util.Properties;

import javax.sql.DataSource;
 
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import com.dao.UserInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
 
@Configuration
@ComponentScan("com.*")
@EnableTransactionManagement
// Load to Environment.
@PropertySource("classpath:datasource-cfg.properties")
public class ApplicationContextConfig {
  
 
   // Lưu trữ các giá thuộc tính load bởi @PropertySource.
   @Autowired
   private Environment env;
 
   @Autowired
   private UserInfoDAO userInfoDAO;
 
   @Bean
   public ResourceBundleMessageSource messageSource() {
       ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
       // Load property in message/validator.properties
       rb.setBasenames(new String[] { "messages/validator" });
       return rb;
   }
 
   /*@Bean(name = "viewResolver")
   public InternalResourceViewResolver getViewResolver() {
       InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
       viewResolver.setPrefix("/WEB-INF/pages/");
       viewResolver.setSuffix(".jsp");
       return viewResolver;
   }*/
   
   @Bean(name = "viewResolver")
   public ViewResolver getViewResolver() {
       UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();

       // TilesView 3
       viewResolver.setViewClass(TilesView.class);

       return viewResolver;
   }

   @Bean(name = "tilesConfigurer")
   public TilesConfigurer getTilesConfigurer() {
       TilesConfigurer tilesConfigurer = new TilesConfigurer();

       // TilesView 3
       tilesConfigurer.setDefinitions("/WEB-INF/tiles.xml");

       return tilesConfigurer;
   }
 
   @Bean(name = "dataSource")
   public DataSource getDataSource() {
       BasicDataSource dataSource = new BasicDataSource();
  
       // Xem: datasouce-cfg.properties
       dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
       dataSource.setUrl(env.getProperty("ds.url"));
       dataSource.setUsername(env.getProperty("ds.username"));
       dataSource.setPassword(env.getProperty("ds.password"));
 
       System.out.println("## getDataSource: " + dataSource);
 
       return dataSource;
   }
 
   @Autowired
   @Bean(name = "sessionFactory")
   public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
       System.out.println("## getSessionFactory .... ");
       try {
           Properties properties = new Properties();
  
           // Xem: ds-hibernate-cfg.properties
           properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
           properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
           properties.put("current_session_context_class", env.getProperty("current_session_context_class"));
 
           LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
 
           // Package contain entity classes
           // Package chứa các entity class.
           factoryBean.setPackagesToScan(new String[] { "com.entity" });
           factoryBean.setDataSource(dataSource);
           factoryBean.setHibernateProperties(properties);
           factoryBean.afterPropertiesSet();
           //
           SessionFactory sf = factoryBean.getObject();
           System.out.println("## getSessionFactory: " + sf);
           return sf;
       } catch (Exception e) {
           System.out.println("Error getSessionFactory: " + e);
           e.printStackTrace();
           throw e;
       }
 
   }
 
   // Hibernate Transaction Manager
   @Autowired
   @Bean(name = "transactionManager")
   public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
       HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
 
       return transactionManager;
   }
 
}