package com.mall.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new SessionHandlerInterceptor());
//        interceptorRegistration.excludePathPatterns("/error");
//        interceptorRegistration.excludePathPatterns("/static/**");
//        interceptorRegistration.excludePathPatterns("/login");
//
//        interceptorRegistration.addPathPatterns("/**");
//
//
//    }
//
//
//    private class SessionHandlerInterceptor implements HandlerInterceptor {
//        @Override
//        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//
//            Object user = request.getSession().getAttribute("user");
//            if (user == null) {
//                try {
//                    response.sendRedirect("/login");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                return false;
//            }
//            return true;
//        }
//    }
}

