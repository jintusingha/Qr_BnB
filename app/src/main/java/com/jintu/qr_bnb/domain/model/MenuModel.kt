package com.jintu.qr_bnb.domain.model

data class ScreenDataModel(

    val tabNames: List<String>,

    val courseList: List<CourseItem>
)

data class CourseItem(
    val name: String,
    val description: String,
    val imageUrl: Int,
    val initialQuantity: Int = 1
)