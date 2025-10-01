package com.jintu.qr_bnb.domain.model



data class MainScreenModel(
    val categoryList: List<CategoryModel>
)

data class CategoryModel(
    val categoryName: String,
    val subCategorylist: List<SubCategoryModel>
)

data class SubCategoryModel(
    val imageResId: Int,
    val name: String,
    val id: String
)