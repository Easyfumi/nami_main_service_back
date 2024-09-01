/*
package ru.marinin.namiBackService.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class AtLeastOnceConsumer {

    public static void main(String[] str) throws InterruptedException {

        System.out.println("Starting AutoOffsetGuranteedAtLeastOnceConsumer ...");
        execute();
    }

    private static void execute() throws InterruptedException {

        KafkaConsumer<String, String> consumer = createConsumer();

        consumer.subscribe(Arrays.asList("normal-topic"));

        processRecords(consumer);
    }

    private static KafkaConsumer<String, String> createConsumer() {

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        String consumeGroup = "cg1";
        props.put("group.id", consumeGroup);

        props.put("enable.auto.commit", "true");

        props.put("auto.commit.interval.ms", "9999999");

        props.put("max.partition.fetch.bytes", "135");

        props.put("heartbeat.interval.ms", "3000");
        props.put("session.timeout.ms", "6001");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        return new KafkaConsumer<String, String>(props);
    }


    private static void processRecords(KafkaConsumer<String, String> consumer) throws InterruptedException {

        while (true) {

            ConsumerRecords<String, String> records = consumer.poll(100);
            long lastOffset = 0;

            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("\n\roffset = %d, key = %s, value = %s", record.offset(),
                        record.key(), record.value());
                lastOffset = record.offset();
            }

            System.out.println("lastOffset read: " + lastOffset);

            process();


            consumer.commitSync();
        }
    }

    private static void process() throws InterruptedException {
        Thread.sleep(20);
    }
}

*/