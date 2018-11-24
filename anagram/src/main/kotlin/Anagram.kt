class Anagram(value: String){

    private val lowerCaseValue = value.toLowerCase()
    private val letters: Map<Char, Int> = lettersCount(value)

    private fun lettersCount(input: String): Map<Char, Int> {
        return input.groupBy { it.toLowerCase() }
                .map { (l, list) -> (l to list.size) }
                .toMap()
    }

    private fun sameWord(s: String) = s.toLowerCase() == lowerCaseValue

    private fun hasSameLetters(s: String) = lettersCount(s) == letters

    fun match(inputs: List<String>): Set<String> =
        inputs.filter { s -> !sameWord(s) && hasSameLetters(s) }.toSet()

}