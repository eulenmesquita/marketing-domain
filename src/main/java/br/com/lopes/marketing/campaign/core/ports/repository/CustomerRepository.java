package br.com.lopes.marketing.campaign.core.ports.repository;

import br.com.lopes.marketing.campaign.core.model.Customer;

public interface CustomerRepository {
    Customer findById(String customerId);
}
