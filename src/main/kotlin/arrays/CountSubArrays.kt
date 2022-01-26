package arrays

//[1, 3, 4, 2]
//output = [1 2 4 1]
//idx = 3
//value 2
//count = 1
//pointer = 4

fun countSubArrays(args: Array<Int>): Array<Int> {
    val output = Array(args.size) { 1 }
    for ((idx, value) in args.withIndex()) {
        var count = 1
        var pointer = idx - 1
        while (pointer >= 0 && args[pointer] < value) {
            count++
            pointer--
        }
        pointer = idx + 1
        while (pointer < args.size && args[pointer] < value) {
            count++
            pointer++
        }
        output[idx] = count
    }
    return output
}

//N^2
//
//[1, 3, 4, 2]
//[1, 2, 4, 1]
//
//[1]
//[1]