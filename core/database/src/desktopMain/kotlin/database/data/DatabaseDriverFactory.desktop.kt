package database.data

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import org.koin.core.scope.Scope
import java.io.File

actual fun Scope.sqlDriverFactory(): SqlDriver {
    val documentFolder = File(System.getProperty("compose.application.resources.dir"))

    if (!documentFolder.exists())
        documentFolder.mkdirs()

    val dbFile = File(documentFolder.path, DbName)
    val driver: SqlDriver = JdbcSqliteDriver(
        url = "jdbc:sqlite:${dbFile.path}",
    )

    return driver
}