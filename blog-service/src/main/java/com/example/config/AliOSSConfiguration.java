package com.example.config;

import com.example.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AliOssUtil属性的配置类
 */
@Configuration
@Slf4j
public class AliOSSConfiguration {
    @Bean
//    当你的bean被注册之后，如果注册相同类型的bean，就不会成功，它会保证你的bean只有一个，即你的实例只有一个。
//    如果不加@ConditionalOnMissingBean，当你注册多个相同的bean时，会出现异常，以此来告诉开发人员。
    @ConditionalOnMissingBean
    public AliOssUtil aliOssUtil(AliOssProperties aliOssProperties) {
        log.info("阿里云OSS实例化");
        return new AliOssUtil(aliOssProperties.getEndpoint(),
                aliOssProperties.getAccessKeyId(),
                aliOssProperties.getAccessKeySecret(),
                aliOssProperties.getBucketName());
    }
}

