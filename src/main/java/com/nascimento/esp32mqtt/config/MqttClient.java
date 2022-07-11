package com.nascimento.esp32mqtt.config;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;

@Configuration
public class MqttClient {
    @Bean
    MqttPahoClientFactory clientFactory(@Value("${mqtt.server.eclipse.uri}") String brokerUri){
        var factory = new DefaultMqttPahoClientFactory();
        var options = new MqttConnectOptions();
        options.setServerURIs(new String[] {brokerUri});
        factory.setConnectionOptions(options);
        return factory;
    }
}
