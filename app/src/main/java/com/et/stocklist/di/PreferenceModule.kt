package com.et.stocklist.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.et.stocklist.ui.MainViewmodel
import com.et.stocklist.utils.NetworkService
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

    val preferencesModule = module {
        single { provideSettingsPreferences(androidApplication()) }
        single { provideNetworkService() }
        viewModel {
            MainViewmodel(get())
        }
    }

    private const val PREFERENCES_FILE_KEY = "com.example.settings_preferences"

    private fun provideSettingsPreferences(app: Application): SharedPreferences =
        app.getSharedPreferences(PREFERENCES_FILE_KEY, Context.MODE_PRIVATE)

    private fun provideNetworkService() : NetworkService = NetworkService()


