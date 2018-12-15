const val A = 'A'

class DiamondPrinter {

    fun printToList(c: Char): List<String> {
        val halfDiamond = (A..c).map { char ->
            val fromA = char - A
            val externalSpaces = (c - char).spaces()
            when (fromA) {
                0 -> externalSpaces + char + externalSpaces
                else -> {
                    val internalSpaces = (2 * fromA - 1).spaces()
                    externalSpaces + char + internalSpaces + char + externalSpaces
                }
            }
        }
        return halfDiamond.plus(halfDiamond.reversed().drop(1))
    }

}

private fun Int.spaces(): String = " ".repeat(this)
