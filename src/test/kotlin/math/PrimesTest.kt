package math

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class PrimesTest {
    @Test
    fun `testing primes`() {
        assertEquals(2, Primes.sieveOfEratosthenes(2))
        assertEquals(3, Primes.sieveOfEratosthenes(4))
        assertEquals(5, Primes.sieveOfEratosthenes(6))
        assertEquals(6_700_417, Primes.sieveOfEratosthenes(6_700_418))
    }
}