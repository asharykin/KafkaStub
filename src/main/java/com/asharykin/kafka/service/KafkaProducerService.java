package com.asharykin.kafka.service;

import com.asharykin.kafka.dto.RequestDTO;
import com.asharykin.kafka.dto.MessageDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class KafkaProducerService {

    private static final String TOPIC = "postedmessages";

    private int delay;

    private final KafkaTemplate<String, MessageDTO> kafkaTemplate;

    @SneakyThrows
    public void sendMessage(RequestDTO requestDto, String method, String uri) {
        Thread.sleep(delay);

        MessageDTO messageDto = new MessageDTO();
        messageDto.setMsgId(requestDto.getMsgId());
        messageDto.setTimestamp(System.currentTimeMillis());
        messageDto.setMethod(method);
        messageDto.setUri(uri);

        kafkaTemplate.send(TOPIC, messageDto);
    }
}

