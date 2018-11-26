fun transcribeToRna(dna: String): String {
    val translationMap = mapOf(
        'C' to 'G',
        'A' to 'U',
        'T' to 'A',
        'U' to 'A',
        'G' to 'C'
    )

    val toComplement = { nucleotide: Char ->
        if (nucleotide in translationMap)
            translationMap[nucleotide]
        else
            throw Exception("Not a nucleotide!")
    }

    return dna.map { nucleotide -> toComplement(nucleotide) }.joinToString(separator = "")
}
