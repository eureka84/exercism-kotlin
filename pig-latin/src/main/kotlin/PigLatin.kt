object PigLatin {

    private const val VOWEL_PATTERN = "([aeiou]|yt|xr).*"
    private const val CONSONANTS_PATTERN = "(squ|thr|sch|ch|qu|th|rh|[^aeiou])(.*)"

    private data class Rule(val appliesTo: (String) -> Boolean, val transform: (String) -> String)

    private val startsWithAVowel = Rule(
            { s -> s.matches(Regex(VOWEL_PATTERN)) },
            { s -> "${s}ay" }
    )

    private val startsWithAConsonant = Rule(
            { s -> s.matches(Regex(CONSONANTS_PATTERN)) },
            { s -> Regex(CONSONANTS_PATTERN).replace(s) { m ->
                val (prefix, postfix) = m.destructured
                "$postfix${prefix}ay"
            }}
    )

    private val rules = listOf(
            startsWithAVowel,
            startsWithAConsonant
    )

    fun translate(input: String): String {
        val translate = { word: String ->
            rules.find { rule -> rule.appliesTo(word) }
                ?.let { rule -> rule.transform(word) }
                ?: word
        }

        return input.split(" ").joinToString(separator = " ") { word -> translate(word) }
    }

}