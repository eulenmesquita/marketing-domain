package br.com.lopes.marketing.campaign.core.ports.repository;

import br.com.lopes.marketing.campaign.core.model.Budget;

public interface BudgetRepository {
    Budget create(Budget budget);

    Budget findById(String budgetId);
}
