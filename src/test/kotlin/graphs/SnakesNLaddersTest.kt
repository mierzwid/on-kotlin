package graphs

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class SnakesNLaddersTest {
    @Test
    fun `test snakes`() {
        assertEquals(2, minMoves(13, mapOf(2 to 8, 6 to 2, 7 to 1)))
        assertEquals(3, minMoves(30, mapOf(
            27 to 1,
            3 to 22,
            17 to 4,
            5 to 8,
            19 to 7,
            21 to 9,
            11 to 26,
            20 to 29,
        )))
    }
}