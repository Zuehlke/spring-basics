package ch.zuehlke.springfundamentals.dependencyinjection.controller;

import ch.zuehlke.springfundamentals.dependencyinjection.dataaccess.CustomerLoader;
import ch.zuehlke.springfundamentals.dependencyinjection.service.CustomerService;
import ch.zuehlke.springfundamentals.dependencyinjection.service.EmailService;
import ch.zuehlke.springfundamentals.dependencyinjection.service.PostalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerController {

  private final EmailService emailService;
  private final PostalService postalService;
  private final CustomerLoader customerLoader;

  @Autowired
  public CustomerController(EmailService emailService, PostalService postalService, CustomerLoader customerLoader) {
    this.emailService = emailService;
    this.postalService = postalService;
    this.customerLoader = customerLoader;
  }

  public void deactivateCustomerAccount(String customerId) {
    CustomerService customerService = new CustomerService(emailService, postalService, customerLoader);
    customerService.deactivateCustomer(customerId);
  }
}
