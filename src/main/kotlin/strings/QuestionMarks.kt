package strings

class QuestionMarks {
    fun QuestionsMarks(str: String): String {
        var hasValidPair = false
        var first: Int = Int.MIN_VALUE
        var questionMarkCounter = 0
        for (char in str) {
            if (char.isDigit()) {
                val second = char.toString().toInt()
                if (first + second == 10) {
                    if (questionMarkCounter == 3) {
                        hasValidPair = true
                    } else {
                        return "false"
                    }
                }
                questionMarkCounter = 0
                first = second
                continue
            }
            if (char == '?') {
                questionMarkCounter++
            }
        }
        // code goes here
        return hasValidPair.toString()
    }
}