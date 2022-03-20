package githubmagovia.vzorovyprojekt.kniznica.customer;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomersController {
    private final CustomersService customersService;

    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    // POST Create
    @PostMapping("/api/customers")
    public CustomersEntity createCustomer(@RequestBody CustomersDto customer){
        return customersService.createCustomer(customer);
    }

    //GET - všetci
    @GetMapping("/api/customers")
    public List<CustomersDto> getAllCustomers(@RequestParam(required = false) String lastname){
        List<CustomersEntity> entities = customersService.getAllCustomers(lastname);
        List<CustomersDto> result = new ArrayList<>();
        for (CustomersEntity entity : entities) { result.add(mapToDto(entity)); }
        return result;
    }

    //GET - podla idcka
    @GetMapping("/api/customers/{customerId}")
    public CustomersDto getCustomerById(@PathVariable Long customerId) {
        return mapToDto(customersService.getCustomerById(customerId));
    }

    // UPDATE customer .. ok
    @PutMapping("/api/customers/{customerId}")
    public CustomersDto updateCustomer(@PathVariable Long customerId, @RequestBody CustomersDto customer) {
       return mapToDto(customersService.updateCustomer(customerId,customer));
    }

    // DELETE customers .. ok
    @DeleteMapping("/api/customers/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId) {
        customersService.deleteCustomer(customerId);
    }

    private CustomersDto mapToDto(CustomersEntity entity){
        CustomersDto customersDto = new CustomersDto();
        customersDto.setId(entity.getId());
        customersDto.setFirstName(entity.getFirstName());
        customersDto.setLastName(entity.getLastName());
        customersDto.setCustomerName(entity.getFirstName() + " " + entity.getLastName());
        customersDto.setContact(entity.getContact());
        return customersDto;
    }
}
