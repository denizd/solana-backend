package data

/**
 * Used for identifying a file in the database without storing the
 * actual file content. This is useful, as uploading the file's content
 * may be very resource-expensive. This way, only two strings need to be
 * transferred, making a comparative operation much less demanding.
 */
class FileIdentifier(
    val fileName: String,
    hash: String,
) {
    /**
     * The calculated MD5 hash of the file to be used for comparisons.
     * Note that this program only uses hashes with uppercase letters,
     * therefore, any letters in this hash will be put into uppercase.
     */
    val hash: String = hash.toUpperCase()

    /*
     * Here follow overridden functions that are implemented by default
     * in a data class - as this class needs to ensure any hash passed
     * is in uppercase, and to simplify property access, it is only a
     * regular class, with the following functions overridden, in case
     * those are required.
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is FileIdentifier) return false
        return true
    }

    override fun hashCode(): Int = javaClass.hashCode()
}
