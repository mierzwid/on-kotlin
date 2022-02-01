package greedy

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class LuckBalanceKtTest {

    @Test
    fun `test my luck`() {
        assertEquals(8, luckBalance(1, arrayOf(
            arrayOf(5,1),
            arrayOf(1,1),
            arrayOf(4,0),
        )))
    }
}