package com.offcn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        /**
         * 这句话的意思是 将/Users/guoyongsheng/Documents/develop/image_server 文件下的内容访问都映射到
         * /myPic/** 项目根目录/myPic/路径下面
         */
        registry.addResourceHandler("/myPic/**").addResourceLocations("file:/Users/guoyongsheng/Documents/develop/image_server/");
    }
}
