package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.service.BeerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
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
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        BeerDto beerDto = beerService.getById(beerId);
        return ResponseEntity.status(HttpStatus.OK).body(beerDto);
    }

    @PostMapping
    public ResponseEntity<BeerDto> createBeer(@RequestBody BeerDto beerDto) {
        BeerDto savedBeer = beerService.save(beerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/api/v1/beer/" + savedBeer.getId()));

        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(headers)
                .body(savedBeer);
    }

    @PutMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBeer(@PathVariable("beerId") UUID beerId,
                                     @RequestBody BeerDto beerDto) {
        beerService.update(beerId, beerDto);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBear(@PathVariable("beerId") UUID beerId) {
        beerService.deleteById(beerId);
    }
}
