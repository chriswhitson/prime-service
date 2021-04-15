package io.prime.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class PrimeCalculator {

    /**
     * Calculates all primes up to, and including, a given limit
     *
     * @param limit The maximum value to include in the list of primes. Must be greater than 2.
     * @return A {@link List} of all prime numbers up to the specified limit.
     */
    public List<Integer> calculatePrimes(int limit) {
        if (limit <= 2) {
            throw new IllegalArgumentException("limit must be greater than or equal to 2");
        }

        boolean[] primeFlags = new boolean[limit + 1];
        Arrays.fill(primeFlags, true);

        double limitSqrt = Math.sqrt(limit);
        for (int candidate = 2; candidate < limitSqrt; candidate++) {
            if (primeFlags[candidate]) {
                // all multiple of this prime number are not prime number, so negate their prime flag
                // start at candidate^2 as lower multiples will already have been negated.
                for (int compositeNum = candidate * candidate; compositeNum < primeFlags.length; compositeNum += candidate) {
                    primeFlags[compositeNum] = false;
                }
            }
        }

        final List<Integer> primes = new LinkedList<>();
        for (int prime = 2; prime < primeFlags.length; prime++) {
            if (primeFlags[prime]) {
                primes.add(prime);
            }
        }

        return primes;
    }
}
