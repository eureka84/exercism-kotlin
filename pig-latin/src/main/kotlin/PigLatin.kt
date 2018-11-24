object PigLatin {

    private data class Rule(val appliesTo: (String) -> Boolean, val transform: (String) -> String)

    private val startsWithAVowel = Rule(
            { s -> s.matches(Regex("([aeiou]|yt|xr).*")) },
            { s -> "${s}ay" }
    )

    private val startsWithAThreeLettersConsonantGroup = Rule(
            { s -> s.matches(Regex("(squ|thr|sch).*")) },
            { s -> "${s.substring(3)}${s.substring(0, 3)}ay" }
    )

    private val startsWithATwoLettersConsonantGroup = Rule(
            { s -> s.matches(Regex("(ch|qu|th).*")) },
            { s -> "${s.substring(2)}${s.substring(0, 2)}ay" }
    )

    private val startsWithAConsonant = Rule(
            { s -> s.matches(Regex("[^aeiou].*")) },
            { s -> "${s.substring(1)}${s[0]}ay" }
    )

    private val rules = listOf(
            startsWithAVowel,
            startsWithAThreeLettersConsonantGroup,
            startsWithATwoLettersConsonantGroup,
            startsWithAConsonant
    )

    fun translate(input: String): String {
        val translate = { word: String ->
            rules.find { rule -> rule.appliesTo(word) }
                ?.let { rule -> rule.transform.invoke(word) }
                ?: word
        }

        return input.split(" ").joinToString(separator = " ") { word -> translate(word) }
    }

}