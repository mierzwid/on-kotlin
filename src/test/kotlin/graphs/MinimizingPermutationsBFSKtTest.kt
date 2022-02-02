package graphs

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class MinimizingPermutationsBFSKtTest {
    @Test
    fun `test bfs`() {
        assertEquals(2, minOperations(listOf(3, 1, 2)))
        assertEquals(0, minOperations(listOf(1)))
        assertEquals(1, minOperations(listOf(2, 1)))
        assertEquals(0, minOperations(listOf(1, 2, 3, 4, 5, 6, 7)))
        assertEquals(1, minOperations(listOf(7, 5, 4, 3, 2, 1)))
        assertEquals(2, minOperations(listOf(6, 3, 2, 5)))
    }
}