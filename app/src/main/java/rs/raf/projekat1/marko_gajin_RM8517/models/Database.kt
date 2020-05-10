package rs.raf.projekat1.marko_gajin_RM8517.models

import kotlin.random.Random

class Database() {

    val patients: MutableList<Patient> = mutableListOf()

    private var names = arrayOf("Marko", "Pera", "Branko", "Zika", "Luka", "Stefan", "Mika")
    private var surnames = arrayOf("Markovic", "Peric", "Brankovic", "Zikic", "Lukic", "Stefanovic", "Mikic")

    init {
        for (i in 0..5) {
            val patient = Patient(
                i,
                names[Random.nextInt(0, 5)],
                surnames[Random.nextInt(0, 5)],
                "",
                State.WAITING,
                null,
                null
            )
            patients.add(patient)
        }
    }
}