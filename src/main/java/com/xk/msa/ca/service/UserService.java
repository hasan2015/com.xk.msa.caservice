package com.xk.msa.ca.service;

import java.util.Optional;

import com.xk.msa.ca.entity.User;

/**
 * 
 * @author yanhaixun
 * @date 2017年3月18日 下午12:29:12
 *
 */
public interface UserService {
    public Optional<User> getByUsername(String username);
}
