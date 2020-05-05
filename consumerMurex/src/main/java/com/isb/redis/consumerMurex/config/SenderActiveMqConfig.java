package com.isb.redis.consumerMurex.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

/**
 * Clase de configuración para enviar y recibir mensajes a la cola
 * @author ftsaiz
 *
 */
@Configuration
public class SenderActiveMqConfig {
 
  @Value("${eDerivatives.jms.out.url}")
  String url;
  
  @Value("${eDerivatives.jms.out.username}")
  String userName;
  
  @Value("${eDerivatives.jms.out.password}")
  String password;
 
  /*
   * Bean de configuración a la cola 
   */
    @Bean
    public ConnectionFactory senderActiveMQConnectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(url);
        connectionFactory.setUserName(userName);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }
    
    @Bean
    public CachingConnectionFactory cachingConnectionFactory() {
      return new CachingConnectionFactory(
    		  senderActiveMQConnectionFactory());
    }

    @Bean
    public JmsTemplate jmsTemplate() {
      return new JmsTemplate(cachingConnectionFactory());
    }
    
    /*
     * Usado para enviar mensajes desde ProducerJmsMockTest
     */
    @Bean
    @Autowired
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory){
        JmsTemplate template = new JmsTemplate();
//        template.setMessageConverter(jacksonJmsMessageConverter());
        template.setConnectionFactory(connectionFactory);
        return template;
    }
    

}
