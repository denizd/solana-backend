package database

object Queries {

    /**
     * Query for creating a 'file' table. Corresponds to [data.SolanaFile].
     */
    const val CREATE_TABLE_FILE = "CREATE TABLE IF NOT EXISTS file (file_name TEXT NOT NULL, type TEXT NOT NULL, hash TEXT NOT NULL, id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT);"

    /**
     * Retrieves all file entries from the database. ResultSet of this query
     * will contain objects of type [data.SolanaFile]
     */
    const val GET_ALL_FILES = "SELECT * FROM file"
}
