package com.dubizzle.ui

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale


class FontFamilyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setLocale()

        enableEdgeToEdge()
        setContentView(R.layout.activity_font_family)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.buttonChangeLanguage).apply {
            text = Locale.getDefault().language
        }.setOnClickListener {
            val pref = getSharedPreferences("localePref", MODE_PRIVATE)

            pref.apply {
                val isAr = getBoolean("isAr", false)
                edit().putBoolean("isAr", isAr.not()).apply()
            }
            setLocale()
        }

    }

    private fun setLocale() {
        val pref = getSharedPreferences("localePref", MODE_PRIVATE)
        val isAr = pref.getBoolean("isAr", false)
        val locale = Locale(if (isAr) "ar" else "en")
        Locale.setDefault(locale)

        val config: Configuration = baseContext.resources.configuration
        config.locale = locale
        baseContext.resources.updateConfiguration(
            config,
            baseContext.resources.displayMetrics
        )
        val localeListCompat = LocaleListCompat.forLanguageTags(locale.toLanguageTag())
        AppCompatDelegate.setApplicationLocales(localeListCompat)

    }

    private fun restartActivity() {
        val intent = intent
        finish()
        startActivity(intent)
    }
}