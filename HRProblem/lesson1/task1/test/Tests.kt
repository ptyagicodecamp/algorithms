import org.junit.Assert
import org.junit.Test
import Hospital
import Resident
import HRProblem

class Test {
    @Test fun testHRAssignment() {

        var h1 = Hospital("H1", 2)
        var h2 = Hospital("H2", 2)
        var h3 = Hospital("H3", 2)

        var listOfHospitals = arrayListOf<Hospital>(
                h1, h2, h3
        )


        var listOfResidents = arrayListOf<Resident>(
                Resident("R1").apply {
                    hospitalsPreferred = arrayListOf(h1, h3)},
                Resident("R2").apply {
                    hospitalsPreferred = arrayListOf(h2, h3)},
                Resident("R3").apply {
                    hospitalsPreferred = arrayListOf(h1, h2)}
        )



        var hrProblem = HRProblem.matchResidentsToHospitals(listOfResidents, listOfHospitals)

        for (i in 0 until hrProblem.size)
            println(hrProblem.get(i).name)
    }
}