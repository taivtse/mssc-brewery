package guru.springframework.msscbrewery.service.impl;

import guru.springframework.msscbrewery.service.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author taivo
 * @since 04/09/2020 17:53
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Vo Thanh Tai")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto beerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto beerDto) {

    }

    @Override
    public void deleteById(UUID customerId) {

    }
}
