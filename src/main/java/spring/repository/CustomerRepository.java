package spring.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Override
    Page<Customer> findAll(Pageable pageable);
    Customer findByMasoKh(String idCustomer);
    Customer findByEmailAndPassword(String email, String password);
}
