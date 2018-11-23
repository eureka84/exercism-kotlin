object Isogram {

    fun isIsogram(input: String): Boolean =
        input.toCharArray()
                .filter { c -> c.isLetter() }
                .groupBy { it.toLowerCase() }
                .map { (_, listOfRepeatedChars) -> listOfRepeatedChars.size}
                .none { size -> size != 1 }


}