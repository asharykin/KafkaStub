package com.asharykin.kafka.controller;

import com.asharykin.kafka.service.KafkaProducerService;
import com.asharykin.kafka.dto.RequestDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/post-message")
    public ResponseEntity<Void> postMessage(@RequestBody RequestDTO requestDto, HttpServletRequest request) {
        kafkaProducerService.sendMessage(requestDto, request.getMethod(), request.getRequestURI());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/post-message/delay")
    public ResponseEntity<String> setDelay(@RequestParam int millis) {
        kafkaProducerService.setDelay(millis);
        return new ResponseEntity<>("New delay time for /post-message stub: " + millis + " ms", HttpStatus.OK);
    }

    @GetMapping("/post-message/delay")
    public ResponseEntity<String> getDelay() {
        int millis = kafkaProducerService.getDelay();
        return new ResponseEntity<>("Delay time for /post-message stub: " + millis + " ms", HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Void> handleException() {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

