package com.jintu.qr_bnb.data.repository

import com.jintu.qr_bnb.R
import com.jintu.qr_bnb.domain.repository.MenuRepository
import com.jintu.qr_bnb.domain.model.CourseItem
import com.jintu.qr_bnb.domain.model.ScreenDataModel
import javax.inject.Inject



class MenuRepositoryImpl@Inject constructor() : MenuRepository {


    override suspend fun getMenuScreenData(): ScreenDataModel {


        val courses = listOf(
            CourseItem(
                name = "Authentic Italian",
                description = "Learn to make pasta from scratch with a focus on fresh doughs and classic sauces.",
                imageUrl = R.drawable.authenticitalian,
                initialQuantity = 1
            ),
            CourseItem(
                name = "Sushi Rolling",
                description = "Master the art of sushi rolling with expert techniques for rice prep and perfect cuts.",
                imageUrl = R.drawable.sushirollin,
                initialQuantity = 1
            ),
            CourseItem(
                name = "Taco Fiesta",
                description = "Create a variety of tacos with homemade tortillas, marinades, and fresh toppings.",
                imageUrl = R.drawable.tacofiesta,
                initialQuantity = 1
            ),
            CourseItem(
                name = "French Pastry",
                description = "Bake classic French pastries like croissants and pain au chocolat from scratch.",
                imageUrl = R.drawable.frenchpastry,
                initialQuantity = 1
            ),
            CourseItem(
                name = "Thai Street Food",
                description = "Explore the bold, balanced flavors of Thai street food including Pad Thai and green curry.",
                imageUrl = R.drawable.authenticitalian,
                initialQuantity = 1
            )
        )


        val tabs = listOf("Breakfast", "Lunch", "Beverages")


        return ScreenDataModel(
            tabNames = tabs,
            courseList = courses
        )
    }
}