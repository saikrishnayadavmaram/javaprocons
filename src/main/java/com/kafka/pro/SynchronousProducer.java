package com.kafka.pro;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

public class SynchronousProducer {

	public static void main(String[] args) {
		Properties pro = new Properties();
		// Setting properties
		pro.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		pro.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringSerializer");
		pro.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringSerializer");
		// creating object for producer

		KafkaProducer producer = new KafkaProducer(pro);
		// creating a record
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("KMC", "UPPAL");
				try {
				 producer.send(record).get(); 
				} catch (Exception e) {
				 e.printStackTrace();

	}

}
}