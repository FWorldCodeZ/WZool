package com.fworldcodez.wzool.config;


import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DruidConfig {

    @Bean
    public ServletRegistrationBean druidStatView() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new StatViewServlet());
        registration.addUrlMappings("/druid/*");
        return registration;
    }

    @Bean
    public FilterRegistrationBean druidWebStatFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new WebStatFilter());
        registration.addInitParameter("exclusions","/css/*,/style/*,/js/*,*.js,*.css,/druid*,/attached/*,*.jsp");
        registration.addInitParameter("principalSessionName","sessionUser");
        registration.addInitParameter("profileEnable","true");
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        return registration;
    }
}
