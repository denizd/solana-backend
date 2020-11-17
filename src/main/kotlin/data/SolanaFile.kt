package data

import java.nio.file.Path
import java.nio.file.Paths

/**
 * Basic representation of a file in the program's structure.
 * Different data types are discerned through the use of the
 * [type] parameter.
 *
 * Default values are provided for attributes that are only
 * required for objects in the application's database, and
 * are not needed for objects transferred from a client.
 */
data class SolanaFile(
    val fileName: String,
    val type: String,
    val hash: String,
    val id: Int = 0,
    val path: String = "",
) {
//    val fileIdentifier: FileIdentifier get() = FileIdentifier(fileName, hash)

    /**
     * The actual file containing all the data to be found
     * in the local file system. Marked as lazy to prevent
     * the file from being loaded during the object's
     * initialization, while being cached if this variable
     * is called multiple times in succession.
     */
    val file: Path by lazy { Paths.get(path) }

    companion object {

        /**
         * An image file. Formats include .png, .jpg, .gif, .bmp
         */
        const val TYPE_PHOTO = "photo"

        /**
         * A video file. Formats include .mp4, .webm, .avi, .mkv
         */
        const val TYPE_VIDEO = "video"
    }
}