object BeerSong {

    fun verses(initialBottles: Int, finalBottles: Int) =
        (initialBottles downTo finalBottles).joinToString(separator = "\n") { bottlesOnTheWall ->
            firstLine(bottlesOnTheWall) + secondLine(bottlesOnTheWall)
        }

    private fun firstLine(n: Int) = "${n.onTheWall().capitalize()}, ${n.bottles()}.\n"

    private fun secondLine(n: Int) = when (n) {
        0 -> "Go to the store and buy some more, ${99.onTheWall()}.\n"
        1 -> "Take it down and pass it around, ${0.onTheWall()}.\n"
        else -> "Take one down and pass it around, ${(n - 1).onTheWall()}.\n"
    }


    private fun Int.onTheWall() = "${this.bottles()} on the wall"

    private fun Int.bottles() = when (this) {
        1 -> "1 bottle of beer"
        0 -> "no more bottles of beer"
        else -> "$this bottles of beer"
    }
}