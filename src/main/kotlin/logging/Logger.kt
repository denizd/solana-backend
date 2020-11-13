package logging

import util.LOG_DIRECTORY
import util.getCurrentDate
import util.getCurrentDateTime
import util.getFile
import java.io.File
import java.io.OutputStreamWriter
import java.io.PrintStream

/**
 * This class is used for writing any log messages to a log file
 * in the directory <root>/log. Any messages that could be useful
 * to the end user for determining errors in the compiled program
 * should not be printed to the default output, but printed to an
 * appropriate file using [Logger.log].
 *
 * The function will also ensure that no single file grows too large
 * by creating a new file for every operational day. This is done
 * automatically and checked before each operation.
 */
class Logger {

    companion object {

        /**
         * Log type for a regular message to be used in [Logger.log]
         */
        const val LOG: String = "LOG"

        /**
         * Log type for an error message to be used in [Logger.log]
         */
        const val ERROR: String = "ERROR"

        /**
         * Log type for an informational message to be used in [Logger.log]
         */
        const val INFO: String = "INFO"

        /**
         * The current date to be used as a file name for the log file.
         * Example:
         * 2020-11-13
         */
        private var currentDate: String = getCurrentDate()

        /**
         * The log file stream to write to. File name represents the current day.
         */
        private var currentFileStream: OutputStreamWriter = createLogFile()

        /**
         * Writes a specific text to the current log file.
         *
         * @param   content the text to write
         * @param   logType the type of message this is
         */
        fun log(content: String, logType: String = LOG) {
            if (currentDate != getCurrentDate()) {
                currentDate = getCurrentDate()
                currentFileStream = createLogFile()
            }
            currentFileStream.append("${getCurrentDateTime()} $logType: $content\n")
        }

        /**
         * Creates a new log file based on the current date. The file name
         * looks as follows, for example:
         * 2020-11-13.txt
         * This is done to prevent creating a massive log file, and instead
         * split it up by the day.
         *
         * @return  the output stream of the appropriate log file for the current date
         */
        private fun createLogFile(): OutputStreamWriter =
            getFile("${LOG_DIRECTORY}/${currentDate}.txt").outputStream().writer()
    }
}
