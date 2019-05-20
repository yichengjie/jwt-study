package com.yicj.jwt.common.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yicj.jwt.common.web.interceptor.AuthenticationInterceptor;
import com.yicj.jwt.common.web.interceptor.TimeBasedAccessInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");    // 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
       /* registry.addInterceptor(timeBasedAccessInterceptor())
        .addPathPatterns("/**") ;*/
    }

    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
    
    @Bean
    public TimeBasedAccessInterceptor timeBasedAccessInterceptor() {
    	return new TimeBasedAccessInterceptor(9,12,"/api/login") ;
    }
}
