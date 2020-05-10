package rs.raf.projekat1.marko_gajin_RM8517.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import rs.raf.projekat1.marko_gajin_RM8517.models.Database
import rs.raf.projekat1.marko_gajin_RM8517.models.Patient
import rs.raf.projekat1.marko_gajin_RM8517.models.State
import kotlin.random.Random

class PatientViewModel: ViewModel() {

    private val database: Database = Database()

    private val waitingLiveData: MutableLiveData<List<Patient>> = MutableLiveData()
    private val hospitalizedLiveData: MutableLiveData<List<Patient>> = MutableLiveData()
    private val releasedLiveData: MutableLiveData<List<Patient>> = MutableLiveData()

    private val waitingFilter = { patient: Patient -> patient.state == State.WAITING }
    private val hospitalizedFilter = { patient: Patient -> patient.state == State.HOSPITALIZED }
    private val releasedFilter = { patient: Patient -> patient.state == State.RELEASED }

    init {
        waitingLiveData.value = database.patients.filter(waitingFilter)
        hospitalizedLiveData.value = database.patients.filter(hospitalizedFilter)
        releasedLiveData.value = database.patients.filter(releasedFilter)
    }

    fun addPatient(firstName: String, lastName: String, symptoms: String) {
        val patient = Patient(
            Random.nextInt(5, 9999),
            firstName,
            lastName,
            symptoms,
            State.WAITING,
            null,
            null
        )
        database.patients.add(patient)
//        val listToSubmit = mutableListOf<Patient>()
//        listToSubmit.addAll(database.patients)
        waitingLiveData.value = database.patients.filter(waitingFilter)
    }

    fun getPatients(state: State) : LiveData<List<Patient>> {
       return when (state) {
            State.WAITING -> waitingLiveData
            State.HOSPITALIZED -> hospitalizedLiveData
            else -> releasedLiveData
        }
    }

}