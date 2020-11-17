package settings

import fileaccess.getFile
import util.indicesOf
import java.nio.file.Files
import java.nio.file.Path

class Json(inputFile: Path) {

    constructor(inputFilePath: String) : this(getFile(inputFilePath))

    val entries = Files.readAllLines(inputFile).filter { it.isNotBlank() }.map { entry ->
        val indices = entry.indicesOf('"')
        Pair(entry.substring(indices[0] + 1..indices[1]), entry.substring(indices[2] + 1..indices[3]))
    }.toMap()

//    fun getSettingsPath(): String = entryMap[KEY_SETTINGS_PATH]
}
