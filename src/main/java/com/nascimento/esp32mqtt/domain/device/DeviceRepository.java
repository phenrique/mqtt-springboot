package com.nascimento.esp32mqtt.domain.device;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface DeviceRepository extends ReactiveCrudRepository<Device, Integer> {

    Mono<Device> findByCode(String code);

}