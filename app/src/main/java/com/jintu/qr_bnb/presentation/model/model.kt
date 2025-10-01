package com.jintu.qr_bnb.presentation.model





data class subCategory(
    val image: Int,
    val name: String,
    val subCategoryId: String
)

data class categoryResponseDto(
    val categoryName:String,
    val subCategoryList:List<subCategory>
)

data class MainResponseDto(
    val categoryList:List<categoryResponseDto>
)