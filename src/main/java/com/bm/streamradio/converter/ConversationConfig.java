package com.bm.streamradio.converter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ConversationConfig {

    private Set<Converter> getConverters() {
        Set<Converter> converters = new HashSet<>();
        converters.add(new UserEntityToUserResponse());
        converters.add(new UserEntityToUserWithoutPasswordResponse());
        return converters;
    }

    @Bean
    public ConversionService conversationService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(getConverters());
        bean.afterPropertiesSet();
        return bean.getObject();
    }
}
