import kotlin.math.abs

//
//
//abc is valid
//abcc is valid by removing one char
//abccc is not valid, because removing one char won't make frequency equal
//
//test cases:
//aabbcd -> NO
//
//aabbccddeefghi -> NO
//
//test cases:
//caabbccdd -> YES
//
//[c: 3, a: 2, b: 2, d: 2]
//
//3: [c] 2: [a, b, d]
//
//1) simply count char frequencies
//2) group values of frequencies distinct
//3) more than 2 groups -> NO
//4) 1 group -> YES
//5) 2 groups -> |a - b| > 1 -> NO
//6) fist group no of members > 1 && second group no of members > 1 -> NO
//else YES

fun isValid(s: String): String {
    val frequencies = mutableMapOf<Char, Int>()
    for(char in s.toCharArray()) {
        frequencies[char] = (frequencies[char] ?: 0) + 1
    }
    val byValue = mutableMapOf<Int, List<Char>>()
    for((char, freq) in frequencies) {
        byValue[freq] = (byValue[freq] ?: emptyList()) + char
    }
    val distinctCharFrequencies = byValue.keys
    return when {
        distinctCharFrequencies.size == 1 -> "YES"
        distinctCharFrequencies.size > 2 -> "NO"
        Math.abs(distinctCharFrequencies.first() - distinctCharFrequencies.last()) > 1 -> "NO"
        (byValue[distinctCharFrequencies.first()]?.size ?: 0) > 1 && (byValue[distinctCharFrequencies.last()]?.size ?: 0) > 1 -> "NO"
        else -> "YES"
    }
}
