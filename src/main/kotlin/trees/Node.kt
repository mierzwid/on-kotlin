package trees

class Node(var value: Int) {

    var left: Node? = null
    var right: Node? = null

    companion object {

        fun findMedian(node: Node, size: Int): Float {
            val middle = size / 2
            return if (size % 2 == 0) {
                (find(node, middle - 1) + find(node, middle)) / 2F
            } else {
                find(node, middle)
            }
        }

        private fun find(node: Node, count: Int): Float {
            return findNth(node, count).second?.toFloat() ?: 0F
        }

        private fun findNth(node: Node?, count: Int): Pair<Int, Int?> {
            if (node == null) return count to null
            if (count == 0) return -1 to node.value
            val (newCount, value) = findNth(node.left, count)
            if (newCount < 0) return newCount to value
            if (newCount == 0) return -1 to node.value
            return findNth(node.right, count - 1)
        }


        fun remove(node: Node?, value: Int): Node? {
            if (node == null) {
                return null
            }
            when {
                node.value == value -> {
                    val greatest = findGreatestAndReplaceWithLeft(node, node.left)
                    if (greatest == null) {
                        return node.right
                    }
                    node.value = greatest.value
                }
                value < node.value -> remove(node.left, value)
                else -> remove(node.right, value)
            }
            return node
        }

        private fun findGreatestAndReplaceWithLeft(parent: Node, node: Node?): Node? {
            if (node == null) {
                return null
            }
            if (node.right == null) {
                parent.right = node.left
                return node
            }
            return findGreatestAndReplaceWithLeft(node, node.right)
        }

        fun add(node: Node, newNode: Node) {
            when {
                newNode.value <= node.value ->
                    if (node.left == null)
                        node.left = newNode
                    else
                        add(node.left ?: throw Exception(), newNode)
                else ->
                    if (node.right == null)
                        node.right = newNode
                    else
                        add(node.right ?: throw Exception(), newNode)
            }

        }
    }
}