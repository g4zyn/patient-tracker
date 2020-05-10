package rs.raf.projekat1.marko_gajin_RM8517.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Patient (
    val id: Int,
    var firstName: String,
    var lastName: String,
    val symptoms: String,
    var currentSymptoms: String,
    var state: State,
    var hospitalizedDate: Date?,
    var releasedDate: Date?
) : Parcelable