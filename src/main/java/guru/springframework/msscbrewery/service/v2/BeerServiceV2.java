package guru.springframework.msscbrewery.service.v2;

import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

/**
 * @author taivo
 * @since 04/09/2020 20:41
 */
public interface BeerServiceV2 {
    BeerDtoV2 getById(UUID beerId);

    BeerDtoV2 save(BeerDtoV2 beerDtoV2);

    void update(UUID beerId, BeerDtoV2 beerDtoV2);

    void deleteById(UUID beerId);
}
