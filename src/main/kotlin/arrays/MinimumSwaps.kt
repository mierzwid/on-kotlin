package arrays

class MinimumSwaps {
    // Minimum Swaps
//
//    [2,3,1,5,4]
//    [1,2,3,4,5]
//    [5,4,3,2,1]
//
//
//    a = [1,2,3,4,5]
//    p = [x,0,1,2,3,4]
//    swaps = 3
//    index = 4
//    value = 5
//    properValue = 5


    fun minimumSwaps(array: Array<Int>): Int {
        val positions = Array(array.size + 1) { -1 }
        var swaps = 0
        for ((index, value) in array.withIndex()) {
            positions[value] = index
        }
        for ((index, value) in array.withIndex()) {
            val properValue = index + 1
            if (value == properValue) continue
            swap(array, index, positions[properValue])
            swap(positions, value, properValue)
            swaps++
        }
        return swaps
    }

    fun swap(array: Array<Int>, idx1: Int, idx2: Int) {
        val tmp = array[idx1]
        array[idx1] = array[idx2]
        array[idx2] = tmp
    }


//Algorithm:
//    1 iterate over elements
//    if element at index is matching their destination
//    continue
//    else
//    find matching element in array and do the swap!
//
//    n = 100 000
//
//    complexity = O(n^2)


}