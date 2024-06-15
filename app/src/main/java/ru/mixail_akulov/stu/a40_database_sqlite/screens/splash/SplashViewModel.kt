package ru.mixail_akulov.stu.a40_database_sqlite.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.mixail_akulov.stu.a40_database_sqlite.model.accounts.AccountsRepository
import ru.mixail_akulov.stu.a40_database_sqlite.utils.MutableLiveEvent
import ru.mixail_akulov.stu.a40_database_sqlite.utils.publishEvent
import ru.mixail_akulov.stu.a40_database_sqlite.utils.share

/**
 * SplashViewModel checks whether user is signed-in or not.
 */
class SplashViewModel(
    private val accountsRepository: AccountsRepository
) : ViewModel() {

    private val _launchMainScreenEvent = MutableLiveEvent<Boolean>()
    val launchMainScreenEvent = _launchMainScreenEvent.share()

    init {
        viewModelScope.launch {
            _launchMainScreenEvent.publishEvent(accountsRepository.isSignedIn())
        }
    }
}