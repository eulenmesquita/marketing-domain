package br.com.lopes.marketing.campaign.application.adapters.kafka;

import br.com.lopes.marketing.campaign.core.model.Campaign;
import br.com.lopes.marketing.campaign.core.ports.messaging.EventPublisher;

public class KafkaPublisher implements EventPublisher<Campaign> {

    @Override
    public void publish(Campaign payload, String topic) {
        System.out.printf("Simulating event for: " + payload.getClass().getSimpleName());
    }
}
