object Raindrops {

    private val sounds = mapOf(
            3 to "Pling",
            5 to "Plang",
            7 to "Plong"
    )

    fun convert(input: Int): String {
        val translation =
                sounds.map { (factor, sound) ->
                    if (input % factor == 0)
                        sound
                    else
                        ""
                }.joinToString(separator = "")

        return if (translation.isEmpty()) input.toString() else translation
    }

}