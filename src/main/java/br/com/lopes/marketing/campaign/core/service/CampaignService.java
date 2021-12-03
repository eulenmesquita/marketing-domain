package br.com.lopes.marketing.campaign.core.service;

import br.com.lopes.marketing.campaign.core.model.exception.CampaignCreationException;
import br.com.lopes.marketing.campaign.core.ports.repository.BudgetRepository;
import br.com.lopes.marketing.campaign.core.ports.repository.CampaignRepository;
import br.com.lopes.marketing.campaign.core.ports.repository.CustomerRepository;
import br.com.lopes.marketing.campaign.core.model.Budget;
import br.com.lopes.marketing.campaign.core.model.Campaign;
import br.com.lopes.marketing.campaign.core.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CampaignService {

    private final CampaignRepository campaignRepository;
    private final BudgetRepository budgetRepository;
    private final CustomerRepository customerRepository;

    private final Logger log = LoggerFactory.getLogger(CampaignService.class);

    public CampaignService(CampaignRepository campaignRepository,
                           BudgetRepository budgetRepository,
                           CustomerRepository customerRepository) {
        this.campaignRepository = campaignRepository;
        this.budgetRepository = budgetRepository;
        this.customerRepository = customerRepository;
    }

    public void createCampaign(String customerId, String budgetId) {

        Budget budget = budgetRepository.findById(budgetId);
        Customer customer = customerRepository.findById(customerId);

        Campaign campaign = new Campaign(customer, budget);
        try {
            campaignRepository.create(campaign);
        } catch (Exception e) {
            log.error("persistence error", e);
           throw new CampaignCreationException("Error creating campaign");
        }

    }

}
