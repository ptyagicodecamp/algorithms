import org.junit.Test

class ProjectStudentAssignmentTest {
    @Test fun testSolution() {
        var reading = Project("Reading", 2)
        var lego = Project("Lego", 2)
        var maths = Project("Maths", 2)

        var kalp = Student("Kalp")
        var krisha = Student("Krisha")
        var eric = Student("Eric")
        var joe = Student("Joe")
        var sue = Student("Sue")


        var listOfStudents = arrayListOf<Student>(
                kalp.apply { preferredProjects = arrayListOf(lego) },
                krisha.apply { preferredProjects = arrayListOf(reading, maths, lego)},
                eric.apply { preferredProjects = arrayListOf(lego, maths) },
                joe.apply {  preferredProjects = arrayListOf(reading, lego, maths) },
                sue.apply { preferredProjects = arrayListOf(lego, maths, reading) }
        )

        var listOfProject = arrayListOf<Project>(
                reading.apply { preferredStudents = arrayListOf(kalp, eric) },
                lego.apply { preferredStudents = arrayListOf(sue, kalp, joe, eric, krisha) },
                maths.apply { preferredStudents = arrayListOf(joe, sue, kalp) }
        )

        var projects = ProjectStudentAssignmentTask.assignStudentToProjects(listOfStudents, listOfProject)
        for(i in 0 until projects.size) {
            println(projects[i].toString())
        }
    }
}