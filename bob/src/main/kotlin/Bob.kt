object Bob {
    fun hey(greeting: String): String =
            greeting.trim().let { phrase ->
                when {
                    phrase.isSilence() -> "Fine. Be that way!"
                    phrase.isShouted() -> "Whoa, chill out!"
                    phrase.isAQuestion() -> "Sure."
                    else -> "Whatever."
                }
            }
}

private fun String.isSilence(): Boolean = isEmpty()

private fun String.isAQuestion(): Boolean = endsWith("?")

private fun String.isShouted(): Boolean {
    val onlyLetters = this.filter(Char::isLetter)
    return !onlyLetters.isEmpty() && onlyLetters.isUpperCase()
}

private fun String.isUpperCase(): Boolean = this.all(Char::isUpperCase)