package strings

class LongestCommonString {
    fun dropDistinctCharacters(s1: String, s2: String): Pair<String, String> {
        var truncatedS1 = s1
        var truncatedS2 = s2
        for (char in 'A'..'Z') {
            truncatedS2 = if (!s1.contains(char)) s2.replace(char.toString(), "") else s2
            truncatedS1 = if (!s2.contains(char)) s1.replace(char.toString(), "") else s1
        }
        return truncatedS1 to truncatedS2
    }


    fun longestCommonString(
        s1: String,
        s2: String,
        s1Pointer: Int = 0,
        s2Pointer: Int = 0,
        cache: Array<Array<Int>> = Array(s1.length + 1) { Array(s2.length + 1) { -1 } }
    ): Int {
        if (cache[s1Pointer][s2Pointer] != -1) return cache[s1Pointer][s2Pointer]
        val lcs = when {
            s1Pointer == s1.length -> 0
            s2Pointer == s2.length -> 0
            else -> {
                if (s1[s1Pointer] == s2[s2Pointer]) {
                    1 + longestCommonString(s1, s2, s1Pointer + 1, s2Pointer + 1, cache)
                } else {
                    Math.max(
                        longestCommonString(s1, s2, s1Pointer, s2Pointer + 1, cache),
                        longestCommonString(s1, s2, s1Pointer + 1, s2Pointer, cache)
                    )
                }
            }
        }
        cache[s1Pointer][s2Pointer] = lcs
        return lcs
    }

//    HARRY
//    SALLY
//      H A R R Y
//    S 2 2 1 1 1 0
//    A 2 2 1 1 1 0
//    L 1 1 1 1 1 0
//    L 1 1 1 1 1 0
//    Y 1 1 1 1 1 0
//      0 0 0 0 0 0

    fun longestCommonString(s1: String, s2: String): Int {
        val result = Array(s1.length + 1) { Array(s2.length + 1) { 0 } }
        for (s1Pointer in s1.indices) {
            for (s2Pointer in s2.indices) {
                if (s1[s1Pointer] == s2[s2Pointer]) {
                    result[s1Pointer + 1][s2Pointer + 1] = result[s1Pointer][s2Pointer] + 1
                } else {
                    result[s1Pointer + 1][s2Pointer + 1] = Math.max(
                        result[s1Pointer + 1][s2Pointer], result[s1Pointer][s2Pointer + 1]
                    )
                }
            }
        }
        return result[s1.length][s2.length]
    }

}