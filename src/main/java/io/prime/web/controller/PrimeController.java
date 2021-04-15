package io.prime.web.controller;

import io.prime.service.PrimeCalculator;
import io.prime.web.dto.PrimesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

@Validated
@RestController
@RequestMapping(value = "primes", produces = MediaType.APPLICATION_JSON_VALUE)
public class PrimeController {

    private final PrimeCalculator primeCalculator;

    @Autowired
    public PrimeController(PrimeCalculator primeCalculator) {
        this.primeCalculator = primeCalculator;
    }

    @GetMapping
    public PrimesResponse calculatePrimes(@RequestParam("limit")
                                          @Min(value = 2, message = "Limit must be greater than or equal to 2") Integer limit) {
        return new PrimesResponse(primeCalculator.calculatePrimes(limit));
    }

}
