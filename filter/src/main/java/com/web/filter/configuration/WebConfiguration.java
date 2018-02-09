package com.web.filter.configuration;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Create by yangshunfan
 * 2018/2/9 14:05
 */
//@Configuration用于定义配置类，可替换xml文件
@Configuration
public class WebConfiguration {

    /**
     * 这里就是自定义一个过滤器
     * RemoteIpFilter是Tomcat8提供的过滤器
     * @return
     */
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    /**
     * FilterRegistrationBean主要用来对servlet filter进行自定义配置
     * @return
     */
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("paramName","paramValue");
        filterRegistrationBean.setName("MyFilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    public class MyFilter implements Filter {
        //初始化配置的方法
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        /**
         * 这里进行具体的过滤
         * @param servletRequest
         * @param servletResponse
         * @param filterChain
         * @throws IOException
         * @throws ServletException
         */
        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            System.out.println("This is MyFilter.url:" + request.getRequestURI());
            //将请求转发给下一个过滤器
            filterChain.doFilter(servletRequest,servletResponse);
        }

        @Override
        public void destroy() {

        }
    }
}
