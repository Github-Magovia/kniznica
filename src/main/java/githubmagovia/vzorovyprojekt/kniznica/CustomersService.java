package githubmagovia.vzorovyprojekt.kniznica;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomersService {
    private int idCounter = 0;
    private List<Customers> customers;

    public CustomersService() {
        customers = init();
    }

    private List<Customers> init() {
        customers = new ArrayList<>();

        Customers customer1 = new Customers();
        customer1.setFirstName("Janko");
        customer1.setLastName("Malý");
        customer1.setEmail("j.maly@example.com");
        customer1.setId(idCounter++);
        customers.add(customer1);

        Customers customer2 = new Customers();
        customer2.setFirstName("Peter");
        customer2.setLastName("Veľký");
        customer2.setEmail("p.velky@example.com");
        customer2.setId(idCounter++);
        customers.add(customer2);
        return customers;
    }

    // Create
    public String createCustomer(Customers customer){
        customer.setId(idCounter++);
        customers.add(customer);
        return "Customer s id: " + (idCounter - 1) +" vytvorený";
    }

    //GET - všetci
    public List<Customers> getAllCustomers(String lastname) {
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

    //GET by id
    public Customers getCustomerById(Integer customerId) { return findCustomer(customerId); }

    // UPDATE customer
    public void updateCustomer(Integer customerId, Customers customer) {
        Customers c = findCustomer(customerId);
        if (c != null) {
            c.setFirstName(customer.getFirstName());
            c.setLastName(customer.getLastName());
            c.setEmail(customer.getEmail());
        }
    }

    // DELETE customers
    public void deleteCustomer(Integer customerId) { customers.remove(findCustomer(customerId)); }

    private Customers findCustomer(int id) {
        for (Customers c : customers) {
            if (c.getId() == id) { return c; }
        }
        return null;
    }
}