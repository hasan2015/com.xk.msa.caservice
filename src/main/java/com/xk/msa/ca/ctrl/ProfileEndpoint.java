package com.xk.msa.ca.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xk.msa.ca.security.auth.JwtAuthenticationToken;
import com.xk.msa.ca.security.model.UserContext;

/**
 * End-point for retrieving logged-in user details.
 * 
 * @author yanhaixun
 * @date 2017年3月18日 下午12:16:58
 *
 */
@RestController
public class ProfileEndpoint {
	@RequestMapping(value = "/api/getuserinfo", method = RequestMethod.GET)
	public @ResponseBody UserContext get(JwtAuthenticationToken token) {
		return (UserContext) token.getPrincipal();
	}
}
