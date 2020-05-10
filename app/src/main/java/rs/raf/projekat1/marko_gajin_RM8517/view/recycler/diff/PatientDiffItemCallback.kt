package rs.raf.projekat1.marko_gajin_RM8517.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import rs.raf.projekat1.marko_gajin_RM8517.models.Patient

class PatientDiffItemCallback : DiffUtil.ItemCallback<Patient>() {

    override fun areItemsTheSame(oldItem: Patient, newItem: Patient): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Patient, newItem: Patient): Boolean {
        return oldItem.firstName == newItem.firstName
                && oldItem.lastName == newItem.lastName
                && oldItem.state == newItem.state
    }

}