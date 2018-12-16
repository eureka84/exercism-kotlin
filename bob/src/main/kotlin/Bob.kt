object Bob {
    fun hey(greeting: String): String =
            when {
                greeting.isSilence() -> "Fine. Be that way!"
                greeting.isShouted() -> "Whoa, chill out!"
                greeting.isAQuestion() -> "Sure."
                else -> "Whatever."
            }
}

private fun String.isSilence(): Boolean {
    val spaces = Regex("[\\s\\t\\n]")
    return this.replace(spaces, "").isEmpty()
}

private fun String.isAQuestion(): Boolean = this.trim().endsWith("?")

private fun String.isShouted(): Boolean {
    val nonLetters = Regex("[^A-Za-z]")
    val onlyLetters = this.replace(nonLetters, "")
    return !onlyLetters.isEmpty() && onlyLetters.isUpperCase()
}

private fun String.isUpperCase(): Boolean = this.all { c -> c in ('A'..'Z') }