package database.data

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import database.Database
import org.koin.android.ext.koin.androidContext
import org.koin.core.scope.Scope

actual fun Scope.sqlDriverFactory(): SqlDriver {
    val driver = AndroidSqliteDriver(
        schema = Database.Schema,
        context = androidContext(),
        name = DbName,
    )

    return driver
}

