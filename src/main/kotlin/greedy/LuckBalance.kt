package greedy

import java.util.*

fun luckBalance(k: Int, contests: Array<Array<Int>>): Int {
    var maxLuck = 0
    var importantContests = 0
    val minHeap = PriorityQueue<Int>()
    for (contest in contests) {
        maxLuck += contest[0]
        if (contest[1] == 1) {
            importantContests++
            minHeap.add(contest[0])
        }
    }
    while (importantContests > k) {
        maxLuck -= 2 * minHeap.poll()
        importantContests --
    }
    return maxLuck
}