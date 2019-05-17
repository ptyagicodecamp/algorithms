import org.junit.Test

class Test {
    @Test fun testConfig1() {

        var mercy = Hospital("Mercy", 2)
        var city = Hospital("City", 2)
        var general = Hospital("General", 2)

        var arthur = Resident("Arthur")
        var sunny = Resident("Sunny")
        var joseph = Resident("Joseph")
        var latha = Resident("Latha")
        var darrius = Resident("Darrius")


        var hospitalsPref = arrayListOf<Hospital>(
                mercy.apply {
                    residentsPreferred = arrayListOf(darrius, joseph) },
                city.apply {
                    residentsPreferred = arrayListOf(darrius, arthur, sunny, latha, joseph) },
                general.apply {
                    residentsPreferred = arrayListOf(darrius, arthur, joseph, latha) }
        )


        var residentsPref = arrayListOf<Resident>(
                arthur.apply {
                    hospitalsPreferred = arrayListOf(city)},
                sunny.apply {
                    hospitalsPreferred = arrayListOf(city, mercy)},
                joseph.apply {
                    hospitalsPreferred = arrayListOf(city, general, mercy)},
                latha.apply {
                    hospitalsPreferred = arrayListOf(mercy, city, general)},
                darrius.apply {
                    hospitalsPreferred = arrayListOf(city, mercy, general)}
        )



        var matchedHospitals = HRProblem.matchResidentsToHospitalsv(residentsPref, hospitalsPref)

        println("\n********\n")

        for (i in 0 until matchedHospitals.size) {
            var matchedHospital = matchedHospitals.get(i)

            println("Residents matched for " + matchedHospitals.get(i).name)

            for (r in 0 until matchedHospital.residentsAccepted.size) {
                println("Resident " + r + ": " + matchedHospital.residentsAccepted.get(r).name)
            }

            println()
        }
    }

    @Test fun testHRAssignmentMoreResidents() {

        var h1 = Hospital("H1", 1)
        var h2 = Hospital("H2", 1)
        var h3 = Hospital("H3", 1)

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

        var h1 = Hospital("H1", 1)
        var h2 = Hospital("H2", 1)
        var h3 = Hospital("H3", 1)

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