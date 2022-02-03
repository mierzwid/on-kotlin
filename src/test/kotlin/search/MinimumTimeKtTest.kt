package search

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class MinimumTimeKtTest {

    @Test
    fun `test getBillionUsersDay`() {
        assertEquals(1047, getBillionUsersDay(arrayOf(1.01F, 1.02F)))
    }
}