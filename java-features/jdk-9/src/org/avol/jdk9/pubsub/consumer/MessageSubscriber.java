package org.avol.jdk9.pubsub.consumer;

import org.avol.jdk9.pubsub.Message;

import java.util.concurrent.Flow;

public class MessageSubscriber implements Flow.Subscriber<Message> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Subscribed.");
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Message item) {
        System.out.println(item.getId() + " -> " + item.getMessage());
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Stream Completed.");
    }
}
