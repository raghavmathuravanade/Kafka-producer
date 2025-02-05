package com.example.Kafkaproducer;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class CustomPartitioner implements Partitioner {

    @Override
    public void configure(Map<String, ?> configs) {
        // Custom configuration logic, if needed
    }

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        // Custom logic to determine partition number
            int intkey = (Integer)key;
            return (int)intkey%2;
    }

    @Override
    public void close() {
        // Cleanup logic, if needed
    }
}
