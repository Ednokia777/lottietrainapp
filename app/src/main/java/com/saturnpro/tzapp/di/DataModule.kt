package com.saturnpro.tzapp.di

import com.saturnpro.tzapp.data.repositories.DownloadRepoImpl
import com.saturnpro.tzapp.domain.repositories.DownloadRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    private const val BASEURL = "https://wowowcleaner.com"

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASEURL)
        .build()

    @Singleton
    @Provides
    fun provideDownloadMusicRepoImpl(retrofit: Retrofit): DownloadRepository = DownloadRepoImpl(retrofit)
}