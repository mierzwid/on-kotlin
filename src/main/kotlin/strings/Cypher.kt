package strings

fun rotationalCipher(input: String, rotationFactor: Int): String {
    // Write your code here
    val mapping = mutableMapOf<Char, Char>()
    createMapping(mapping, rotationFactor, 'a'..'z')
    createMapping(mapping, rotationFactor, 'A'..'Z')
    createMapping(mapping, rotationFactor, '0'..'9')
    return input.map { mapping[it] ?: it }.toString()
}

fun createMapping(map: MutableMap<Char, Char>, rotationFactor: Int, range: CharRange) {
    val factor = rotationFactor % (range.last.code - range.first.code)
    for (char in range) {
        val shift = (char.code + factor) % range.first.code
        map[char] = (char.code + shift).toChar()
    }
}