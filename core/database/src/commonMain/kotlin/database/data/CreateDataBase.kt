package database.data

import app.cash.sqldelight.db.SqlDriver
import database.Database

fun createDatabase(driver: SqlDriver): Database = Database(driver)