package com.deliveryboy.deliveryboy.control;

import com.deliveryboy.deliveryboy.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation() {
        this.kafkaService.updateLocation("latitude : " + Math.round(Math.random() * 100)
                + " , longitude : " + Math.round(Math.random() * 100));
        return new ResponseEntity<>(Map.of("message", "Location updated"), HttpStatus.OK);
    }
}
