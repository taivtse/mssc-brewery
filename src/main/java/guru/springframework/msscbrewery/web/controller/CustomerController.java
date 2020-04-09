package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.service.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

/**
 * @author taivo
 * @since 040/9/2020 16:47
 */
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {

        return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomerById(customerId));
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto savedCustomer = customerService.saveCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/api/v1/customer/" + savedCustomer.getId()));

        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(headers)
                .body(savedCustomer);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable("customerId") UUID customerId,
                                     @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerId, customerDto);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBear(@PathVariable("customerId") UUID customerId) {
        customerService.deleteById(customerId);
    }
}
