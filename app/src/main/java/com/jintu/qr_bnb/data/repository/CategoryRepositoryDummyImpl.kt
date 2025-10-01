package com.jintu.qr_bnb.data.repository

import com.jintu.qr_bnb.R
import com.jintu.qr_bnb.domain.model.CategoryModel
import com.jintu.qr_bnb.domain.repository.CategoryRepository
import com.jintu.qr_bnb.domain.model.MainScreenModel
import com.jintu.qr_bnb.domain.model.SubCategoryModel
import javax.inject.Inject


class  CategoryRepositoryDummyImpl @Inject constructor() : CategoryRepository{
    override suspend fun getCategories(): MainScreenModel {

        val snacks = SubCategoryModel(R.drawable.snacks, "snacks", "s1")
        val localMeals = SubCategoryModel(R.drawable.localmeals, "local meals", "s2")
        val chinese = SubCategoryModel(R.drawable.chinese, "chinese", "s3")

        val guidedTreks = SubCategoryModel(R.drawable.trek, "Guided Treks", "s4")
        val bikeRentals = SubCategoryModel(R.drawable.bikerentals, "Bike Rentals", "s5")
        val roomservice= SubCategoryModel(R.drawable.roomservice,"Roomservice","s6")

        val towel = SubCategoryModel(R.drawable.towels, "Towel", "s5")
        val dryer = SubCategoryModel(R.drawable.dryer, "Dryer", "s6")
        val iron= SubCategoryModel(R.drawable.iron,"Iron","s7")

        val foodCategory = CategoryModel("Food", listOf(snacks, localMeals, chinese))
        val addOnsCategory = CategoryModel("Add-ons", listOf(towel, dryer,iron))
        val servicesCategory = CategoryModel("services", listOf(guidedTreks, bikeRentals,roomservice))

        return MainScreenModel(
            categoryList = listOf(foodCategory, servicesCategory, addOnsCategory)
        )

    }
}