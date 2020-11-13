package data

/**
 * Basic representation of a file in the program's structure.
 * Different data types are discerned through the use of the
 * [type] parameter.
 */
data class SolanaFile(
    val id: Int,
    val fileName: String,
    val hash: String,
    val type: String,
) {
    val fileIdentifier: FileIdentifier get() = FileIdentifier(fileName, hash)

    companion object {
        const val TYPE_PHOTO = "photo"
        const val TYPE_VIDEO = "video"
    }
}