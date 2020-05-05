package com.isb.redis.consumerMurex.jms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * Clase encargada de enviar mensajes
 * @author ftsaiz
 *
 */
@Component
public class JmsMockProducerIn {
	@Autowired
	JmsTemplate jmsTemplate;

	@Value("${eDerivatives.jms.out.queue.producer}")
	String queue;

	/**
	 * Método encargado de enviar mensaje a cola MQ
	 */
	public void send(String mensaje) {
		jmsTemplate.convertAndSend(queue, mensaje);
	}

}
