package search

class Flavours {
    fun whatFlavors(costs: Array<Int>, money: Int): Unit {
        val complements = mutableMapOf<Int, Int>()
        for ((idx, cost) in costs.withIndex()) {
            if (complements.containsKey(cost)) {
                println("${complements[cost]} ${idx + 1}")
                return
            }
            val complement = money - cost
            if (complement <= 0) continue
            complements[complement] = idx + 1
        }
    }
}