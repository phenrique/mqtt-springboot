package com.nascimento.esp32mqtt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;

@Configuration
public class MqttIn {

    @Bean
    IntegrationFlow inboundFlow (MqttPahoMessageDrivenChannelAdapter inboundAdapter){
        return IntegrationFlows
                .from(inboundAdapter)
                .handle((payload, headers) -> {
                    System.out.println("new message: " + payload);
                    headers.forEach(((s, o) -> System.out.println(s + "=" + o)));
                    return null;
                })
                .get();
    }

    @Bean
    MqttPahoMessageDrivenChannelAdapter inboundAdapter (@Value("${mqtt.topic}") String topic, MqttPahoClientFactory clientFactory){
        return new MqttPahoMessageDrivenChannelAdapter("consumer", clientFactory, topic);
    }
}
