package com.config;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
 
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
 
   private static final Charset UTF8 = Charset.forName("UTF-8");
  
   // Cấu hình UTF-8 cho các trang.
   @Override
   public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
       StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
       stringConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "plain", UTF8)));
       converters.add(stringConverter);
 
       // Add other converters ...
   }
 
   @Override
   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
       configurer.enable();
   }
   
   // Cấu hình để sử dụng các file nguồn tĩnh (html, image, ..)
   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// Css resource.
       registry.addResourceHandler("/styles/**").addResourceLocations("/WEB-INF/resources/styles/").setCachePeriod(31556926);
       registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/resources/js/").setCachePeriod(31556926); 
       registry.addResourceHandler("/fonts/**").addResourceLocations("/WEB-INF/resources/fonts/").setCachePeriod(31556926);
   }
}
