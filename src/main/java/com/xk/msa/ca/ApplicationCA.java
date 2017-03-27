package com.xk.msa.ca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

 
/**
 * security with JWT Tokens
 * @author yanhaixun
 * @date 2017年3月18日 下午12:29:49
 *
 */
@SpringBootApplication(scanBasePackages = "com.xk.msa")
@EnableConfigurationProperties
public class ApplicationCA {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationCA.class, args);
	}
}
