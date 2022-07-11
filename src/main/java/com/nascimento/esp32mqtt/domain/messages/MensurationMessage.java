package com.nascimento.esp32mqtt.domain.messages;

import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class MensurationMessage {
    private String device;
    private Integer temperature;
    private Integer humidity;
    private Long timestamp;
}
