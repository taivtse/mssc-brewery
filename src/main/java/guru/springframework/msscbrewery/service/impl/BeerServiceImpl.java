package guru.springframework.msscbrewery.service.impl;

import guru.springframework.msscbrewery.service.BeerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author taivo
 * @since 4/9/2020 5:01 PM
 */
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }
}
