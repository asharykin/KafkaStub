package com.asharykin.kafka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDTO {
    @JsonProperty("msg_id")
    private String msgId;
}