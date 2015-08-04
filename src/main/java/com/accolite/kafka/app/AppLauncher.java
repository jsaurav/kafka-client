package com.accolite.kafka.app;

import java.util.Date;
import java.util.Random;

import org.apache.kafka.clients.producer.ProducerRecord;

import com.accolite.kafka.producers.MessageProducer;

public class AppLauncher {

	//TOPIC NAME
	private static final String USER_ACTIVITY = "user_activity";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MessageProducer producer = new MessageProducer();
		while(true) {
			Random rnd = new Random();
			long runtime = new Date().getTime();
			String ip = "192.168.2." + rnd.nextInt(255);
			String msg = runtime + ",www.accolite.com," + ip;
			ProducerRecord<String,String> record = new ProducerRecord<String, String>(USER_ACTIVITY, 4, ip, msg);
			producer.send(record);
		}

	}

}
