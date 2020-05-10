package rs.raf.projekat1.marko_gajin_RM8517.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import rs.raf.projekat1.marko_gajin_RM8517.models.Patient
import rs.raf.projekat1.marko_gajin_RM8517.models.State
import timber.log.Timber
import kotlin.random.Random

class PatientViewModel: ViewModel() {

    private val patients: MutableList<Patient> = mutableListOf()

    private val waitingLiveData: MutableLiveData<List<Patient>> = MutableLiveData()
    private val hospitalizedLiveData: MutableLiveData<List<Patient>> = MutableLiveData()
    private val releasedLiveData: MutableLiveData<List<Patient>> = MutableLiveData()

    init {
        for (i in 0..5) {
            val patient = Patient(
                i,
                "Patient$i",
                "Surname",
                "",
                State.WAITING
            )
            patients.add(patient)
        }
        val listToSubmit = mutableListOf<Patient>()
        listToSubmit.addAll(patients)
        waitingLiveData.value = listToSubmit
    }

    fun addPatient(firstName: String, lastName: String, symptoms: String) {

        val patient = Patient(
            Random.nextInt(5, 9999),
            firstName,
            lastName,
            symptoms,
            State.WAITING
        )
        patients.add(patient)

        val listToSubmit = mutableListOf<Patient>()
        listToSubmit.addAll(patients)

        waitingLiveData.value = listToSubmit
    }

    fun getPatients(state: State) : LiveData<List<Patient>> {
       return when (state) {
            State.WAITING -> waitingLiveData
            State.HOSPITALIZED -> hospitalizedLiveData
            else -> releasedLiveData
        }
    }

}