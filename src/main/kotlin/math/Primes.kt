package math

class Primes {
    companion object {
        fun sieveOfEratosthenes(max: Int): Int {
            val flags = Array(max + 1) { true }
            flags[0] = false
            flags[1] = false
            var prime = 2
            while (prime <= Math.sqrt(max.toDouble())) {
                for (n in prime * prime..max step prime) flags[n] = false
                var next = prime + 1
                while (next < flags.size && !flags[next]) next++
                if (next == flags.size) return prime
                prime = next
            }
            var next = prime + 1
            while (next < flags.size) {
                if (flags[next]) prime = next
                next++
            }
            return prime
        }
//    numbers = [0      1     2     3   4     5    6      7  ]
//    flags =   [false false true true false true  false true]
        // max = 7
        // prime = 5
        //
        // n 9
        // next = 5
    }
}