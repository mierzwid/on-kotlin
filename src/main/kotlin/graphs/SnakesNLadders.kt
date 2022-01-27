package graphs

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


fun minMoves(boardSize: Int, ladders: Map<Int, Int>, position: Int = 0, count: Int = 0): Int {
    if(position >= boardSize) return count
    var min = Int.MAX_VALUE
    var withoutLadder = position
    for(move in 1..6) {
        val dest = position + move
        if(ladders[dest] != null){
            min = Math.min(min, minMoves(boardSize, ladders, ladders[dest]!!, count + 1))
        } else {
            withoutLadder = dest
        }
    }
    if(withoutLadder == position) return min
    return Math.min(min, minMoves(boardSize, ladders, withoutLadder, count + 1))
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

