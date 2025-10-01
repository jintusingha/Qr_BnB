package com.jintu.qr_bnb.di

import com.jintu.qr_bnb.domain.usecase.GetMenuScreenUseCase
import com.jintu.qr_bnb.domain.repository.MenuRepository





import com.jintu.qr_bnb.data.repository.MenuRepositoryImpl

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMenuRepository(

        menuRepositoryImpl: MenuRepositoryImpl
    ): MenuRepository
}


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides

    fun provideGetMenuScreenUseCase(repository: MenuRepository): GetMenuScreenUseCase {

        return GetMenuScreenUseCase(repository)
    }
}