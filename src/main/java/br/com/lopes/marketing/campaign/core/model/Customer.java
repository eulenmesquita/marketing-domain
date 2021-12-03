package br.com.lopes.marketing.campaign.core.model;

public class Customer {
    private final String id;
    private final String businessName;
    private final Email email;
    private String details;

    public Customer(String id, String businessName, Email email) {
        if (businessName == null || "".equals(businessName)) {
            throw new IllegalArgumentException("a customer requires a business name");
        }
        this.id = id;
        this.businessName = businessName;
        this.email = email;
    }

    public String getId() {
        return this.id;
    }

    public Email getEmail() {
        return this.email;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getBusinessName() {
        return businessName;
    }

}
