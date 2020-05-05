package com.isb.redis.consumerMurex.config;


import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import com.isb.redis.consumerMurex.jms.JmsMockConsumerOut;

/**
 * 
 * @author ftsaiz
 *
 */
@Configuration
@EnableJms
public class ReceiverActiveMqConfig {

	@Value("${eDerivatives.jms.in.url}")
	private String url;

	@Value("${eDerivatives.jms.in.username}")
	private String userName;

	@Value("${eDerivatives.jms.in.password}")
	private String password;
	
	@Value("${eDerivatives.jms.in.concurrency}")
	private String concurrency;

	@Bean
	public ConnectionFactory receiverActiveMQConnectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(url);
		connectionFactory.setPassword(password);
		connectionFactory.setUserName(userName);
		System.out.println("configurado receiverActiveMQConnectionFactory CONSUMIDOR_PRODUCTOR");
		return connectionFactory;
	}

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory receiverActiveMQConnectionFactory) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConcurrency(concurrency);
		factory.setConnectionFactory(receiverActiveMQConnectionFactory);
		return factory;
	}
	
	@Bean
	public JmsMockConsumerOut receiverOut() {
		return new JmsMockConsumerOut();
	}
}