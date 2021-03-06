package com.nascimento.esp32mqtt.domain.device;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Device {
    @Id
    private Long deviceId;
    private String code;
    private String description;
}
