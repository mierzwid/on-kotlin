package strings

class LongestCommonString {
    val cache = mutableMapOf<Pair<Int, Int>, Int>()
    fun dropDistinctCharacters(s1: String, s2: String): Pair<String, String> {
        var truncatedS1 = s1
        var truncatedS2 = s2
        for (char in 'A'..'Z') {
            truncatedS2 = if (!s1.contains(char)) s2.replace(char.toString(), "") else s2
            truncatedS1 = if (!s2.contains(char)) s1.replace(char.toString(), "") else s1
        }
        return truncatedS1 to truncatedS2
    }


    fun commonChild(s1Pointer: Int, s1Array: CharArray, s2Pointer: Int, s2Array: CharArray): Int {
        if (cache[s1Pointer to s2Pointer] != null) return cache[s1Pointer to s2Pointer] ?: throw IllegalStateException()
        val lcs = when {
            s1Pointer == s1Array.size -> 0
            s2Pointer == s2Array.size -> 0
            else -> {
                if (s1Array[s1Pointer] == s2Array[s2Pointer]) {
                    1 + commonChild(s1Pointer + 1, s1Array, s2Pointer + 1, s2Array)
                } else {
                    Math.max(
                        commonChild(s1Pointer, s1Array, s2Pointer + 1, s2Array),
                        commonChild(s1Pointer + 1, s1Array, s2Pointer, s2Array)
                    )
                }
            }
        }
        cache[s1Pointer to s2Pointer] = lcs
        return lcs
    }

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