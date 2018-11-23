object Pangram {
    private val alphabet = ('a'..'z').toSet()

    fun isPangram(input: String): Boolean =
            input.toLowerCase().toSet().containsAll(alphabet)
}