package com.asharykin.kafka;

import lombok.*;

@Getter
@Setter
@Data
public class ResponseDto {
    private String msgId;
    private long timestamp;
    private String method;
    private String uri;
}

