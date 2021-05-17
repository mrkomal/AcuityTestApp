package com.example.acuitytestapp.di

import com.example.acuitytestapp.repository.ResultRepository
import com.example.acuitytestapp.repository.ResultsRepositoryImpl
import com.example.acuitytestapp.viewmodel.ResultViewModel
import com.example.acuitytestapp.viewmodel.ScoreViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // ViewModels
    viewModel { ScoreViewModel( get() ) }
    viewModel { ResultViewModel( get() ) }

    // Common Repository to hold results
    single<ResultRepository> { ResultsRepositoryImpl() }

}