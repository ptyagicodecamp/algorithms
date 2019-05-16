import com.sun.org.apache.xpath.internal.operations.Bool

// type your solution here
object Backtracking {
    //number of vertices in graph
    val numNodes = 4

    //Holds color assigned to each vertex
    var colorAssignments = emptyArray<Int>()

    //check if it's okay to assign color to a vertex
    fun isOk(node: Int, graph: Array<Array<Int>>, colors: Array<Int>, c: Int): Boolean {

        for (i in 0 until numNodes) {
            //Neighboring vertex with same color is not acceptable,
            //because that means vertices are connected in same subset.
            //graph[k][l] = 1 //Edge
            if (graph[node][i] == 1 && c == colors[i]) return false
        }
        return true
    }

    //m is number of subset/colors
    //Returns false, if assignment fails.
    //Returns true, if color assignment is finished for all nodes
    fun assignColorToNode(node: Int, graph: Array<Array<Int>>, colors: Array<Int>, m: Int): Boolean {

        //return true if all vertices are assigned a color
        if (node == numNodes) {
            return true
        }

        //try assigning all available colors
        for (c in 1..m) {
            if (isOk(node, graph, colors, c)) {
                colors[node] = c

                //try assigning color to next node
                if (assignColorToNode(node+1, graph, colors, m)) return true

                //if color assignment is not achieved and control comes here, then backtrack
                colors[node] = 0
            }
        }

        return false
    }

    //color graphs for m number of colors
    fun colorGraph(graph: Array<Array<Int>>, m: Int): Boolean {
        //reset color assignment array
        colorAssignments = Array(numNodes) {i -> 0}

        //start from first node
        if (!assignColorToNode(0, graph, colorAssignments, m)) {
            println("No solution exists")
            return false
        }

        for (i in 0 until numNodes) {
            print("     " + "["+i+"]" + colorAssignments[i] + "     ")
        }
        println()
        return true
    }

    fun isGraphBipartite(graph: Array<Array<Int>>): Boolean {
        //Bipartite graph has 2 subsets
        var m = 2
        return colorGraph(graph, m)
    }
}