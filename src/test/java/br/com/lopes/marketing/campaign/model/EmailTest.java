package br.com.lopes.marketing.campaign.model;

import br.com.lopes.marketing.campaign.core.model.Email;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailTest {

    @Test
    @DisplayName("should accept a valid e-email address")
    void email_validEmail() {
        final String emailAddress = "user@email.com";
        Email email = new Email(emailAddress);

        assertThat(email.toString()).isEqualTo(emailAddress);
    }

    @Test
    @DisplayName("should fail when is invalid e-mail address")
    void email_invalidEmail() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Email("invalid email@.com");
        });

        assertThat(exception.getMessage()).isEqualTo("invalid e-mail address");
    }

    @Test
    @DisplayName("factory method should create a new email")
    void email_factoryMethod() {
        final String emailAddress = "user@email.com";
        Email email = Email.of(emailAddress);
        assertThat(email.toString()).isEqualTo(emailAddress);
    }

}