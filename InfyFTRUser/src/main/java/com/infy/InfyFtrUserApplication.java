package com.infy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
@PropertySource("classpath:ValidationMessages.properties")
@EnableDiscoveryClient

public class InfyFtrUserApplication {

	
	 @Bean
	   public MessageSource messageSource() {
	        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	        messageSource.setBasename("classpath:ValidationMessages");
	        messageSource.setDefaultEncoding("UTF-8");
	        return messageSource;
	    }

	    @Bean
	    public LocalValidatorFactoryBean validator() {
	        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	        bean.setValidationMessageSource(messageSource());
	        return bean;
	    }

	    
	public static void main(String[] args) {
		SpringApplication.run(InfyFtrUserApplication.class, args);
	}

}
