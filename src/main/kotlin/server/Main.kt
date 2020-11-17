package server

import database.SolanaDatabase
import fileaccess.Directories
import logging.Logger
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

class Main {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Main()
        }
    }

    init {

        if (!Files.exists(Paths.get(Directories.SETTINGS_FILE))) {
            println(initializeFileStructure())
        }
        val db = SolanaDatabase()
//        val settings = Settings()
    }

    private fun initializeFileStructure(): Boolean =
        try {
            Files.createDirectory(Paths.get(Directories.LOG_DIRECTORY))
            Files.createDirectory(Paths.get(Directories.CONTENT_DIRECTORY))
            Logger.log("Server started for the first time", Logger.INFO)
            true
        } catch (e: IOException) {
            false
        }
}
