package githubmagovia.vzorovyprojekt.kniznica;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomersController {

    private List<Customers> customers;

    public CustomersController() {
        this.customers = init();
    }

    private List<Customers> init() {
        this.customers = new ArrayList<>();

        Customers customer1 = new Customers();
        customer1.setFirstName("Janko");
        customer1.setLastName("Malý");
        customer1.setEmail("j.maly@example.com");
        customers.add(customer1);


        Customers customer2 = new Customers();
        customer2.setFirstName("Peter");
        customer2.setLastName("Veľký");
        customer2.setEmail("p.velky@example.com");
        customers.add(customer2);
        return customers;
    }

    // Create -POST
    @PostMapping("/api/customers")
    public String createCustomer(@RequestBody Customers customer){
        this.customers.add(customer);

        return "Customer s id: " + (this.customers.size() -1) +" vytvorený";
    }



    //GET - všetci
    @GetMapping("/api/customers")
    public List<Customers> getAllCustomers(@RequestParam(required = false) String lastname) {
        if(lastname == null) {
            return this.customers;
        }
        List<Customers> filteredCustomers = new ArrayList<>();
        for (Customers customers : customers) {
            if (customers.getLastName().equals(lastname)){
                filteredCustomers.add(customers);
            }
        }
        return filteredCustomers;

    }
    //GET - podla idcka
    @RequestMapping("/api/customers/{customerId}")
    public Customers getCustomerById(@PathVariable Integer customerId) {
        return this.customers.get(customerId);
    }

    // UPDATE customer
    @PutMapping("/api/customers/{customerId}")
    public void updateCustomer(@PathVariable Integer customerId, @RequestBody Customers customers) {
        this.customers.get(customerId).setFirstName(customers.getFirstName());
        this.customers.get(customerId).setLastName(customers.getLastName());
        this.customers.get(customerId).setEmail(customers.getEmail());
    }

    // DELETE customers
    @DeleteMapping("/api/customers/{customerId}")
    public void deleteCustomer(@PathVariable  Integer customerId) {
        this.customers.remove(this.customers.get(customerId));

    }
}
