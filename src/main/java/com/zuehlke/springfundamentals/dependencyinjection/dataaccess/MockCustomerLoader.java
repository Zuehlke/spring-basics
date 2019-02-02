package com.zuehlke.springfundamentals.dependencyinjection.dataaccess;

import com.zuehlke.springfundamentals.dependencyinjection.domain.Customer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@LocalAndMockProfileAreActive
@Primary
public class MockCustomerLoader implements CustomerLoader {

  @Override
  public Customer findById(String customerId) {
        return InMemoryDatabase.DATABASE.get(customerId);
  }
}
