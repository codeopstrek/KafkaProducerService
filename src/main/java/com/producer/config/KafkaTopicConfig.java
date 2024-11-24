package com.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic commonTopic() {
        return TopicBuilder.name("common-topic")
                .partitions(1) // Set the desired number of partitions
                .replicas(1)   // Set the desired replication factor
                .build();
    }

    @Bean
    public NewTopic evenTopic() {
        return TopicBuilder.name("even-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic oddTopic() {
        return TopicBuilder.name("odd-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
