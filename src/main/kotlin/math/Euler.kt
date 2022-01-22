package math

class Euler {
    fun gcd(a: Int, b: Int): Int {
        var greater = Math.max(a, b)
        var smaller = Math.min(a, b)
        var field = greater * smaller
        while (field > 0) {
            val smallerSquare = smaller * smaller
            field -= smallerSquare
            if (field == 0) return smaller
            if (field >= smallerSquare) {
                greater = greater - smaller
            } else {
                val tmp = smaller
                smaller = greater - smaller
                greater = tmp
            }
        }
        throw Exception()
    }

    fun gcd2(a: Int, b: Int): Int {
        val greater = Math.max(a, b)
        val smaller = Math.min(a, b)
        return orderedGcd(smaller, greater)
    }

    tailrec fun orderedGcd(smaller: Int, greater: Int): Int {
        val remainder = greater % smaller
        if (remainder == 0) return smaller
        return orderedGcd(remainder, smaller)
    }
}