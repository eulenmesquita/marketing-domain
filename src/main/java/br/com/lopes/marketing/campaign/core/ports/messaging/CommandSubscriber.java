package br.com.lopes.marketing.campaign.core.ports.messaging;

public interface CommandSubscriber {

    void subscribe(String topic);
}
