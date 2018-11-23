import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitParamsRunner::class)
class IsogramTest() {

    @Test
    @Parameters(
        ", true",
        "isogram, true",
        "eleven, false",
        "subdermatoglyphic, true",
        "Alphabet, false",
        "Emily Jung Schwartzkopf, true",
        "accentor, false",
        "six-year-old, true",
        "thumbscrew-japingly, true"
    )
    fun test(input: String, expectedOutput: Boolean) {
        assertEquals(expectedOutput, Isogram.isIsogram(input))
    }

}
