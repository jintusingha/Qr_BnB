package com.jintu.qr_bnb.domain.usecase

import com.jintu.qr_bnb.domain.model.MainScreenModel
import com.jintu.qr_bnb.domain.repository.CategoryRepository


class GetCategoriesUseCase (private val repository: CategoryRepository){
    suspend operator fun invoke(): MainScreenModel{
        return repository.getCategories()
   }
}





