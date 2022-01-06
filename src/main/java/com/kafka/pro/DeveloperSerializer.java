package com.kafka.pro;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.ByteBuffer;
import java.util.Map;


public class DeveloperSerializer implements Serializer<Developer> {
    private String encoding = "UTF8";

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // nothing to configure
    }

    @Override
    public byte[] serialize(String topic, Developer developer) {

        int sizeOfDeveloperName;
        int sizeOfDeveloperCompany;
        int sizeOfDeveloperDesignation;

        byte[] serializedDeveloperName;
        byte[] serializedDeveloperCompany;
        byte[] serializedDeveloperDesignation;

        try {
            if (developer == null)
                return null;
            serializedDeveloperName = developer.getName().getBytes(encoding);
            sizeOfDeveloperName = serializedDeveloperName.length;

            serializedDeveloperCompany = developer.getCompany().getBytes(encoding);
            sizeOfDeveloperCompany = serializedDeveloperCompany.length;

            serializedDeveloperDesignation = developer.getDesignation().getBytes(encoding);
            sizeOfDeveloperDesignation = serializedDeveloperDesignation.length;

            ByteBuffer buffer = ByteBuffer.allocate(4 + 4 + sizeOfDeveloperName + 4 + sizeOfDeveloperCompany + 4 + sizeOfDeveloperDesignation);
            buffer.putInt(sizeOfDeveloperName);
            buffer.put(serializedDeveloperName);
            buffer.putInt(sizeOfDeveloperCompany);
            buffer.put(serializedDeveloperCompany);
            buffer.putInt(sizeOfDeveloperDesignation);
            buffer.put(serializedDeveloperDesignation);
            return buffer.array();

        } catch (Exception e) {
            throw new SerializationException("Error when serializing Developer to byte[]");
        }
    }

    @Override
    public void close() {
        // nothing to do
    }

}

