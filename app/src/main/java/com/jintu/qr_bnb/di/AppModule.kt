package com.jintu.qr_bnb.di

import com.jintu.qr_bnb.data.repository.CategoryRepositoryDummyImpl
import com.jintu.qr_bnb.domain.repository.CategoryRepository
import com.jintu.qr_bnb.domain.usecase.GetCategoriesUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CategoryRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCategoryRepository(
        categoryRepositoryDummyImpl: CategoryRepositoryDummyImpl
    ): CategoryRepository
}

@Module
@InstallIn(SingletonComponent::class)
class CategoryUseCaseModule  {


    @Provides
    fun provideGetCategoriesUseCase(repository: CategoryRepository): GetCategoriesUseCase {
        return GetCategoriesUseCase(repository)
    }
}



