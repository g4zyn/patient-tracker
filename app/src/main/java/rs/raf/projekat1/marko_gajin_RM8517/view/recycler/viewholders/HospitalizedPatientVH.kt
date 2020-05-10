package rs.raf.projekat1.marko_gajin_RM8517.view.recycler.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_hospitalized_list_item.*
import kotlinx.android.synthetic.main.layout_hospitalized_list_item.view.*
import rs.raf.projekat1.marko_gajin_RM8517.models.Patient

class HospitalizedPatientVH(
    override val containerView: View,
    private val onCardBtnClicked: (Int) -> Unit,
    private val onReleaseBtnClicked: (Int) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        initListeners()
    }

    private fun initListeners() {
        containerView.cardBtn.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onCardBtnClicked.invoke(adapterPosition)
            }
        }

        containerView.releaseBtn.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onReleaseBtnClicked.invoke(adapterPosition)
            }
        }
    }

    fun bind(patient: Patient) {
        nameTv.text = patient.firstName
        surnameTv.text = patient.lastName
    }

}