package com.jintu.qr_bnb.domain.usecase

import com.jintu.qr_bnb.domain.repository.MenuRepository
import com.jintu.qr_bnb.domain.model.ScreenDataModel
import javax.inject.Inject



class GetMenuScreenUseCase @Inject constructor(

    private val repository: MenuRepository
) {

    suspend operator fun invoke(): ScreenDataModel {

        return repository.getMenuScreenData()
    }
}