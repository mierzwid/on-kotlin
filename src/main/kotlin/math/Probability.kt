package math

import java.math.BigDecimal
import java.math.MathContext

fun main() {
    //49C6 / 49C49 = 49P6/6! / 49! = 1/(43!*6!)
    val combinations = factorial(49).divide(factorial(43) * factorial(6), MathContext.DECIMAL128)
    val p = BigDecimal.ONE.divide(combinations, MathContext.DECIMAL128)
    println("attempts: ${BigDecimal.ONE.divide(p, MathContext.DECIMAL128)}")

    //1/4P4
    //1/24 - all good
    // 4P2 - 2 good
}

fun factorial(n: Long): BigDecimal {
    return when (n) {
        1L -> BigDecimal.ONE
        else -> BigDecimal(n) * factorial(n - 1)
    }


}