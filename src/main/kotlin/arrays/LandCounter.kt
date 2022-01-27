package arrays

//map of sea - 2D array
//1 - land
//0 - water
//
//side-by-side adjacent land blocks form an island
//
//count the number of islands
//
//map - rectangle, 1<= a,b <= 2B
//
//// algo
//review array
//if there is a land search around and turn it to water
//
//00000
//11000
//10101
//
//000
//000
//000

val map = Array(5) { Array(5) { 0 } }

fun countIslands(): Int {
    var count = 0
    for (row in map.indices) {
        for ((col, type) in map[row].withIndex()) {
            when (type) {
                0 -> continue
                else -> {
                    destroyIsland(row, col)
                    count++
                }
            }
        }
    }
    return count
}

fun destroyIsland(row: Int, col: Int) {
    if (row >= map.size || row < 0) return
    if (col >= map[row].size || col < 0) return
    if (map[row][col] == 0) return
    map[row][col] = 0
    destroyIsland(row + 1, col)
    destroyIsland(row, col + 1)
    destroyIsland(row, col - 1)
    destroyIsland(row - 1, col)
}

//Is it possible to destroy part of the land?
//no
//Do you have to destroy stuff up and left?
//yes I have to
//
//01001
//11111
//00000
//
//cout 3
//row 2
//col 4
//type 1


//00000
//11000
//10101
//
//00000
//00000  1
//00101
//
//00000
//00000  2
//00001
//
//
//00000
//00000  3
//00000