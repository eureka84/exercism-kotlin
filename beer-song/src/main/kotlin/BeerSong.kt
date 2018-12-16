object BeerSong {
    fun verses(from: Int, to: Int): String =
            (from downTo to).joinToString(separator = "\n") { bottlesOnTheWall -> verse(bottlesOnTheWall) }

    private fun verse(n: Int) = firstVerse(n) + secondVerse(n)

    private fun firstVerse(n: Int) = "${n.onTheWall().capitalize()}, ${n.bottles()}.\n"

    private fun secondVerse(n: Int): String =
            when (n) {
                0 -> "Go to the store and buy some more, ${99.onTheWall()}.\n"
                1 -> "Take it down and pass it around, ${(n - 1).onTheWall()}.\n"
                else -> "Take one down and pass it around, ${(n -1).onTheWall()}.\n"
            }


    private fun Int.onTheWall(): String = "${this.bottles()} on the wall"

    private fun Int.bottles(): String = when (this) {
        1 -> "1 bottle of beer"
        0 -> "no more bottles of beer"
        else -> "$this bottles of beer"
    }
}