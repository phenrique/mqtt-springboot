package com.nascimento.esp32mqtt.domain.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository repository;

    public Flux<Device> findAll(){
        return repository.findAll();
    }

    public Mono<Device> save(Mono<Device> deviceMono) {
        return deviceMono.flatMap(repository::save);
    }
}
