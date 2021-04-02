package spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import spring.model.Customer;
import spring.service.customer.CustomerService;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/customers")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService ;

    @PostMapping(produces = "application/json", value = "/signup")
    public ResponseEntity<?> regisCustomer(@Valid @RequestBody Customer customer){
        Customer customerAdded = this.customerService.regisCustomer(customer);
//        if (customerAdded != null){
            return new ResponseEntity<>(customerAdded, HttpStatus.CREATED);
//        }
//        else {
//            return new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
//        }
    }

    @PostMapping(produces = "application/json", value = "/signin")
    public ResponseEntity<?> signIn(@Valid @RequestBody String email, @Valid @RequestBody String password ){
        System.out.println(email + password);
        Customer customerAdded = this.customerService.findCustomerByEmailAndPassword(email, password);
        if (customerAdded != null){
        return new ResponseEntity<>(customerAdded, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Invald account", HttpStatus.SEE_OTHER);
        }
    }

    @PutMapping(produces = "application/json")
    public ResponseEntity<?> declareInformation(@RequestBody Customer customer){
        Customer customerUpdate = this.customerService.declareInformation(customer) ;
        if(customerUpdate != null){
            return new ResponseEntity<>(customerUpdate,HttpStatus.OK) ;
        }
        else {
            return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST) ;
        }
    }

//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<?> deleteCustomer(@PathVariable int id){
//        boolean doSucces = this.customerService.deleteCustomer(id) ;
//        if(doSucces == true){
//            return new ResponseEntity<>("delete successfull",HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
//        }
//    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ExceptionHandler({ ConstraintViolationException.class })
    public Map<String, String> handleConstraintViolation(
            ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            String fieldName = violation.getRootBeanClass().getName();
            String errorMessage = violation.getMessage();
            errors.put(fieldName, errorMessage);
        }
        return errors;
    }
//    @ExceptionHandler({ SQLIntegrityConstraintViolationException.class })
//    public Map<String, String> handleConstraintViolation(
//            SQLIntegrityConstraintViolationException ex) {
//        Map<String, String> errors = new HashMap<>();
//        System.out.println(ex.getLocalizedMessage());
//        for (ConstraintViolation<?> violation : ex.) {
//            String fieldName = violation.getRootBeanClass().getName();
//            String errorMessage = violation.getMessage();
//            errors.put(fieldName, errorMessage);
//        }
//        return errors;
//    }
}
