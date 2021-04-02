package spring.service.customer;
import com.devskiller.friendly_id.FriendlyId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.model.Customer;
import spring.model.DeclareInformation;
import spring.model.Register;
import spring.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServicelml implements CustomerService{

    private static final Logger logger = LoggerFactory.getLogger(CustomerServicelml.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private String generateId(){
        String friendId = FriendlyId.createFriendlyId();

        return friendId;
    }

//    @Override
//    public List<Customer> getAllCustomer(int page) {
//        List<Customer> listCustomer = this.customerRepository.findAll(PageRequest.of(page, 20)).getContent();
//        logger.info("Customer: {}", listCustomer);
//        return listCustomer ;
//    }



    @Override
    public Customer regisCustomer(Customer customer) {
        customer.setMasoKh(generateId());
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer declareInformation(Customer customer) {
        Customer updateCustomer=null;
        if (checkCutomerExist(customer.getId())){
            updateCustomer = customerRepository.save(customer);
        }
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer findCustomerByEmailAndPassword(String email, String password) {
        return this.customerRepository.findByEmailAndPassword(email, password);
    }

    private boolean checkCutomerExist(int roomId){
        Customer customerExist = customerRepository.findById(roomId).orElse(null);
        if (customerExist == null){
            return false;
        }
        return true;
    }


    @Override
    public Customer findCustomerByIdCustomer(int id) {
        return null;
    }
}
