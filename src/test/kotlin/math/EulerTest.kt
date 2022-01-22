package math

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test


internal class EulerTest {
    @Test
    fun `gcd test`() {
        assertEquals(5, Euler().gcd(5,5))
        assertEquals(5, Euler().gcd(10,5))
        assertEquals(1, Euler().gcd(10,1))
        assertEquals(1, Euler().gcd(13,6))
        assertEquals(3, Euler().gcd(15,9))
    }
}