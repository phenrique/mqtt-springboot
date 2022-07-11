package com.nascimento.esp32mqtt.config;

import com.google.gson.Gson;
import com.nascimento.esp32mqtt.domain.mensuration.Mensuration;
import com.nascimento.esp32mqtt.domain.mensuration.MensurationRepository;
import com.nascimento.esp32mqtt.domain.messages.MensurationMessage;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.messaging.Message;

@Configuration
public class MqttIn {

    @Autowired
    MensurationRepository repository;

//    @Bean
//    IntegrationFlow inboundFlow (MqttPahoMessageDrivenChannelAdapter inboundAdapter){
//        return IntegrationFlows
//                .from(inboundAdapter)
//                .handle((payload, headers) -> {
//                    System.out.println("new message: " + payload);
//                    return null;
//                })
//                .get();
//    }

    @Bean
    MqttPahoMessageDrivenChannelAdapter inboundAdapter (@Value("${mqtt.topic}") String topic, MqttPahoClientFactory clientFactory){
        return new MqttPahoMessageDrivenChannelAdapter("consumer", clientFactory, "ESP32Phcn/sensors");
    }

    @Bean
    public Publisher<Message<byte[]>> mqttInFlow(MessageProducerSupport adapter) {
        return IntegrationFlows.from(adapter)
                .transform(p -> p + ", received from MQTT")
                .log()
                .toReactivePublisher();
    }

}
