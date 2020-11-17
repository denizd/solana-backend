package database

import data.SolanaFile
import java.sql.ResultSet

/**
 * Retrieves a single [SolanaFile] object from a given [ResultSet].
 * Does not perform checks, e.g. whether the ResultSet is empty or
 * at the end.
 *
 * @receiver    the ResultSet to extract from
 * @return      an object of type SolanaFile
 */
fun ResultSet.getSolanaFile(): SolanaFile =
    SolanaFile(getString("file_name"), getString("type"), getString("hash"), getInt("id"))

/**
 * Checks if a given file exists based on its file name as well as
 * its MD5 hash.
 *
 * This is done to prevent accidental re-uploading of existing images,
 * but permitting images that might be equal in content, but different
 * in file name, as this scenario might imply either a deliberate upload
 * attempt or an upload of an image that already exists in the database,
 * but the user may be unaware of, which might otherwise create confusion.
 *
 * This function uses the [SolanaFile] class to enable checking of a
 * file's existence based on its file name as well as its hash without
 * uploading the file's contents, as that would consume substantially
 * more bandwidth and device resources.
 *
 * @receiver    the database to read from
 * @param       checkedFile identifying information for the checked file
 * @return      whether the file exists, based on whether file name and hash
 *              are found in the database
 */
fun SolanaDatabase.checkIfFileExists(checkedFile: SolanaFile): Boolean {
    this.getAllFiles().filter { it.fileName == checkedFile.fileName }.forEach { file ->
        if (file.hash == checkedFile.hash) return true
    }
    return false
}
