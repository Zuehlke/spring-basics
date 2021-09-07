package ch.zuehlke.springfundamentals.dependencyinjection;

import ch.zuehlke.springfundamentals.dependencyinjection.controller.CustomerController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Application {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

    CustomerController customerController = context.getBean(CustomerController.class);

    customerController.deactivateCustomerAccount("1");
  }
}
