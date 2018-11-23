object Isogram {

    fun isIsogram(input: String): Boolean =
        input.toLowerCase()
                .filter { c -> c.isLetter() }
                .let { onlyLetters -> onlyLetters.toSet().size == onlyLetters.length }

}