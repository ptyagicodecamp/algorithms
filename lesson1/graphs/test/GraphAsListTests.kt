import org.junit.Assert
import org.junit.Test

class Test {
    @Test fun testGraphAsList() {

        //create a graph
        var numNodes = 5
        var graphAsList = GraphAsList(numNodes)
        graphAsList.addEdge(graphAsList, 0, 1)
        graphAsList.addEdge(graphAsList, 0, 4)
        graphAsList.addEdge(graphAsList, 1, 2)
        graphAsList.addEdge(graphAsList, 1, 3)
        graphAsList.addEdge(graphAsList, 1, 4)
        graphAsList.addEdge(graphAsList, 2, 3)
        graphAsList.addEdge(graphAsList, 3, 4)

        graphAsList.printGraph()

    }
}