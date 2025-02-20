package com.example.autopayplugin.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "autopay")
public class AutopayProperties {
    private Integer readTimeout;
    private Integer connectionTimeout;
    private String baseUrl;
    private String token;
    private String username;
    private String password;
    private Boolean simulate;
}
