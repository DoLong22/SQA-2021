package spring.service.customer;

import spring.model.Customer;
import spring.model.DeclareInformation;
import spring.model.Register;

import java.util.List;

public interface CustomerService {

    Customer regisCustomer(Customer customer) ;

    Customer declareInformation(Customer customer) ;

    Customer findCustomerByEmailAndPassword(String email, String password);

    Customer findCustomerByIdCustomer(int id);

}
