class Anagram(private val value: String) {

    private val letters = sortedLetters(value)

    private fun sortedLetters(input: String) = input.toLowerCase().toCharArray().sorted()

    private fun sameWord(s: String) = s.toLowerCase() == value.toLowerCase()

    fun match(inputs: List<String>): Set<String> =
            inputs.filter { s -> !sameWord(s) }
                  .filter { s -> sortedLetters(s) == letters }
                  .toSet()

}