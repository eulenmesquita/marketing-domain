package br.com.lopes.marketing.campaign.core.service;

import br.com.lopes.marketing.campaign.core.model.*;
import br.com.lopes.marketing.campaign.core.model.exception.CampaignCreationException;
import br.com.lopes.marketing.campaign.core.ports.repository.BudgetRepository;
import br.com.lopes.marketing.campaign.core.ports.repository.CampaignRepository;
import br.com.lopes.marketing.campaign.core.ports.repository.CustomerRepository;
import br.com.lopes.marketing.campaign.model.fixtures.BudgetFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CampaignServiceTest {

    private CampaignService campaignService;
    @Mock
    private CampaignRepository campaignRepository;
    @Mock
    private BudgetRepository budgetRepository;
    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setup() {
        campaignService = new CampaignService(campaignRepository, budgetRepository, customerRepository);
    }

    @Test
    @DisplayName("it should fail when invalid budget and customer")
    void service_error_creating_campaign() {

        assertThrows(IllegalArgumentException.class, () -> {
            campaignService.createCampaign("one", "two");
        });
    }

    @Test
    @DisplayName("Should create a valid campaign")
    void service_create_campaign() {

        when(customerRepository.findById("one"))
                .thenReturn(new Customer("one", "My SuperCompany", Email.of("company@email.com")));

        when(budgetRepository.findById("two"))
                .thenReturn(BudgetFixture.valid());

        campaignService.createCampaign("one", "two");
    }

    @Test
    @DisplayName("Should fail when having error creating campaign")
    void service_create_campaign_with_error() {

        when(customerRepository.findById("one"))
                .thenReturn(new Customer("one", "My SuperCompany", Email.of("company@email.com")));

        when(budgetRepository.findById("two"))
                .thenReturn(BudgetFixture.valid());

        when(campaignRepository.create(any(Campaign.class)))
                .thenThrow(new RuntimeException("Oooops"));

        assertThrows(CampaignCreationException.class, () -> {
            campaignService.createCampaign("one", "two");
        });

    }

}