import org.junit.Assert
import org.junit.Test
import Hospital
import Resident
import HRProblem

class Test {
    @Test fun testHRAssignmentMoreResidents() {

        var h1 = Hospital("H1", 2)
        var h2 = Hospital("H2", 2)
        var h3 = Hospital("H3", 2)

        var r1 = Resident("R1")
        var r2 = Resident("R2")
        var r3 = Resident("R3")
        var r4 = Resident("R4")
        var r5 = Resident("R5")
        var r6 = Resident("R6")


        var listOfHospitals = arrayListOf<Hospital>(
                h1.apply {
                    residentsPreferred = arrayListOf(r2, r1, r3) },
                h2.apply {
                    residentsPreferred = arrayListOf(r3, r2, r1) },
                h3.apply {
                    residentsPreferred = arrayListOf(r1, r3, r2) }
        )


        var listOfResidents = arrayListOf<Resident>(
                r1.apply {
                    hospitalsPreferred = arrayListOf(h2, h1, h3)},
                r2.apply {
                    hospitalsPreferred = arrayListOf(h2, h3)},
                r3.apply {
                    hospitalsPreferred = arrayListOf(h1, h3)},
                r4.apply {
                    hospitalsPreferred = arrayListOf(h2, h1, h3)},
                r5.apply {
                    hospitalsPreferred = arrayListOf(h2, h3, h1)},
                r6.apply {
                    hospitalsPreferred = arrayListOf(h1, h3, h2)}
        )



        var matchedHospitals = HRProblem.matchResidentsToHospitals(listOfResidents, listOfHospitals)

        for (i in 0 until matchedHospitals.size) {
            var matchedHospital = matchedHospitals.get(i)

            println("Residents matched for Hospital " + matchedHospitals.get(i).name)

            for (r in 0 until matchedHospital.residentsAccepted.size) {
                println("Resident " + r + ": " + matchedHospital.residentsAccepted.get(r).name)
            }

            println()
        }
    }

    @Test fun testHRAssignment() {

        var h1 = Hospital("H1", 2)
        var h2 = Hospital("H2", 2)
        var h3 = Hospital("H3", 2)

        var r1 = Resident("R1")
        var r2 = Resident("R2")
        var r3 = Resident("R3")


        var listOfHospitals = arrayListOf<Hospital>(
                h1.apply {
                    residentsPreferred = arrayListOf(r2, r1, r3) },
                h2.apply {
                    residentsPreferred = arrayListOf(r3, r2, r1) },
                h3.apply {
                    residentsPreferred = arrayListOf(r1, r3, r2) }
                )


        var listOfResidents = arrayListOf<Resident>(
                r1.apply {
                    hospitalsPreferred = arrayListOf(h2, h1, h3)},
                r2.apply {
                    hospitalsPreferred = arrayListOf(h2, h3, h1)},
                r3.apply {
                    hospitalsPreferred = arrayListOf(h1, h3, h2)}
        )



        var matchedHospitals = HRProblem.matchResidentsToHospitals(listOfResidents, listOfHospitals)

        for (i in 0 until matchedHospitals.size) {
            var matchedHospital = matchedHospitals.get(i)

            println("Residents matched for Hospital " + matchedHospitals.get(i).name)

            for (r in 0 until matchedHospital.residentsAccepted.size) {
                println("Resident " + r + ": " + matchedHospital.residentsAccepted.get(r).name)
            }

            println()
        }
    }
}