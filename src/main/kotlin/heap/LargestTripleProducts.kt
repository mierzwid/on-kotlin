package heap
//
//a [1]
//o [-1]
//
//a [1 2 3 4 5]
//o [-1 -1 6 24 60]
//
//a [2 1 2 1 2]
//o [-1 -1 4 4 8]

fun List<Int>.product(): Int {
    var product = 1
    for(n in this) {
        product *= n
    }
    return product
}

fun List<Int>.min(): Int {
    var min = 0
    for(n in this) {
        min = Math.min(min, n)
    }
    return min
}

fun findMaxProduct(args: Array<Int>): Array<Int> {
    val output = Array(args.size) { -1 }
    if(args.size < 3) return output
    val triple = mutableListOf(args[0], args[1], args[2])
    output[2] = triple.product()
    for(idx in 3..args.lastIndex) {
        if(args[idx] > triple.min()) {
            triple.remove(triple.min())
            triple.add(args[idx])
        }
        output[idx] = triple.product()
    }
    return output
}

//a [2 1 2 1 2]
//output [-1 -1 4 4 8]
//triple= [2, 2, 2]
//currentMin = 1
//idx = 4
//o [-1 -1 4 4 8]