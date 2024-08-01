package com.duynb.spring.eureka.gateway.service;

import com.duynb.spring.eureka.gateway.authentication.CustomUserDetails;
import com.duynb.spring.eureka.gateway.authentication.JwtTokenProvider;
import com.duynb.spring.eureka.gateway.constant.ConfigConstants;
import com.duynb.spring.eureka.gateway.exception.NotFoundException;
import com.duynb.spring.eureka.gateway.repository.UserRepository;
import com.duynb.spring.eureka.gateway.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Tìm kiếm tài khoản bằng username
     * @param username tên tài khoản
     * @return đối tượng user đã được custom phù hợp với spring security
     */
    @Override
    public CustomUserDetails loadUserByUsername(String username){
        if(Objects.isNull(username)){
            throw new IllegalArgumentException();
        }
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new NotFoundException(ConfigConstants.USER_NOT_FOUND_MESSAGE);
        }
        return new CustomUserDetails(user);
    }

    /**
     * tìm kiếm tài khoản bằng id
     * @param id id tài khoản
     * @return đối tượng user đã được custom phù hợp với spring security
     */
    @Transactional
    public UserDetails loadUserById(Integer id) {
        if(Objects.isNull(id)){
            throw new IllegalArgumentException();
        }
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException(ConfigConstants.USER_NOT_FOUND_MESSAGE)
        );

        return new CustomUserDetails(user);
    }
}
