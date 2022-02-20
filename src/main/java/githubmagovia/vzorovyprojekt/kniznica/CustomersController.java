package githubmagovia.vzorovyprojekt.kniznica;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomersController {

    public static List<Customers> customers;

    public CustomersController() {
        customers = init();
    }

    private List<Customers> init() {
        customers = new ArrayList<>();

        Customers customer1 = new Customers();
        customer1.setFirstName("Janko");
        customer1.setLastName("Malý");
        customer1.setEmail("j.maly@example.com");
        customer1.setId(0);
        customers.add(customer1);


        Customers customer2 = new Customers();
        customer2.setFirstName("Peter");
        customer2.setLastName("Veľký");
        customer2.setEmail("p.velky@example.com");
        customer2.setId(1);
        customers.add(customer2);
        return customers;
    }

    // Create -POST
    @PostMapping("/api/customers")
    public String createCustomer(@RequestBody Customers customer){
        customer.setId(customers.size());
        customers.add(customer);
        return "Customer s id: " + (customers.size() -1) +" vytvorený";
    }



    //GET - všetci
    @GetMapping("/api/customers")
    public List<Customers> getAllCustomers(@RequestParam(required = false) String lastname) {
        if(lastname == null) {
            return customers;
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
        return customers.get(customerId);
    }

    // UPDATE customer
    @PutMapping("/api/customers/{customerId}")
    public void updateCustomer(@PathVariable Integer customerId, @RequestBody Customers customer) {
        customers.get(customerId).setFirstName(customer.getFirstName());
        customers.get(customerId).setLastName(customer.getLastName());
        customers.get(customerId).setEmail(customer.getEmail());
    }

    // DELETE customers
    @DeleteMapping("/api/customers/{customerId}")
    public void deleteCustomer(@PathVariable  Integer customerId) {
        decrementIds(customerId);
        customers.remove(customerId.intValue());

    }
    // decrement id of customer
    private void decrementIds(int id){
        int size = customers.size();
        int customerId = id + 1;
        while(customerId < size) {
            customers.get(customerId++).decrementId();
        }

    }
}
