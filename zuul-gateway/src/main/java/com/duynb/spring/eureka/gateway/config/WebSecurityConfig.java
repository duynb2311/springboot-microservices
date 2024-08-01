package com.duynb.spring.eureka.gateway.config;

import com.duynb.spring.eureka.gateway.authentication.JwtAuthenticationFilter;
import com.duynb.spring.eureka.gateway.constant.PermissionConstants;
import com.duynb.spring.eureka.gateway.constant.PermissionEnum;
import com.duynb.spring.eureka.gateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Map;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // Get AuthenticationManager Bean
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Password encoder, để Spring Security sử dụng mã hóa mật khẩu người dùng
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userService) // Cung cáp userservice cho spring security
                .passwordEncoder(passwordEncoder()); // cung cấp password encoder
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll();

        for (PermissionEnum permission : PermissionEnum.values()) {
            String name = permission.name();
            HttpMethod httpMethod = permission.getHttpMethod();
            String endPoint = permission.getEndPoint();

            http.authorizeRequests()
                    .antMatchers(httpMethod, endPoint).hasAuthority(name);
        }

        http
                .authorizeRequests()
                .anyRequest().authenticated() // Tất cả các request khác đều cần phải xác thực mới được truy cập
                .and()
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class); // Thêm một lớp Filter kiểm tra jwt

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**");
    }
}
