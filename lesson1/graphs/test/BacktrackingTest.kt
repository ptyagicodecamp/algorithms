import org.junit.Assert
import org.junit.Test


class BacktrackingTest {

    @Test fun testBacktracking() {
        var graph = arrayOf(
                arrayOf(0, 1, 0, 1),
                arrayOf(1, 0, 1, 0),
                arrayOf(0, 1, 0, 1),
                arrayOf(1, 0, 1, 0)
                )
        //number of colors (disjoint sets, partitions)
        val m = 3

        var result = Backtracking.colorGraph(graph, m)

        Assert.assertTrue("Coloring Graph", result)
    }

    @Test fun testBipartiteGraph() {
        var graph = arrayOf(
                arrayOf(0, 1, 0, 1),
                arrayOf(1, 0, 1, 0),
                arrayOf(0, 1, 0, 1),
                arrayOf(1, 0, 1, 0)
        )

        var result = Backtracking.isGraphBipartite(graph)

        Assert.assertTrue("Coloring Graph", result)
    }
}