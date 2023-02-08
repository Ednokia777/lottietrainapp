package com.saturnpro.tzapp.di

import com.saturnpro.tzapp.presentation.adapter.CardRaitingAdapter
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {
    @Singleton
    @Provides
    fun provideCoroutineScope(): CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    @Singleton
    @Provides
    fun providePicasso(): Picasso = Picasso.get()


    @Singleton
    @Provides
    fun provideCardAdapter(
        picasso: Picasso
    ): CardRaitingAdapter = CardRaitingAdapter(picasso)

    @Singleton
    @Provides
    @Named("domain")
    fun provideMainDomain(): String = "https://wowowcleaner.com"


}