package util

import server.Main
import java.io.File

val ROOT_DIRECTORY: String = File(Main::class.java.protectionDomain.codeSource.location.toURI()).path.let { path ->
    path.substring(0, path.lastIndexOf('\\')).replace("\\", "/")
}
val SETTINGS_FILE: String = "${ROOT_DIRECTORY}/settings.json"
val DATABASE_FILE: String = "${ROOT_DIRECTORY}/solana.sqlite"
val LOG_DIRECTORY: String = "${ROOT_DIRECTORY}/log/"
val CONTENT_DIRECTORY: String = "${ROOT_DIRECTORY}/content/"
