package com.nascimento.esp32mqtt.domain.mensuration;

import com.nascimento.esp32mqtt.domain.device.Device;
import com.nascimento.esp32mqtt.domain.device.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MensurationService {
    @Autowired
    private MensurationRepository repository;

    public Flux<Mensuration> findAll(){
        return repository.findAll();
    }


}
