package heap

import java.util.*
import kotlin.collections.ArrayList

// We don’t provide test cases in this language yet, but have outlined the signature for you. Please write your code below, and don’t forget to test edge cases!

fun main(args: Array<String>) {
    // Call maxCandies() with test cases here
}

class MaxHeap() {
    private val array = ArrayList<Int>()
    private var size = 0
    private fun sizeCheck() {
        if (size == 0) throw Exception()
    }

    fun peek(): Int {
        sizeCheck()
        return array[0]
    }

    fun poll(): Int {
        val tmp = peek()
        size--
        if (size > 0) {
            array[0] = array[size]
            heapifyDown(0)
        }
        return tmp
    }

    fun push(value: Int) {
        size++
        array[size - 1] = value
        heapifyUp(size - 1)
    }

    fun heapifyDown(index: Int) {
        if (!hasLeftChild(index)) return
        val greaterIndex = if (hasRightChild(index)
            && rightChildValue(index) > leftChildValue(index)
        ) {
            getRightChildIndex(index)
        } else {
            getLeftChildIndex(index)
        }
        if (array[index] >= array[greaterIndex]) return
        array.swap(index, greaterIndex)
        heapifyDown(greaterIndex)
    }

    private fun getRightChildIndex(index: Int): Int {
        TODO("Not yet implemented")
    }

    private fun leftChildValue(index: Int): Int {
        TODO("Not yet implemented")
    }

    private fun rightChildValue(index: Int): Int {
        TODO("Not yet implemented")
    }

    private fun hasRightChild(index: Int): Boolean {
        TODO("Not yet implemented")
    }

    private fun hasLeftChild(index: Int): Boolean {
        TODO("Not yet implemented")
    }

    private fun getLeftChildIndex(index: Int): Int {
        TODO("Not yet implemented")
    }

    fun heapifyUp(index: Int) {
        if (index == 0) return
        if (parentValue(index) >= array[index]) return
        array.swap(index, parentIndex(index))
        heapifyUp(parentIndex(index))
    }

    fun parentIndex(index: Int): Int {
        if (index == 0) throw Error()
        return (index - 1) / 2
    }

    fun parentValue(index: Int): Int {
        return array[parentIndex(index)]
    }
}

private fun <E> java.util.ArrayList<E>.swap(index: E, greaterIndex: E) {
    TODO("Not yet implemented")
}

fun maxCandies(arr: Array<Int>, k: Int): Int {
    val maxHeap = PriorityQueue<Int> { a, b -> b - a }
    for (bag in arr) {
        maxHeap.add(bag)
    }
    var eatenCandies = 0
    for (round in 1..k) {
        val bestBag = maxHeap.poll()
        eatenCandies += bestBag
        maxHeap.add(bestBag / 2)
    }
    return eatenCandies
}

//N bags
//Each bag i contines arr[i] candies
//It takes one miute to eat a bag
//As soon as you finish, bag refills with floor(x/2)
//you have k minutes to eat, how many you can eat?
//(k + N) log N