package githubmagovia.vzorovyprojekt.kniznica.customer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {
    private final CustomersRepository customersRepository;

    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    // Create
    public CustomersEntity createCustomer(CustomersDto customersDto){
        CustomersEntity customersEntity = new CustomersEntity();
        customersEntity.setFirstName(customersDto.getFirstName());
        customersEntity.setLastName(customersDto.getLastName());
        customersEntity.setEmail(customersDto.getEmail());
        return this.customersRepository.save(customersEntity);
    }

    //GET - všetci
    public List<CustomersEntity> getAllCustomers(String lastname){
        List<CustomersEntity> full = customersRepository.findAll();
        if(lastname == null) { return full; }
        List<CustomersEntity> filtered = new LinkedList<>();
        for (CustomersEntity c : full){
            if (lastname.equals(c.getLastName())) { filtered.add(c); }
        }
        return filtered;
    }

    //GET by id
    public CustomersEntity getCustomerById(Long customerId) {
        Optional<CustomersEntity> customer = customersRepository.findById(customerId);
        return customer.orElse(null);
    }

    // UPDATE customer
    public void updateCustomer(Long customerId, CustomersDto customer) {
        Optional<CustomersEntity> c = customersRepository.findById(customerId);
        if (c.isPresent()) {
            c.get().setFirstName(customer.getFirstName());
            c.get().setLastName(customer.getLastName());
            c.get().setEmail(customer.getEmail());
        }
    }

    // DELETE customers
    public void deleteCustomer(Long customerId) {
        customersRepository.deleteById(customerId);
    }
}