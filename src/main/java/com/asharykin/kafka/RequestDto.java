package com.asharykin.kafka;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDto {
    @JsonProperty("msg_id")
    private String msgId;
}