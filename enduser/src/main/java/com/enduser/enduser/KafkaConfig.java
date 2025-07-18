package com.enduser.enduser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

    private Logger logger = LoggerFactory.getLogger(KafkaConfig.class);

    @KafkaListener(topics = "location-update-topic", groupId = "group-1")
    public void listenUpdatedLocation(String value) {
        this.logger.info("received location : " + value);
    }
}
