package com.mall.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 说明：跨域请求
 *
 * @author WangBin
 * @version v1.0
 * @date 2019/3/10
 */
@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
 
	@Autowired
	private LoginInterceptor loginInterceptor;
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOrigins("*")
                //是否允许证书 不再默认开启
                .allowCredentials(true)
                //设置允许的方法
                .allowedMethods("*")
                //跨域允许时间
                .maxAge(3600);
    }
    
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".html");
        return viewResolver;
    }

    /**
     * SpringBoot设置首页
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        WebMvcConfigurer.super.addViewControllers(registry);
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/home").setViewName("index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/temp/img/**").addResourceLocations("file:D:/temp/img/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(
					"/user/login",
					"/user/register",
					"/user/logout",
					"/product/get/**",
					"/temp/img/**",
					"/index.html",
					"/js/**",
					"/img/**",
					"/css/**",
					"/fonts/**",
					"/",
					"/static/**"
				);
	}
	
	
}

