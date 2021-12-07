import trees.Node

// [1 2 3 4 4]
// d = 4
//
//  10


fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
    var notifications = 0
    var root = Node(expenditure[0])
    for (day in 1..expenditure.lastIndex) {
        if (day + 1 <= d) {
            Node.add(root, Node(expenditure[day]))
            continue
        }
        val median = Node.findMedian(root, d)
        if (expenditure[day] >= 2 * median) {
            notifications++
        }
        if (expenditure[day - d] == expenditure[day]) {
            continue
        }
        root = Node.remove(root, expenditure[day - d]) ?: throw Exception()
        Node.add(root, Node(expenditure[day]))
    }

    return notifications
}

activityNotifications(arrayOf(10, 20, 30, 40, 50), 3)