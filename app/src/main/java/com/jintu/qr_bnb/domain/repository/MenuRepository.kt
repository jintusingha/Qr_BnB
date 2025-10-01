package com.jintu.qr_bnb.domain.repository

import com.jintu.qr_bnb.domain.model.ScreenDataModel



interface MenuRepository {

    suspend fun getMenuScreenData(): ScreenDataModel
}