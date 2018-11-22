
object Raindrops {

    private val dictionary = mapOf(
        3 to "Pling",
        5 to "Plang",
        7 to "Plong"
    )

    fun convert(input: Int): String {
        val translation =
            dictionary.map { (factor, word) ->
                if (input % factor == 0)
                    word
                else
                    ""
            }.joinToString(separator = "")

        return if (translation.isEmpty()) input.toString() else translation
    }
}