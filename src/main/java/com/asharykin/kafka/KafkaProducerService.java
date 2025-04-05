package com.asharykin.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private static final String TOPIC = "postedmessages";

    private final KafkaTemplate<String, ResponseDto> kafkaTemplate;

    public void sendMessage(RequestDto requestDto, String method, String uri) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMsgId(requestDto.getMsgId());
        responseDto.setTimestamp(System.currentTimeMillis());
        responseDto.setMethod(method);
        responseDto.setUri(uri);
        kafkaTemplate.send(TOPIC, responseDto);
    }
}

