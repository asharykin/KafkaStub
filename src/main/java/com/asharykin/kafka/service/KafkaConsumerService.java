package com.asharykin.kafka.service;

import com.asharykin.kafka.dto.MessageDTO;
import com.asharykin.kafka.entity.Message;
import com.asharykin.kafka.mapper.MessageMapper;
import com.asharykin.kafka.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final MessageMapper messageMapper;

    private final MessageRepository messageRepository;

    @KafkaListener(topics = "postedmessages", groupId = "first_group")
    public void receiveMessage(MessageDTO messageDto) {
        Message messageEntity = messageMapper.dtoToEntity(messageDto);
        messageRepository.save(messageEntity);
    }
}
