package graphs

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class GreaterThanTest {

    @Test
    fun `test greater than` () {
        assertTrue(GreaterThan().checkValidity("a>bc<ac>b"))
        assertTrue(GreaterThan().checkValidity(""))
        assertTrue(GreaterThan().checkValidity("a<b"))
        assertFalse(GreaterThan().checkValidity("a<bc<ac>b"))
    }
}