package io.prime.web.dto;

import java.util.List;

public class PrimesResponse {

    private List<Integer> primes;

    public PrimesResponse(List<Integer> primes) {
        this.primes = primes;
    }

    public List<Integer> getPrimes() {
        return primes;
    }
}
