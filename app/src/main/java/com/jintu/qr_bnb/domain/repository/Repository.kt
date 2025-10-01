package com.jintu.qr_bnb.domain.repository

import com.jintu.qr_bnb.domain.model.MainScreenModel


interface CategoryRepository{
    suspend fun getCategories(): MainScreenModel
}


