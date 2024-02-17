package database.di


import database.data.addMigration
import database.data.createDatabase
import database.data.sqlDriverFactory
import org.koin.dsl.module

val databaseModule = module {
    factory { addMigration(sqlDriverFactory()) }
    single { createDatabase(driver = get()) }
}