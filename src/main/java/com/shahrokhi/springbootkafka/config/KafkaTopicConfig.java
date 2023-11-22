package com.shahrokhi.springbootkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@EnableKafka
public class KafkaTopicConfig {

    @Value("${kafka.topic.name.sendSms}")
    private String sendSmsTopic;

    @Value("${kafka.topic.name.sendEmail}")
    private String sendEmailTopic;

    @Bean
    public NewTopic sendSmsTopic() {
        return TopicBuilder
                .name(sendSmsTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic sendEmailTopic() {
        return TopicBuilder
                .name(sendEmailTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }

}
