package stacks

import java.util.*

val brackets = mapOf(
    '{' to '}',
    '(' to ')',
    '[' to ']',
)
val opening = brackets.keys

fun isBalanced(args: String): Boolean {
    if(args.isEmpty()) return true
    val openBrackets = Stack<Char>()
    for(char in args) {
        when (char) {
            in opening -> openBrackets.push(char)
            else -> {
                if(brackets[openBrackets.pop()] != char) return false
            }
        }
    }
    return true
}

