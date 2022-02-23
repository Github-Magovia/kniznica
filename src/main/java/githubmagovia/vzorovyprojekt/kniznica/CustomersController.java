package githubmagovia.vzorovyprojekt.kniznica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomersController {

    public static List<Customers> customers;

    @Autowired
    private CustomersService customersService;

    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    // Create -POST
    @PostMapping("/api/customers")
    public String createCustomer(@RequestBody Customers customer){
        return customersService.createCustomer(customer);
    }



    //GET - všetci
    @GetMapping("/api/customers")
    public List<Customers> getAllCustomers(@RequestParam(required = false) String lastname) {
        return customersService.getAllCustomers(lastname);
    }
    //GET - podla idcka
    @RequestMapping("/api/customers/{customerId}")
    public Customers getCustomerById(@PathVariable Integer customerId) {
        return customersService.getCustomerById(customerId);
    }

    // UPDATE customer
    @PutMapping("/api/customers/{customerId}")
    public void updateCustomer(@PathVariable Integer customerId, @RequestBody Customers customer) {
        customersService.updateCustomer(customerId,customer);
    }

    // DELETE customers
    @DeleteMapping("/api/customers/{customerId}")
    public void deleteCustomer(@PathVariable  Integer customerId) {
        customersService.deleteCustomer(customerId);
    }
    // decrement id of customer
    private void decrementIds(int id){
        //TODO.... but IDK how
    }
}
