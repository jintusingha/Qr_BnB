package com.jintu.qr_bnb.domain.mappers

import com.jintu.qr_bnb.domain.model.CourseItem
import com.jintu.qr_bnb.domain.model.ScreenDataModel
import com.jintu.qr_bnb.presentation.model.CourseUiModel
import com.jintu.qr_bnb.presentation.model.MenuScreenUiState




fun CourseItem.toUiModel(): CourseUiModel {
    return CourseUiModel(
        name = this.name,
        description = this.description,
        imageUrl = this.imageUrl,
        initialQuantity = this.initialQuantity
    )
}


fun ScreenDataModel.toUiState(): MenuScreenUiState {
    return MenuScreenUiState(
        tabNames = this.tabNames,
        courseList = this.courseList.map { it.toUiModel() }
    )
}