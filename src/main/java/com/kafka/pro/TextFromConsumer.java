package com.kmc.file;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.*;
import java.util.Collections;
import java.util.Properties;

public class TextFromConsumer {


    public static void main(String[] args) throws IOException {
        // Setting Properties
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "progroup");
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        //creating kafka consumer object
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);


        consumer.subscribe(Collections.singletonList("sink"));

        // File file = new File("C:\\Users\\inmyada\\Test\\input.txt");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\inmyada\\Test\\output.txt");


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {

                bw.write("something");
                bw.newLine();
                System.out.println(record.value().toString());

            }
        }
    }
}