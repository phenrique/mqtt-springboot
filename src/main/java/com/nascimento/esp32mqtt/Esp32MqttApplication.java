package com.nascimento.esp32mqtt;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;

import java.beans.BeanProperty;

@SpringBootApplication
public class Esp32MqttApplication {

	public static void main(String[] args) {
		SpringApplication.run(Esp32MqttApplication.class, args);
	}

	@BeanProperty
	MqttPahoClientFactory clientFactory(@Value("${mqtt.server.eclipse.uri}") String brokerUri){
		var factory = new DefaultMqttPahoClientFactory();
		var options = new MqttConnectOptions();
		options.setServerURIs(new String[] {brokerUri});
		factory.setConnectionOptions(options);
		return factory;
	}
}