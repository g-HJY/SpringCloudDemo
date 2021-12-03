package com.example.apigateway.ratelimit;

import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.DefaultRateLimitKeyGenerator;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.RateLimitKeyGenerator;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.support.RateLimitUtils;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * 重写Key定义
 *
 * @Date 2020/5/19
 * @Time 18:16
 */
@Configuration
public class RateLimitConfig {
    /**
     * 为了针对地址+用户进行限流,重新定义RateLimitKey
     * 配置中已定义 ratelimit.xxx.type=url,并且在原先key中追加消息头中的token字段加以实现 
     * @param properties
     * @param rateLimitUtils
     * @return
     */ 
    @Bean
    public RateLimitKeyGenerator rateLimitKeyGenerator(final RateLimitProperties properties, final RateLimitUtils rateLimitUtils) {
 
        return new DefaultRateLimitKeyGenerator(properties, rateLimitUtils) {
            @Override
            public String key(final HttpServletRequest request, final Route route, final RateLimitProperties.Policy policy) {
                //String key = super.key(request, route, policy) + ":" + request.getHeader("token");
                String key = super.key(request, route, policy) + ":" + request.getParameter("token");
                return key;
            }
        };
    }
}
