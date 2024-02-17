package database.data

import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import org.koin.core.scope.Scope

internal const val DbName = "database.db"

expect fun Scope.sqlDriverFactory(): SqlDriver


