package graphs

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class GreaterThanTest {

    @Test
    fun `test greater than` () {
        assertFalse(GreaterThan().checkValidityDFS("a>bb>cc>ad>a"))
        assertTrue(GreaterThan().checkValidityDFS("a>bc<ac>b"))
        assertTrue(GreaterThan().checkValidityDFS(""))
        assertTrue(GreaterThan().checkValidityDFS("a<b"))
        assertFalse(GreaterThan().checkValidityDFS("a<bc<ac>b"))
    }
}