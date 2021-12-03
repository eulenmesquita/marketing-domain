package br.com.lopes.marketing.campaign.core.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Campaign {
    private final Customer customer;
    private final Budget budget;
    private LocalDate startingDate;
    private LocalDate finishingDate;

    public Budget getBudget() {
        return this.budget;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public boolean isActive() {
        return startingDate != null && finishingDate != null;
    }

    public Campaign(Customer customer, Budget budget) {
        if (customer == null || budget == null) {
            throw new IllegalArgumentException("company and budget are required for a new campaign");
        }
        this.customer = customer;
        this.budget = budget;
    }

    public long daysToFinish() {
        if (!isActive()) {
            throw new IllegalStateException("campaign is not active");
        }
        if (LocalDate.now().isBefore(startingDate)) {
            throw new IllegalArgumentException("Campaign did not start yet");
        }
        return ChronoUnit.DAYS.between(startingDate, finishingDate);
    }

    public void activateBetween(LocalDate starting, LocalDate finishing) {
        if (finishing.isBefore(starting)) {
            throw new IllegalArgumentException("finishing date must be after starting date");
        }
        this.startingDate = starting;
        this.finishingDate = finishing;
    }
}
