const val A = 'A'

class DiamondPrinter {

    fun printToList(c: Char): List<String> {
        val maxDist = c - A
        val halDiamond = (A..c).map { char ->
            val fromA = char - A
            val toC = maxDist - fromA
            val externalSpaces = toC.spaces()
            when (fromA) {
                0 -> externalSpaces + char + externalSpaces
                else -> {
                    val internalSpaces = (2 * fromA - 1).spaces()
                    externalSpaces + char + internalSpaces + char + externalSpaces
                }
            }
        }
        return halDiamond.plus(halDiamond.initial().reversed())
    }

}

private fun <T> List<T>.initial(): List<T> =
        when  {
            this.isEmpty() -> throw IllegalAccessException("initial of an empty list")
            else -> this.subList(0, this.size - 1)
        }

private fun Int.spaces(): String = " ".repeat(this)
