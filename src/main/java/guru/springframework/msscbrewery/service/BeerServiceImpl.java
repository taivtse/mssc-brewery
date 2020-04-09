package guru.springframework.msscbrewery.service;

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
    public BeerDto getById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .name("Galaxy Cat")
                .style("Pale Ale")
                .build();
    }

    @Override
    public BeerDto save(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void update(UUID beerId, BeerDto beerDto) {

    }

    @Override
    public void deleteById(UUID beerId) {

    }
}
