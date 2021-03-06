package io.prime.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PrimeCalculatorTest {

    private final PrimeCalculator underTest = new PrimeCalculator();

    @Test
    void shouldNotAllowLimitBelowTwo() {
        assertThatIllegalArgumentException().isThrownBy(() -> underTest.calculatePrimes(1));
    }

    @Test
    void shouldReturnTwoIfLimitIs2() {
        List<Integer> primes = underTest.calculatePrimes(2);

        assertThat(primes)
                .containsExactly(2);
    }

    @Test
    void shouldReturnListOfPrimes() {
        List<Integer> primes = underTest.calculatePrimes(30);

        assertThat(primes)
                .containsExactly(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
    }

    @Test
    void shouldNotReturnLimitIfLimitIsASquareOfAPrime() {
        // edge case found where if the limit is a square of a prime, it was returning the limit
        List<Integer> primes = underTest.calculatePrimes(9);

        assertThat(primes)
                .containsExactly(2, 3, 5, 7);
    }

    @Test
    void shouldReturnLimitIfLimitIsAPrime() {
        List<Integer> primes = underTest.calculatePrimes(11);

        assertThat(primes)
                .containsExactly(2, 3, 5, 7, 11);
    }

}
