package arrays

class ArrayManipulation {

    fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
        val array = Array(n + 2) { 0L }
        for (query in queries) {
            array[query[0]] = array[query[0]] + query[2].toLong()
            array[query[1] + 1] = array[query[1] + 1] - query[2].toLong()
        }
        var max = 0L
        var current = 0L
        for (value in array) {
            current += value
            max = Math.max(current, max)
        }
        return max
    }
}