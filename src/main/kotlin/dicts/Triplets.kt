package dicts

class Triplets {
    fun countTripletsSlow(arr: Array<Long>, r: Long): Long {
        val dict = mutableMapOf<Long, MutableList<Int>>()
        for ((i, value) in arr.withIndex()) {
            dict[value] = (dict[value] ?: mutableListOf()).apply { add(i) }
        }
        var triplets = 0L
        for ((i, value) in arr.withIndex()) {
            val a1 = value * r
            val a2 = a1 * r
            val a1Indexes = dict[a1]
            val a2Indexes = dict[a2]
            if (a1Indexes == null) continue
            if (a2Indexes == null) continue
            for (j in a1Indexes) {
                if (j <= i) continue
                for ((a2Idx, k) in a2Indexes.withIndex()) {
                    if (k <= j) continue
                    triplets += (a2Indexes.size - a2Idx)
                    break
                }
            }
        }
        return triplets
    }

    fun countTriplets(arr: Array<Long>, r: Long): Long {
        var triplets = 0L
        val after = mutableMapOf<Long, Long>()
        for (value in arr) {
            after[value] = (after[value] ?: 0) + 1
        }
        val before = mutableMapOf<Long, Long>()

        for (j in arr) {
            after[j] = (after[j] ?: 0) - 1
            val i = j / r
            val k = j * r
            if (j % r == 0L) triplets += (before[i] ?: 0) * (after[k] ?: 0)
            before[j] = (before[j] ?: 0) + 1
        }
        return triplets
    }
}