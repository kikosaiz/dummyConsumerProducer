package com.isb.redis.consumerMurex.jms;


import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;

import com.isb.redis.consumerMurex.utils.ConstantMurex;

/**
 * Clase encargada de consumir mensajes de la cola
 * 
 * @author ftsaiz
 *
 */
public class JmsMockConsumerOut {

	private static int mensajesRecibidos = 0;

	@Autowired
	private JmsMockProducerIn jmsProducerIn;

	/**
	 * Objeto encargado de escribir trazas de log
	 */
	private Logger logger = LoggerFactory.getLogger(JmsMockConsumerOut.class);

	/**
	 * Método encargado de recibir mensajes de la cola
	 */
	@JmsListener(destination = "${eDerivatives.jms.in.queue.consumer}")
	public void messageReciber(String mensaje) {
 		//mensajesRecibidos++;
 		
		//System.out.println("se recibió en consumerMurex--> " + mensaje);
		
		String sResult = ConstantMurex.mapResult.get(getRandomNumberInRange(1, ConstantMurex.mapResult.size()));
		
		sResult = sResult.replaceAll(ConstantMurex.KEY_TO_REPLACE, ConstantMurex.KEY_TO_REPLACE + mensaje);

		System.out.printf("MUREX_Respondiendo: %s%n========", sResult);
		jmsProducerIn.send(sResult);

	}
	
	
	private static int getRandomNumberInRange(int min, int max) {

		Random r = new Random();
		return r.ints(min, (max + 1)).findFirst().getAsInt();

	}
	

}