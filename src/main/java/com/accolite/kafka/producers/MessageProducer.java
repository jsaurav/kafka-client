package com.accolite.kafka.producers;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

public class MessageProducer {

	static Properties clusterProps = new Properties();
	static KafkaProducer<String, String> producer = null;
	
	static {
		clusterProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9093,localhost:9094");
		clusterProps.put("serializer.class","kafka.serializer.StringEncoder");
		clusterProps.put("partitioner.class", "com.accolite.kafka.partitoners.SimplePartitioner");
		clusterProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		clusterProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		producer = new KafkaProducer<String, String>(clusterProps);
	}
	
	
	public void send(ProducerRecord<String, String> record) {
		producer.send(record);
	}
}
