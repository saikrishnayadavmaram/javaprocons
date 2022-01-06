package com.kafka.pro;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.ByteBuffer;
import java.util.Map;

public class DeveloperDeserializer implements Deserializer<Developer> {
    private String encoding = "UTF8";

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        //Nothing to configure
    }

    @Override
    public Developer deserialize(String topic, byte[] data) {
        try {
            if (data == null) {
                System.out.println("Null recieved at deserialize");
                return null;
            }
            ByteBuffer buffer = ByteBuffer.wrap(data);

            int sizeOfDeveloperName = buffer.getInt();
            byte[] developerNameBytes = new byte[sizeOfDeveloperName];
            buffer.get(developerNameBytes);
            String deserializedName = new String(developerNameBytes, encoding);


            int sizeOfDeveloperCompany = buffer.getInt();
            byte[] developerCompanyBytes = new byte[sizeOfDeveloperCompany];
            buffer.get(developerCompanyBytes);
            String deserializedCompany = new String(developerCompanyBytes, encoding);

            int sizeOfDeveloperDesignation = buffer.getInt();
            byte[] developerDesignationbytes = new byte[sizeOfDeveloperDesignation];
            buffer.get(developerDesignationbytes);
            String deserializedDesigantion = new String(developerDesignationbytes, encoding);

            return new Developer(deserializedName, deserializedCompany, deserializedDesigantion);

        } catch (Exception e) {
            throw new SerializationException("Error when deserialize byte[] to Developer");
        }

    }

    @Override
    public void close() {
    }
}

