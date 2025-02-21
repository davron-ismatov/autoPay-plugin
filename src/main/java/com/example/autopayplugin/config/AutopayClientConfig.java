package com.example.autopayplugin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.example.autopayplugin.constants.Constants.AUTOPAY_REST_TEMPLATE;

@Configuration
@EnableConfigurationProperties(AutopayProperties.class)
public class AutopayClientConfig {
    private final AutopayProperties autopayProperties;
    private final ObjectMapper objectMapper;


    public AutopayClientConfig(AutopayProperties autopayProperties, @Autowired @Qualifier("autopayObjectMapper") ObjectMapper objectMapper) {
        this.autopayProperties = autopayProperties;
        this.objectMapper = objectMapper;
    }

    @Bean(name = AUTOPAY_REST_TEMPLATE)
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .messageConverters(createMessageConverters())
                .interceptors(List.of(new AutopayRestTemplateInterceptor()))
                .requestFactory(this::clientHttpRequestFactory)
                .build();
    }

    private List<HttpMessageConverter<?>> createMessageConverters() {
        MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
        jsonMessageConverter.setObjectMapper(objectMapper);
        return List.of(jsonMessageConverter);
    }

    public ClientHttpRequestFactory clientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(autopayProperties.getConnectionTimeout());
        factory.setReadTimeout(autopayProperties.getReadTimeout());
        return factory;
    }
}
