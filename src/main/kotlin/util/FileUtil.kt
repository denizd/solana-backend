package util

import java.io.File

fun getFile(path: String, createIfNotFound: Boolean = true): File =
    File(path).apply { if (createIfNotFound) createNewFile() }
