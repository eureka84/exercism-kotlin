object BeerSong {
    fun verses(startingBottlesOnTheWall: Int, endingBottlesOnTheWall: Int): String =
            (startingBottlesOnTheWall downTo endingBottlesOnTheWall)
                    .joinToString(separator = "\n") { bottlesOnTheWall ->
                        firstVerse(bottlesOnTheWall) + secondVerse(bottlesOnTheWall, bottlesOnTheWall - 1)
                    }

    private fun firstVerse(n: Int) =
            "${n.bottles().capitalize()} of beer on the wall, ${n.bottles()} of beer.\n"

    private fun secondVerse(current: Int, remaining: Int): String {
        return when {
            current == 0 -> "Go to the store and buy some more, 99 bottles of beer on the wall.\n"
            remaining == 0 -> "Take it down and pass it around, no more bottles of beer on the wall.\n"
            else -> "Take one down and pass it around, ${remaining.bottles()} of beer on the wall.\n"
        }
    }

    private fun Int.bottles(): String = when (this) {
        1 -> "1 bottle"
        0 -> "no more bottles"
        else -> "$this bottles"
    }
}