package database

import data.SolanaFile
import util.DATABASE_FILE
import util.getFile
import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement

class SolanaDatabase {

    private val connection: Connection
    private val allFilesStatement: PreparedStatement

    init {
        getFile(DATABASE_FILE)
        connection = DriverManager.getConnection("jdbc:sqlite:${DATABASE_FILE}")
        connection.createStatement().executeUpdate(CREATE_TABLE_FILE)

        // Initialization of prepared statements
        allFilesStatement = connection.prepareStatement(GET_ALL_FILES)
    }

    // TODO store in a variable and update whenever an entry gets added
    fun getAllFiles(): List<SolanaFile> = arrayListOf<SolanaFile>().also { arrayList ->
        allFilesStatement.executeQuery().let { rs ->
            while (rs.next()) arrayList.add(
                rs.getSolanaFile()
            )
        }
    }.toList()
}
