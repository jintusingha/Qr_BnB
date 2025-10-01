package com.jintu.qr_bnb.domain.mappers

import com.jintu.qr_bnb.presentation.model.MainResponseDto
import com.jintu.qr_bnb.presentation.model.categoryResponseDto
import com.jintu.qr_bnb.domain.model.CategoryModel
import com.jintu.qr_bnb.domain.model.MainScreenModel
import com.jintu.qr_bnb.domain.model.SubCategoryModel
import com.jintu.qr_bnb.presentation.model.subCategory

fun MainScreenModel.toViewModelModel(): MainResponseDto {
    return MainResponseDto(
        categoryList = this.categoryList.map { it.toViewModelModel() }
    )
}



fun CategoryModel.toViewModelModel(): categoryResponseDto {
    return categoryResponseDto(
        categoryName = this.categoryName,
        subCategoryList = this.subCategorylist.map { it.toViewModelModel() }
    )
}


fun SubCategoryModel.toViewModelModel(): subCategory {
    return subCategory(
        image = this.imageResId,
        name = this.name,
        subCategoryId = this.id
    )
}