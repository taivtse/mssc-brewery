package guru.springframework.msscbrewery.service;

import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

/**
 * @author taivo
 * @since 4/9/2020 4:57 PM
 */
public interface CustomerService {
    CustomerDto getById(UUID customerId);

    CustomerDto save(CustomerDto beerDto);

    void update(UUID customerId, CustomerDto beerDto);

    void deleteById(UUID customerId);
}
