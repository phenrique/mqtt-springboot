package com.nascimento.esp32mqtt.domain.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("devices")
public class DeviceController {
    @Autowired
    private DeviceService service;

    @GetMapping
    public Flux<Device> findAll(){
        return service.findAll();
    }

    @PostMapping
    public Mono<Device> save(@RequestBody Mono<Device> deviceMono){
        return service.save(deviceMono);
    }
}
