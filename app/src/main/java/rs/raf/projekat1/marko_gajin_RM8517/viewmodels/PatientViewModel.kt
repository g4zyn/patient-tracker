package rs.raf.projekat1.marko_gajin_RM8517.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import rs.raf.projekat1.marko_gajin_RM8517.models.Patient
import timber.log.Timber
import kotlin.random.Random

class PatientViewModel : ViewModel() {

    private val patientList : MutableList<Patient> = mutableListOf()

    private val patients : MutableLiveData<List<Patient>> = MutableLiveData()

    init {
        for (i in 0..5) {
            val patient = Patient(
                i,
                "Patient$i",
                "Surname",
                "",
                ""
            )
            patientList.add(patient)
        }
        val listToSubmit = mutableListOf<Patient>()
        listToSubmit.addAll(patientList)
        patients.value = listToSubmit
    }

    fun addPatient(firstName: String, lastName: String, symptoms: String) {

        val patient = Patient(
            Random.nextInt(5, 9999),
            firstName,
            lastName,
            symptoms,
            ""
        )
        patientList.add(patient)

        Timber.e("${patient.firstName} , ${patient.lastName}, ${patient.symptoms}")

        val listToSubmit = mutableListOf<Patient>()
        listToSubmit.addAll(patientList)

        patients.value = listToSubmit
    }

    fun getPatients() : LiveData<List<Patient>> {
        return  patients
    }

    fun filterPatient(filter: String) {

        val filteredList = patientList.filter {
            it.firstName.toLowerCase().startsWith(filter.toLowerCase())
        }
        patients.value = filteredList
    }

}