class DiamondPrinter {

    fun printToList(c: Char): List<String> {
        val halfDiamond = ('A'..c).map { char ->
            val externalSpaces = (c - char).spaces()
            when (char) {
                'A' -> externalSpaces + char + externalSpaces
                else -> {
                    val internalSpaces = (2 * (char - 'A') - 1).spaces()
                    externalSpaces + char + internalSpaces + char + externalSpaces
                }
            }
        }
        return halfDiamond.plus(halfDiamond.reversed().drop(1))
    }

}

private fun Int.spaces(): String = " ".repeat(this)
