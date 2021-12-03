package br.com.lopes.marketing.campaign.core.ports.repository;

import br.com.lopes.marketing.campaign.core.model.Campaign;

public interface CampaignRepository {
    Campaign create(Campaign campaign);
}
