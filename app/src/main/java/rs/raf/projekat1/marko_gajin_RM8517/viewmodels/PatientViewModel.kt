package rs.raf.projekat1.marko_gajin_RM8517.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import rs.raf.projekat1.marko_gajin_RM8517.models.Patient

class PatientViewModel : ViewModel() {

    private val patientList : MutableList<Patient> = mutableListOf()

    private val patients : MutableLiveData<List<Patient>> = MutableLiveData()

    init {
        for (i in 0..20) {
            val patient = Patient(
                i,
                "Patient$i",
                "Surname",
                "",
                ""
            )
            patientList.add(patient)
        }
        patients.value = patientList
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