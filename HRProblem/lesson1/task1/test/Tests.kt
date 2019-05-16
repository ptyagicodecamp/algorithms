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

        var r1 = Resident("R1")
        var r2 = Resident("R2")
        var r3 = Resident("R3")


        var listOfHospitals = arrayListOf<Hospital>(
                h1.apply {
                    residentsPreferred = arrayListOf(r1) },
                h2.apply {
                    residentsPreferred = arrayListOf(r2) },
                h3.apply {
                    residentsPreferred = arrayListOf(r3) }
                )


        var listOfResidents = arrayListOf<Resident>(
                r1.apply {
                    hospitalsPreferred = arrayListOf(h1, h3)},
                r2.apply {
                    hospitalsPreferred = arrayListOf(h2, h3)},
                r3.apply {
                    hospitalsPreferred = arrayListOf(h1, h2)}
        )



        var hrProblem = HRProblem.matchResidentsToHospitals(listOfResidents, listOfHospitals)

        for (i in 0 until hrProblem.size)
            println(hrProblem.get(i).name)
    }
}