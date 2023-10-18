package ru.mipt.pdris.config;

import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mipt.pdris.decoder.ResponseEntityStringDecoder;
import ru.mipt.pdris.feign.ServiceClient;

@Configuration
public class ClientConfiguration {

    @Value("${urls.serviceOne}")
    private String serviceOne;

    @Value("${feign.logger.level:BASIC}")
    private String feignLoggerLevel;

    @Bean
    public ServiceClient serviceClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new ResponseEntityStringDecoder())
                .options(new Request.Options(1_000_000, 1_000_000))
                .logger(new Slf4jLogger(ServiceClient.class))
                .logLevel(Logger.Level.valueOf(feignLoggerLevel))
                .retryer(Retryer.NEVER_RETRY)
                .target(ServiceClient.class, serviceOne);

    }
}
