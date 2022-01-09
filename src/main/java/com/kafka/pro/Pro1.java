package com.kmc.file;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.*;
import java.util.*;

public class Pro1 {

    public static void main(String[] args) throws IOException {
        Properties pro = new Properties();
        // Setting properties
        pro.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        pro.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        pro.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer ");
        // creating object for producer
        KafkaProducer producer = new KafkaProducer(pro);

        File file = new File("C:\\Users\\inmyada\\Test\\input.txt");
        Scanner scan = new Scanner(file);
        scan.useDelimiter("\\Z");

        ProducerRecord<String, String> record = new ProducerRecord<String, String>("sink", scan.next());

        System.out.print(record.value().toString());

        producer.send(record);
        producer.flush();
    }
}


