object BeerSong {
    fun verses(from: Int, to: Int): String =
            (from downTo to).joinToString(separator = "\n") { bottlesOnTheWall -> verse(bottlesOnTheWall) }

    private fun verse(bottlesOnTheWall: Int) =
            firstVerse(bottlesOnTheWall) + secondVerse(bottlesOnTheWall, bottlesOnTheWall - 1)

    private fun firstVerse(n: Int) =
            "${n.bottles().capitalize()} of beer on the wall, ${n.bottles()} of beer.\n"

    private fun secondVerse(current: Int, remaining: Int): String =
            when (current) {
                0 -> "Go to the store and buy some more, ${99.onTheWall()}"
                1 -> "Take it down and pass it around, ${remaining.onTheWall()}"
                else -> "Take one down and pass it around, ${remaining.onTheWall()}"
            }


    private fun Int.onTheWall(): String = "${this.bottles()} of beer on the wall.\n"

    private fun Int.bottles(): String = when (this) {
        1 -> "1 bottle"
        0 -> "no more bottles"
        else -> "$this bottles"
    }
}