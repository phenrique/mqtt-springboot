package com.nascimento.esp32mqtt.domain.mensuration;

import com.nascimento.esp32mqtt.domain.device.Device;
import com.nascimento.esp32mqtt.domain.device.DeviceRepository;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MensurationService {

    @Autowired
    MqttPahoMessageDrivenChannelAdapter inboundAdapter;

    @Autowired
    Publisher<Message<byte[]>> mqttInFlow;
    @Autowired
    private MensurationRepository repository;

    public Flux<Mensuration> findAll(){
        return repository.findAll();
    }

    public void saveMqttMessage(){
        Flux<Message<byte[]>> flux =
                Flux.from(mqttInFlow)
                        .doOnSubscribe(s -> inboundAdapter.start())
                        .doOnTerminate(inboundAdapter::stop);
    }


}
