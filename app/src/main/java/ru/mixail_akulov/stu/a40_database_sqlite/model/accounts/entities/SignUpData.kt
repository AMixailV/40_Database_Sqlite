package ru.mixail_akulov.stu.a40_database_sqlite.model.accounts.entities

import ru.mixail_akulov.stu.a40_database_sqlite.model.EmptyFieldException
import ru.mixail_akulov.stu.a40_database_sqlite.model.Field
import ru.mixail_akulov.stu.a40_database_sqlite.model.PasswordMismatchException

/**
 * Fields that should be provided during creating a new account.
 */
data class SignUpData(
    val username: String,
    val email: String,
    val password: String,
    val repeatPassword: String
) {
    fun validate() {
        if (email.isBlank()) throw EmptyFieldException(Field.Email)
        if (username.isBlank()) throw EmptyFieldException(Field.Username)
        if (password.isBlank()) throw EmptyFieldException(Field.Password)
        if (password != repeatPassword) throw PasswordMismatchException()
    }
}