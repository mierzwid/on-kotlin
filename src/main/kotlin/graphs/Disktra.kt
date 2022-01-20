package graphs

import java.util.*

// examples of a graph

//A1 -5- B2 -1- C3 -5- =F6
//\ 	    |			   |
//9     2              |
//\    |			   |
//\ D4 -1------E5---1
//A1 B2 C3 D4 E5 F6
//A1 0 5     9
//B2 5 0  1  2
//C3   1           5
//D4 9 2        1
//E5         1     1
//F6      5     1
//
//
//end = 6
//vertex = 2 5 false
//distViaVertex = 7
//neighbour = 4 7 false
//
//Vetices Map
//2 5 false
//4 7 false
//1 0 true
//3 6 false
//
//Priority Queue
//3 6 false
//4 7 false
//4 9 false

class Vertex(val id: Int, var dist: Int = 0, var visited: Boolean = false)

fun dikstra(distances: Array<Array<Int>>, start: Int, end: Int): Int {
    val vertices = mutableMapOf<Int, Vertex>()
    val queue = PriorityQueue<Vertex> { v1, v2 -> v2.dist - v1.dist }
    queue.add(Vertex(start))
    while (queue.isNotEmpty()) {
        val vertex = queue.remove()
        if (vertex.id == end) return vertex.dist
        for ((id, dist) in distances[vertex.id].withIndex()) {
            if (id == vertex.id) continue
            if (dist == -1) continue
            val distViaVertex = dist + vertex.dist
            val neighbor = vertices[id] ?: Vertex(id, distViaVertex)
            if (neighbor.visited) continue
            if (neighbor.dist > distViaVertex) {
                neighbor.dist = distViaVertex
                queue.remove(neighbor)
            }
            vertices[id] = neighbor
            queue.add(neighbor)
        }
        vertex.visited = true
        vertices[vertex.id] = vertex
    }
    throw IllegalStateException()
}

//1. take A1
//2. check all the neighbours and assign distance from A1 and put it on a priority queue
//
//F6	   9		E5	   false
//
//Queue
//vertex distance parent visited
//
//
//Verticles Map
//vertex distance parent visited
//B2	   5        A1     true
//D4	   7        B2     true
//A1     0        null   true
//C3	   6        B2     true
//F6	   9		E5	   false
//E5	   8		D4	   true
//
//O((V+E)logV)


