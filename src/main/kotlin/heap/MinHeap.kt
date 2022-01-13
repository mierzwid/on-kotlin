package heap

class MinHeap {

    private var items = Array(265) { 0 }

    var size = 0

    fun peek(): Int {
        if (items.isEmpty()) throw IllegalStateException()
        return items[0]
    }

    fun poll(): Int {
        if (items.isEmpty()) throw IllegalStateException()
        val min = items[0]
        items[0] = items[size - 1]
        size--
        heapifyDown()
        return min
    }

    fun add(item: Int) {
        ensureExtraCapacity()
        items[size] = item
        size++
        heapifyUp()
    }

    private fun heapifyUp() {
        var index = size - 1
        while (hasParent(index) && items[parentIndex(index)] > items[index]) {
            swap(index, parentIndex(index))
            index = parentIndex(index)
        }
    }

    private fun parentIndex(index: Int): Int {
        if (!hasParent(index)) throw IllegalStateException()
        return items[(index - 1) / 2]
    }

    private fun hasParent(index: Int): Boolean {
        return index > 0
    }

    private fun swap(first: Int, second: Int) {
        val tmp = items[first]
        items[first] = items[second]
        items[second] = tmp
    }

    private fun ensureExtraCapacity() {
        if (size == items.size) {
            items = Array(size * 2) {
                if (it < size * 2) {
                    items[it]
                } else {
                    0
                }
            }
        }
    }

    private fun heapifyDown() {
        var index = 0
        while (hasLeft(index)) {
            val smallerChildIndex = if (hasRight(index) && items[leftIndex(index)] > items[rightIndex(index)]) {
                rightIndex(index)
            } else {
                leftIndex(index)
            }
            if (items[index] >= items[smallerChildIndex]) break
            swap(index, smallerChildIndex)
            index = smallerChildIndex
        }
    }

    private fun rightIndex(index: Int): Int {
        return leftIndex(index) + 1
    }

    private fun hasRight(index: Int): Boolean {
        return rightIndex(index) < size
    }

    private fun leftIndex(index: Int): Int {
        return index * 2 + 1
    }

    private fun hasLeft(index: Int): Boolean {
        return leftIndex(index) < size
    }
}