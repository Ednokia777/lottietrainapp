package com.saturnpro.tzapp.di

import com.saturnpro.tzapp.domain.repositories.DownloadRepository
import com.saturnpro.tzapp.domain.usecases.DownloadRaitingsUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    fun provideDownloadMusicUseCase(downloadRepository: DownloadRepository): DownloadRaitingsUseCases =
        DownloadRaitingsUseCases(downloadRepository)
}