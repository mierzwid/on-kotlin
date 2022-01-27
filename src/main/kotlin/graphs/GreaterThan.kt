package graphs

class GreaterThan {

//    "a>bc<ac>b" true
//    "a<bc<ac>b" false
//    "" true
//    "a>b" true
//
//    "a<bc<ac>b" false
//    theGreatest = { }
//    greaterThan = { a: {b}, c: {a}, b: {c}}
//    smallerThan = { b: {a}, a: {c}, c: {b}}
//    elem = b
//    smallerElem in {}

    fun checkValidityCustom(relations: String): Boolean {
        val theGreatest = mutableSetOf<Char>()
        val greaterThan = mutableMapOf<Char, HashSet<Char>>()
        val smallerThan = mutableMapOf<Char, HashSet<Char>>()

        for (idx in 0..relations.lastIndex step 3) {
            val greater = if (relations[idx + 1] == '>') relations[idx] else relations[idx + 2]
            val smaller = if (relations[idx + 1] == '>') relations[idx + 2] else relations[idx]
            if (!greaterThan.containsKey(greater)) theGreatest.add(greater)
            theGreatest.remove(smaller)
            greaterThan.getOrPut(smaller) { HashSet() }.add(greater)
            smallerThan.getOrPut(greater) { HashSet() }.add(smaller)
        }

        while (theGreatest.isNotEmpty()) {
            val elem = theGreatest.last()
            theGreatest.remove(elem)
            for (smallerElem in smallerThan[elem] ?: emptySet()) {
                greaterThan[smallerElem]?.remove(elem)
                if (greaterThan[smallerElem]?.isEmpty() == true) theGreatest.add(smallerElem)
            }
            smallerThan.remove(elem)
        }
        return smallerThan.isEmpty()

    }

    fun checkValidityDFS(relations: String): Boolean {
        val smallerThan = LinkedHashMap<Char, HashSet<Char>>()
        for (idx in 0..relations.lastIndex step 3) {
            val greater = if (relations[idx + 1] == '>') relations[idx] else relations[idx + 2]
            val smaller = if (relations[idx + 1] == '>') relations[idx + 2] else relations[idx]
            smallerThan.getOrPut(greater) { HashSet() }.add(smaller)
        }

        fun searchForCycle(greater: Char, visited: Set<Char> = emptySet()): Boolean {
            if (visited.contains(greater)) return true
            val currentVisited = visited + greater
            for (smaller in smallerThan[greater] ?: emptySet()) {
                if (searchForCycle(smaller, currentVisited)) return true
            }
            smallerThan.remove(greater)
            return false
        }

        for (greater in HashSet(smallerThan.keys)) {
            if (smallerThan[greater] == null) continue
            if (searchForCycle(greater, mutableSetOf())) return false
        }
        return true
    }
}