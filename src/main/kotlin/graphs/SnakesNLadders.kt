package graphs

import java.util.*
import kotlin.collections.HashSet

//Snakes & ladders
//
//Board Size > Int.MAX_VALUE
//Snakes  = list of pairs BS/2
//Ladders = list of pairs BS/2
//Dice size = 6
//idexing from 0
//
//output - least number of dice throws
//
//cannot fall directly after using ladder
//
//Algorithm
//
//
//board = 1 2 3 4 5 6 7
//ladders = [(1, 4), (2, 5)]
//out = 2
//max throws = BS / 6 + 1
//
//no ladder
//6
//when there is a ladder
//use it


class Position(val id: Int, val throws: Int)

fun minMoves(boardSize: Int, laddersNSnakes: Map<Int, Int>): Int {
    val queue = LinkedList<Position>()
    val visited = HashSet<Int>()
    queue.add(Position(1, 0))
    visited.add(1)
    while(queue.isNotEmpty()) {
        val current = queue.remove()
        if(current.id >= boardSize) return current.throws
        for(move in 1..6) {
            var dest = current.id + move
            while(laddersNSnakes.containsKey(dest)) dest = laddersNSnakes[dest]!!
            if(visited.contains(dest)) continue
            queue.add(Position(dest, current.throws+1))
            visited.add(dest)
        }
    }
    throw IllegalStateException()
}

//boardSize = 7
//ladders = [(1, 4), (2, 5)]
//dest = 1
//minMoves(7, ladders, 4, 1) = 2
//minMoves(7, ladders, 5, 1) = 2
//minMoves(7, ladders, 6, 1) = 2
//withoutLadder = 6
//position 0
//count 0
//
//
//minMoves(7, ladders, 4, 1) = 2
//withoutLadder = 10
//minMoves(7, ladders, 10, 2)
//output = 2

