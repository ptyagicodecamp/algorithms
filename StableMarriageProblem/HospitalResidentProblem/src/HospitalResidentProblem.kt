import com.sun.org.apache.xpath.internal.operations.Bool

/**
 * Classic Hospitals-Residents assignment problem
 * Reference: http://www.nrmp.org/matching-algorithm/
 */
object HRProblem{

    /**
     * Residents make proposal to be matched against Hospitals of their choice
     */
    fun matchResidentsToHospitals(listOfResidents: ArrayList<Resident>,
                                  listOfHospitals: ArrayList<Hospital>): ArrayList<Hospital> {

        var residents = listOfResidents
        var hospitals = listOfHospitals

        while (residents.isNotEmpty()) {
            var resident = residents.removeAt(0)
            println("\nNew Resident trial for " + resident.name + "\n")

            while (resident.hospitalsPreferred.isNotEmpty()) {
                var potentialHospital = resident.hospitalsPreferred.removeAt(0)
                println("\nMatching resident: " + resident.name + " with " + potentialHospital.name)

                if (potentialHospital.considerResident(resident)) {
                    var removedResident = potentialHospital.acceptResident(resident)
                    if (removedResident != null) {
                        print("re-queued: " + removedResident!!.name + " for " + potentialHospital.name)
                        //unmatched resident goes back in pool to be re-considered again fo next best match
                        residents.add(0, removedResident)
                        break
                    }
                    else {
                        println("Tentative match found: " + resident.name + " with " + potentialHospital.name)
                        break
                    }

                    //resident.hospitalsPreferred = resident.hospitalsPreferred
                } else {
                    print("Hospital didn't consider : " + resident.name + " with " + potentialHospital.name)
                }
            }
        }

        return hospitals
    }

    fun matchResidentsToHospitalsv(listOfResidents: ArrayList<Resident>,
                                  listOfHospitals: ArrayList<Hospital>): ArrayList<Hospital> {

        listOfResidents.shuffle()
        listOfHospitals.shuffle()
        var residents = listOfResidents
        var hospitals = listOfHospitals

        while (residents.isNotEmpty()) {
            var resident = residents.removeAt(0)
            println("\n\nNew Resident trial for " + resident.name + "\n")

            while (resident.hospitalsPreferred.isNotEmpty()) {
                var potentialHospital = resident.hospitalsPreferred.removeAt(0)
                if (potentialHospital.considerResident(resident)) {
                    var removedResident = potentialHospital.acceptResident(resident)
                    if (removedResident != null) {
                        //unmatched resident goes back in pool to be re-considered again fo next best match
                        residents.add(0, removedResident)
                    }
                    break
                }
            }
            for (hospital in hospitals) {
                println(hospital.toResidentsAcceptedStr());
            }
        }

        return hospitals
    }
}

class Resident(residentName: String) {
    var name = residentName
    var hospitalsPreferred = ArrayList<Hospital>()
    override fun toString(): String {
        return "Resident(name='$name')"
    }

}

class Hospital(hospitalName: String, limit: Int) {
    var name = hospitalName
    var limit = limit
    var residentsPreferred = ArrayList<Resident>()
    var residentsAccepted = ArrayList<Resident>()

    //consider accepting resident
    fun considerResident(resident: Resident): Boolean {
        if (residentsPreferred.contains(resident)) {
            if(!limitReached()) {
                return true
            } else {
                //check if this resident is better than last accepted resident
                if (isPreferredResident(resident, lastAcceptedResident())) {
                    return true
                }
            }
        }

        return false
    }

    //accept given resident and return removedResident (less appropriate match)
    fun acceptResident(resident: Resident): Resident? {
        var removedResident: Resident? = null
        if (limitReached()) {
            removedResident = lastAcceptedResidentRemoved()
        }

        if (residentsAccepted.isEmpty() ||
                isPreferredResident(lastAcceptedResident(), resident)) {
            residentsAccepted.add(resident)
        } else {
            for (i in 0 until residentsAccepted.size) {
                if (isPreferredResident(resident, residentsAccepted[i])) {
                    residentsAccepted.add(i, resident)
                    break

                }
            }
        }

        return removedResident
    }

    private fun limitReached() : Boolean {
        return residentsAccepted.size >= this.limit
    }

    //Resident1 is higher in preference list than Resident2
    private fun isPreferredResident(resident1: Resident, resident2: Resident): Boolean {
        return residentsPreferred.indexOf(resident1) < residentsPreferred.indexOf(resident2)
    }

    private fun lastAcceptedResident(): Resident {
        return residentsAccepted[residentsAccepted.size - 1]
    }

    private fun lastAcceptedResidentRemoved(): Resident {
        return residentsAccepted.removeAt(residentsAccepted.size - 1)
    }

    fun toResidentsAcceptedStr(): String {
        return "Hospital(name='$name', residentsAccepted=$residentsAccepted)"
    }
}
