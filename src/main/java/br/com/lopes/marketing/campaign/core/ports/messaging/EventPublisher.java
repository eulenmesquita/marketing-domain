package br.com.lopes.marketing.campaign.core.ports.messaging;

public interface EventPublisher<T> {

    void publish(T payload, String topic);
}
