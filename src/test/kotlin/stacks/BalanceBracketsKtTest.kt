package stacks

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BalanceBracketsKtTest {

    @Test
    fun `balance brackets` () {
        assertEquals(true, isBalanced("{[()]}"))
        assertEquals(true, isBalanced("{[()]}{[()]}()[][{}]"))
        assertEquals(true, isBalanced(""))
        assertEquals(false, isBalanced("{[(])}"))
        assertEquals(false, isBalanced("{[(a])}"))
        assertEquals(false, isBalanced("[d]"))
    }
}