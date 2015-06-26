/**
 * 
 */
package net.xomak.openinitiative.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author Konstantin Danilov
 *
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableAutoConfiguration
@ComponentScan(basePackages = { "net.xomak.openinitiative.controller", "net.xomak.openinitiative.repository", "net.xomak.openinitiative.model" })
@EnableJpaRepositories(basePackages = { "net.xomak.openinitiative.repository" })
public class MvcConfig extends WebMvcConfigurerAdapter {
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    
    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        return bean;
    }
}
