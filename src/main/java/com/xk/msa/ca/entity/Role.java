package com.xk.msa.ca.entity;

/**
 * 
 * @author yanhaixun
 * @date 2017年3月18日 下午12:05:20
 *
 */
public enum Role {
    ADMIN, PREMIUM_MEMBER, MEMBER;
    
    public String authority() {
        return "ROLE_" + this.name();
    }
}
