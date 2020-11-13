package settings

import util.getFile
import util.indicesOf
import java.io.File

class Json(inputFile: File) {

    constructor(inputFilePath: String) : this(getFile(inputFilePath))

    val entries = inputFile.readText().split("\n").filter { it.isNotBlank() }.map { entry ->
        val indices = entry.indicesOf('"')
        Pair(entry.substring(indices[0] + 1..indices[1]), entry.substring(indices[2] + 1..indices[3]))
    }.toMap()

//    fun getSettingsPath(): String = entryMap[KEY_SETTINGS_PATH]
}
