package ru.mixail_akulov.stu.a40_database_sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import ru.mixail_akulov.stu.a40_database_sqlite.model.accounts.AccountsRepository
import ru.mixail_akulov.stu.a40_database_sqlite.model.accounts.SQLiteAccountsRepository
import ru.mixail_akulov.stu.a40_database_sqlite.model.boxes.BoxesRepository
import ru.mixail_akulov.stu.a40_database_sqlite.model.boxes.SQLiteBoxesRepository
import ru.mixail_akulov.stu.a40_database_sqlite.model.settings.AppSettings
import ru.mixail_akulov.stu.a40_database_sqlite.model.settings.SharedPreferencesAppSettings
import ru.mixail_akulov.stu.a40_database_sqlite.model.sqlite.AppSQLiteHelper

object Repositories {

    private lateinit var applicationContext: Context

    // -- stuffs

    private val database: SQLiteDatabase by lazy<SQLiteDatabase> {
        AppSQLiteHelper(applicationContext).writableDatabase
    }

    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    private val appSettings: AppSettings by lazy {
        SharedPreferencesAppSettings(applicationContext)
    }

    // --- repositories

    val accountsRepository: AccountsRepository by lazy {
        SQLiteAccountsRepository(database, appSettings, ioDispatcher)
    }

    val boxesRepository: BoxesRepository by lazy {
        SQLiteBoxesRepository(database, accountsRepository, ioDispatcher)
    }

    /**
     * Call this method in all application components that may be created at app startup/restoring
     * (e.g. in onCreate of activities and services)
     */
    fun init(context: Context) {
        applicationContext = context
    }
}