package com.example.apigateway.ratelimit;

import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.repository.DefaultRateLimiterErrorHandler;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.repository.RateLimiterErrorHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Date 2020/5/20
 * @Time 18:01
 */
@Component
@Slf4j
public class RateLimiterErrorConfig {
 
    /**
     * 重新定义RateLimiterErrorHandler 
     * 可以进行日志捕捉或者其他操作
     * @return
     */
    @Bean
    public RateLimiterErrorHandler rateLimitErrorHandler() {
        return new DefaultRateLimiterErrorHandler() {
            /**
             * 往redis存储限流请求信息的时候报错的处理，此方法一般不用重写
             *
             * @param key
             * @param e
             */
            @Override
            public void handleSaveError(String key, Exception e) {
                log.info("===>rateLimiter redisKey 存储出错:{}！！ ", e);
                super.handleSaveError(key, e);
            }
 
            /**
             * 从redis取出限流请求信息的时候报错的处理，此方法一般不用重写
             *
             * @param key
             * @param e
             */
            @Override
            public void handleFetchError(String key, Exception e) {
                super.handleFetchError(key, e);
            }
 
            /**
             * 请求发生限流了，或者限流过程中发生错误了的处理
             * 对限流进行日志记录，返回限流的信息等，方便后期分析日志排查问题，这里就简单处理打印日志
             *
             * @param msg
             * @param e
             */
            @Override
            public void handleError(String msg, Exception e) {
                log.error("限流信息msg={}，错误信息e={}", e);
                super.handleError(msg, e);
            }
        };
    }
}
