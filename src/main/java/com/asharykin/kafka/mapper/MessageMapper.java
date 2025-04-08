package com.asharykin.kafka.mapper;

import com.asharykin.kafka.dto.MessageDTO;
import com.asharykin.kafka.entity.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    Message dtoToEntity(MessageDTO messageDTO);
}
