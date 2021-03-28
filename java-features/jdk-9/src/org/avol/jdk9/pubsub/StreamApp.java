package org.avol.jdk9.pubsub;

import org.avol.jdk9.pubsub.consumer.MessageSubscriber;

import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class StreamApp {

    public static void main(String[] args) {

        SubmissionPublisher<Message> publisher = new SubmissionPublisher<>();
        MessageSubscriber messageSubscriber = new MessageSubscriber();
        publisher.subscribe(messageSubscriber);

        IntStream.range(0, 10).forEach(i -> {
            Message message = new Message(i, "Message - " + i);
            publisher.submit(message);
        });

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        publisher.close();
    }
}
