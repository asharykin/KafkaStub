package com.asharykin.kafka.dto;

import lombok.*;

@Getter
@Setter
public class ResponseDTO {
    private String msgId;
    private long timestamp;
    private String method;
    private String uri;
}

