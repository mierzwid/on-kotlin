package graphs

import java.util.*
import kotlin.collections.HashSet

fun minOperations(list: List<Int>): Int {
    val sorted = list.sorted()
    val queue = LinkedList<Pair<List<Int>, Int>>()
    val visited = HashSet<List<Int>>()
    queue.add(list to 0)
    visited.add(list)
    while (queue.isNotEmpty()) {
        val (current, count) = queue.poll()
        if (current == sorted) return count
        for (i in 0 until current.lastIndex) {
            for (j in (i + 1)..current.lastIndex) {
                val candidate = current.reverseBetween(i, j)
                if (visited.contains(candidate)) continue
                queue.add(candidate to count + 1)
                visited.add(candidate)
            }
        }
    }
    throw IllegalStateException()
}

fun List<Int>.reverseBetween(i: Int, j: Int): List<Int> {
    val new = LinkedList(this)
    var left = i
    var right = j
    while (left <= j && right >= i) {
        new[left] = this[right]
        left++
        right--
    }
    return new
}