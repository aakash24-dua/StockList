package com.et.stocklist.di


import com.et.stocklist.ui.MainViewmodel
import com.et.stocklist.utils.NetworkService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

    val networkModule = module {
      
        viewModel {
            MainViewmodel(get())
        }
        single { NetworkService() }
    }
