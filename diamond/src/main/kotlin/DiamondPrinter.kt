class DiamondPrinter {

    fun printToList(c: Char): List<String> {
        val halfDiamond = ('A'..c).map { char ->
            val externalSpaces = (char distanceFrom c).spaces()
            when (char) {
                'A' -> externalSpaces + char + externalSpaces
                else -> {
                    val internalSpaces = (2 * (char distanceFrom 'A') - 1).spaces()
                    externalSpaces + char + internalSpaces + char + externalSpaces
                }
            }
        }
        return halfDiamond.plus(halfDiamond.reversed().drop(1))
    }

}

private infix fun Char.distanceFrom(other: Char) = Math.abs(this - other)
private fun Int.spaces(): String = " ".repeat(this)
