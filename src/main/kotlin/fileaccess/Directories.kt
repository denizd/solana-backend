package fileaccess

import java.nio.file.Paths
import server.Main

/**
 * Directories used for local file access.
 */
object Directories {

    // TODO test if this works after change from [File] to [Paths]
    val ROOT_DIRECTORY: String = Paths.get(Main::class.java.protectionDomain.codeSource.location.toURI()).toAbsolutePath().toString().let { path ->
        path.substring(0, path.lastIndexOf('\\')).replace("\\", "/")
    }
    val SETTINGS_FILE: String = "$ROOT_DIRECTORY/settings.json"
    val DATABASE_FILE: String = "$ROOT_DIRECTORY/solana.sqlite"
    val LOG_DIRECTORY: String = "$ROOT_DIRECTORY/log/"
    val CONTENT_DIRECTORY: String = "$ROOT_DIRECTORY/content/"
}
