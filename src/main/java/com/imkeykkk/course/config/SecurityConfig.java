package com.imkeykkk.course.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean   //简单来说这个方法返回一个我们需要的对象，但是我们不直接使用和管理对象，通过Spring容器管理实例对象
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();//为什么可以返回给PasswordEncoder类型呢，因为它是一个父类接口，从而实现多态和面向接口编程
    }
}
