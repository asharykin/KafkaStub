package com.asharykin.kafka.service;

import com.asharykin.kafka.dto.RequestDTO;
import com.asharykin.kafka.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private static final String TOPIC = "postedmessages";

    private final KafkaTemplate<String, ResponseDTO> kafkaTemplate;

    public void sendMessage(RequestDTO requestDto, String method, String uri) {
        ResponseDTO responseDto = new ResponseDTO();
        responseDto.setMsgId(requestDto.getMsgId());
        responseDto.setTimestamp(System.currentTimeMillis());
        responseDto.setMethod(method);
        responseDto.setUri(uri);
        kafkaTemplate.send(TOPIC, responseDto);
    }
}

