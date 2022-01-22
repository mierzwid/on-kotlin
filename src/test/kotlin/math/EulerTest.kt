package math

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test


internal class EulerTest {
    @Test
    fun `gcd test`() {
        assertEquals(5, Euler().gcd2(5, 5))
        assertEquals(5, Euler().gcd2(10, 5))
        assertEquals(1, Euler().gcd2(10, 1))
        assertEquals(1, Euler().gcd2(13, 6))
        assertEquals(12, Euler().gcd2(214748364, 21312324))
    }
}