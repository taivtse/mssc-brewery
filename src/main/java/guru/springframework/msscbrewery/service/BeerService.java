package guru.springframework.msscbrewery.service;

import guru.springframework.msscbrewery.web.model.BeerDto;

import java.util.UUID;

/**
 * @author taivo
 * @since 4/9/2020 4:57 PM
 */
public interface BeerService {
    BeerDto getById(UUID beerId);

    BeerDto save(BeerDto beerDto);

    void update(UUID beerId, BeerDto beerDto);

    void deleteById(UUID beerId);
}
