package ru.mixail_akulov.stu.a40_database_sqlite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.mixail_akulov.stu.a40_database_sqlite.screens.splash.SplashFragment
import ru.mixail_akulov.stu.a40_database_sqlite.screens.splash.SplashViewModel

/**
 * Entry point of the app.
 *
 * Splash activity contains only window background, all other initialization logic is placed to
 * [SplashFragment] and [SplashViewModel].
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Repositories.init(applicationContext)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

}