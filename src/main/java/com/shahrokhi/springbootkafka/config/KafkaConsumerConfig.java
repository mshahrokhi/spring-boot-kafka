package com.shahrokhi.springbootkafka.config;

import com.shahrokhi.springbootkafka.model.SendEmailRequest;
import com.shahrokhi.springbootkafka.model.SendSmsRequest;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public Map<String, Object> commonConsumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName());
        return props;
    }

    @Bean
    public ConsumerFactory<String, SendSmsRequest> sendSmsConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(commonConsumerConfigs());
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, SendSmsRequest>> sendSmsFactory(
            ConsumerFactory<String, SendSmsRequest> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, SendSmsRequest> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }

    @Bean
    public ConsumerFactory<String, SendEmailRequest> sendEmailConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(commonConsumerConfigs());
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, SendEmailRequest>> sendEmailFactory(
            ConsumerFactory<String, SendEmailRequest> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, SendEmailRequest> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }
}
