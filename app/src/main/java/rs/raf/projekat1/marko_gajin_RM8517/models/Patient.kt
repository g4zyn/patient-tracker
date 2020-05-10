package rs.raf.projekat1.marko_gajin_RM8517.models

class Patient (
    val id: Int,
    val firstName: String,
    val lastName: String,
    val symptoms: String,
    var state: State
)