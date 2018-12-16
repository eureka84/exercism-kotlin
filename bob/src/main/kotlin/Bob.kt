object Bob {
    fun hey(greeting: String): String =
            when {
                greeting.isSilence() -> "Fine. Be that way!"
                greeting.isShouted() -> "Whoa, chill out!"
                greeting.isAQuestion() -> "Sure."
                else -> "Whatever."
            }
}

private fun String.isSilence(): Boolean = this.trim().isEmpty()

private fun String.isAQuestion(): Boolean = this.trim().endsWith("?")

private fun String.isShouted(): Boolean {
    val onlyLetters = this.filter { c -> c.isLetter() }
    return !onlyLetters.isEmpty() && onlyLetters.isUpperCase()
}

private fun String.isUpperCase(): Boolean = this.all { c -> c.isUpperCase() }