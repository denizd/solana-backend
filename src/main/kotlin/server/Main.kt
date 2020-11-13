package server

import database.SolanaDatabase
import logging.Logger
import util.*
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

        if (!Files.exists(Paths.get(SETTINGS_FILE))) {
            println(initializeFileStructure())
        }
        val db = SolanaDatabase()
//        val settings = Settings()
    }

    private fun initializeFileStructure(): Boolean =
        try {
            Files.createDirectory(Paths.get(LOG_DIRECTORY))
            Files.createDirectory(Paths.get(CONTENT_DIRECTORY))
            Logger.log("Server started for the first time", Logger.INFO)
            true
        } catch (e: IOException) {
            false
        }
}
