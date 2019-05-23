object ProjectStudentAssignmentTask {

    fun assignStudentToProjects(students: ArrayList<Student>, projects: ArrayList<Project>) : ArrayList<Project>{

        while (students.isNotEmpty()) {
            //remove first student in list
            var student = students.removeAt(0)
            println("checking: " + student)

            while (student.preferredProjects.isNotEmpty()) {
                var preferredProject = student.preferredProjects.removeAt(0)

                if (preferredProject.considerStudent(student)) {
                    var removedStudent = preferredProject.acceptStudent(student)
                    if (removedStudent != null) {
                        students.add(removedStudent)
                        println(removedStudent.toString() + "added to pool")
                    }

                    break
                }
            }
        }

        return projects
    }
}

class Student(name: String) {
    var name = name
    var preferredProjects = ArrayList<Project>()

    override fun toString(): String {
        return "Student ('$name')"
    }
}

class Project(name: String, capacity: Int) {
    var name = name
    var limit = capacity
    var preferredStudents = ArrayList<Student>()
    var acceptedStudents = ArrayList<Student>()

    override fun toString(): String {
        return "Project ('$name', Accepted Students: '$acceptedStudents')"
    }

    fun isLimitReached(): Boolean {
        return acceptedStudents.size >= limit
    }

    fun considerStudent(student: Student): Boolean {
        //student is in project's consideration list
        if (preferredStudents.contains(student)) {
            if (!isLimitReached()) return true
            else if (isPreferredStudent(student, lastAcceptedStudent())) return true
        }

        return false
    }

    //return removed students, if any
    fun acceptStudent(student: Student): Student? {
        var removedStudent: Student? = null

        if (isLimitReached()) {
            removedStudent = lastAcceptedStudentRemoved()
        }

        if (acceptedStudents.isEmpty() || isPreferredStudent(lastAcceptedStudent(), student)) {
            acceptedStudents.add(student)
        } else {
            for (i in 0 until acceptedStudents.size) {
                //if given student is preferred over existing student, then put new student in old student's spot
                if (isPreferredStudent(student, acceptedStudents[i])) {
                    acceptedStudents.add(i, student)
                    break
                }
            }
        }

        return removedStudent
    }

    fun lastAcceptedStudent(): Student {
        return acceptedStudents[acceptedStudents.size -1]
    }

    //student1 is preferred over student2
    fun isPreferredStudent(student1: Student, student2: Student): Boolean {
        return preferredStudents.indexOf(student1) < preferredStudents.indexOf(student2)
    }

    fun lastAcceptedStudentRemoved(): Student {
        return acceptedStudents.removeAt(acceptedStudents.size -1)
    }
}