package rs.raf.projekat1.marko_gajin_RM8517.view.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.activity_patient_card.*
import kotlinx.android.synthetic.main.activity_patient_card.cancelBtn
import kotlinx.android.synthetic.main.activity_patient_card.nameEt
import kotlinx.android.synthetic.main.activity_patient_card.saveBtn
import kotlinx.android.synthetic.main.activity_patient_card.surnameEt
import rs.raf.projekat1.marko_gajin_RM8517.R
import rs.raf.projekat1.marko_gajin_RM8517.models.Patient
import rs.raf.projekat1.marko_gajin_RM8517.view.fragments.HospitalizedFragment

class PatientCard : AppCompatActivity(R.layout.activity_patient_card) {

    private lateinit var patient: Patient

    companion object {
        const val PATIENT_KEY = "patientKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        parseIntent()
        initListeners()
    }

    private fun parseIntent() {
        intent.let {
            patient = it.getParcelableExtra(PATIENT_KEY) as Patient

            nameEt.setText(patient.firstName)
            surnameEt.setText(patient.lastName)
            symptoms.text = patient.symptoms
            currSymptomsEt.setText(patient.currentSymptoms)
            hospitalized.text = patient.hospitalizedDate.toString()
        }
    }

    private fun initListeners() {
        saveBtn.setOnClickListener {
            save()
        }
        cancelBtn.setOnClickListener {
            cancel()
        }
    }

    private fun save() {
        val returnIntent = Intent()
        patient.firstName = nameEt.text.toString()
        patient.lastName = surnameEt.text.toString()
        patient.currentSymptoms = currSymptomsEt.text.toString()

        returnIntent.putExtra(PATIENT_KEY, patient)
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }

    private fun cancel() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}
