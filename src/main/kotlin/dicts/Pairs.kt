package dicts

import math.factorial


fun numberOfWays(arr: Array<Int>, k: Int): Int {
    val counter = mutableMapOf<Int, Int>()
    for (value in arr) {
        counter[value] = (counter[value] ?: 0) + 1
    }
    var result = 0
    val used = mutableSetOf<Int>()
    for (integer in counter.keys) {
        if (used.contains(integer)) continue
        if (integer >= k) continue
        val second = k - integer
        if (integer == second) {
            val freq = counter[integer] ?: throw Exception()
            result += ((factorial(freq.toLong()) / factorial(freq - 2L)).toLong() / 2L).toInt()
            continue
        }
        if (counter[second] != null) {
            result += counter[integer]!! * counter[second]!!
            used.add(second)
        }
    }
    return result
}