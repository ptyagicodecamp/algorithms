import java.util.*

/**
 * Represent graph as Adjacency List using LinkedList
 * Reference: https://www.geeksforgeeks.org/graph-and-its-representations/
 */
class GraphAsList(vertices: Int) {
    var arrayOfAdjacencyList = LinkedList<LinkedList<Int>>()
    val numNodes = vertices
    init {
        //each vertex has its own LinkedList to hold it's edges
        for (vertex in 0 until numNodes) {
            arrayOfAdjacencyList.add(vertex, LinkedList())
        }
    }

    fun addEdge(graphAsList: GraphAsList, source: Int, dest: Int) {
        //undirected graph has two entries for each edge in both directions
        graphAsList.arrayOfAdjacencyList[source].add(dest)
        graphAsList.arrayOfAdjacencyList[dest].add(source)
    }

    fun printGraph()  {
        for (i in 0 until numNodes) {
            print("Adjacency list for node: " + i)
            for (edge in arrayOfAdjacencyList[i]) {
                print(" --> " + edge)
            }

            println()
        }
    }
}