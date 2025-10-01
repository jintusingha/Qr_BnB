package com.jintu.qr_bnb.presentation.model



data class CourseUiModel(
    val name: String,
    val description: String,
    val imageUrl: Int,
    val initialQuantity: Int
)

data class MenuScreenUiState(
    val tabNames: List<String>,
    val courseList: List<CourseUiModel>
)