package com.xk.msa.ca.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xk.msa.ca.entity.User;
import com.xk.msa.ca.security.UserService;
import com.xk.msa.ca.user.repository.UserRepository;

/**
 * 
 * @author yanhaixun
 * @date 2017年3月18日 下午12:29:41
 *
 */
@Service
public class DatabaseUserService implements UserService {
    private final UserRepository userRepository;
    
    @Autowired
    public DatabaseUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }
}
