package fileaccess

import java.io.*
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Retrieves a file from the file system by accessing it through
 * its absolute path.
 *
 * @param   absolutePath the path to the file
 * @return  the file
 */
fun getFile(absolutePath: String): File = File(absolutePath)

/**
 * Calculates the MD5 hash sum of a file for verification.
 * Letters in the hash sum will be capitalized.
 *
 * @receiver    the file whose MD5 hash sum will be calculated
 * @return      the MD5 hash sum
 *
 * @throws      IOException if an error occurred during reading
 *              the file
 */
@Throws(IOException::class)
fun File.getMD5Hash(): String {
    val digest: MessageDigest = MessageDigest.getInstance("MD5")
    val stream: InputStream = FileInputStream(this)
    val buffer = ByteArray(8192)

    var read: Int
    while (stream.read(buffer).also { read = it } > 0) {
        digest.update(buffer, 0, read)
    }
    val bigInt = BigInteger(1, digest.digest())
    var output = bigInt.toString(16)
    stream.close()
    // Fill to 32 chars and convert letters to uppercase
    return String.format("%32s", output).replace(' ', '0').toUpperCase()
}
