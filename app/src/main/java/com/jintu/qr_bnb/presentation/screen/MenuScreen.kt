package com.jintu.qr_bnb.presentation.screen


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jintu.qr_bnb.R
import com.jintu.qr_bnb.presentation.model.CourseUiModel
import com.jintu.qr_bnb.presentation.components.AppTopBar
import com.jintu.qr_bnb.presentation.viewmodel.MenuViewModel
import com.jintu.qr_bnb.ui.components.AppScreenTitle

import com.jintu.qr_bnb.presentation.components.AddToCartButton
import com.jintu.qr_bnb.presentation.components.SearchBar
import com.jintu.qr_bnb.ui.theme.PrimaryBackground
import com.jintu.qr_bnb.ui.theme.QrBnbCourseDescriptionText
import com.jintu.qr_bnb.ui.theme.jakartaFontFamily



@Composable
fun MenuTopBarContent(onBackClick: () -> Unit, onPlaceOrderClick: () -> Unit) {
    AppTopBar(
        titleContent = { AppScreenTitle("Food") },
        startAction = {
            IconButton(onClick = onBackClick) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow),
                    contentDescription = "Go back",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        endAction = {
            TextButton(onClick = onPlaceOrderClick) {
                Text(
                    text = "Place Order",
                    color = Color(0xFF945454),
                    fontSize = 16.sp,
                    fontFamily = jakartaFontFamily,
                    fontWeight = FontWeight.W700
                )
            }
        }
    )
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MenuScreen(viewModel: MenuViewModel = hiltViewModel()) {
    val uiState by viewModel.menuState.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val selectedTabIndex by viewModel.selectedTabIndex.collectAsState()


    val quantityMap = remember { mutableMapOf<String, Int>() }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryBackground),
        contentPadding = PaddingValues(vertical = 12.dp)
    ) {
        stickyHeader {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(PrimaryBackground)
                    .padding(vertical = 8.dp)
            ) {
                MenuTopBarContent(
                    onBackClick = { /* Handle navigation back */ },
                    onPlaceOrderClick = { /* Handle place order action */ }
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.height_medium)))


                SearchBar(
                    value = searchQuery,
                    onValueChange = { viewModel.onSearchQueryChange(it) },
                    placeholder = "Search for food",
                    modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium))
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.height_medium)))

                MenuTabs(
                    tabNames = uiState.tabNames,
                    selectedTabIndex = selectedTabIndex,
                    onTabSelected = { index -> viewModel.onTabSelected(index) }
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.height_medium)))
            }
        }

        items(uiState.courseList) { course ->
            CourseItemRow(
                course = course,
                quantity = quantityMap[course.name] ?: 0,
                onQuantityChange = { newQuantity ->
                    quantityMap[course.name] = newQuantity
                },
                onAddToCart = {
                    quantityMap[course.name] = 1
                }
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.height_medium)))
        }

        if (uiState.courseList.isEmpty()) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Loading Menu...", color = Color.Gray)
                }
            }
        }
    }
}




@Composable
fun MenuTabs(tabNames: List<String>, selectedTabIndex: Int, onTabSelected: (Int) -> Unit) {
    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        edgePadding = dimensionResource(R.dimen.padding_medium),
        containerColor = Color.Transparent,
        indicator = {},
        divider = {}
    ) {
        tabNames.forEachIndexed { index, tabName ->
            val isSelected = index == selectedTabIndex

            Tab(
                selected = isSelected,
                onClick = { onTabSelected(index) },
                modifier = Modifier
                    .padding(end = 8.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        color = if (isSelected) Color(0xFFE5B0AD) else Color(0xFFF2E8E8)
                    )
            ) {
                Text(
                    text = tabName,
                    color = if (isSelected) Color.White else Color.Black,
                    fontWeight = FontWeight.W500,
                    fontFamily = jakartaFontFamily,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                )
            }
        }
    }
}



@Composable
fun CourseItemRow(
    course: CourseUiModel,
    quantity: Int,
    onQuantityChange: (Int) -> Unit,
    onAddToCart: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(R.dimen.padding_medium))
            .background(Color.White, RoundedCornerShape(12.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = course.imageUrl),
            contentDescription = course.name,
            modifier = Modifier
                .width(100.dp)
                .height(76.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = course.name,
                fontWeight = FontWeight.W500,
                fontSize = 16.sp,
                fontFamily = jakartaFontFamily
            )
            Text(
                text = course.description.substringBefore(".") + ".",
                style = MaterialTheme.typography.QrBnbCourseDescriptionText
            )

            Spacer(modifier = Modifier.height(8.dp))


            AddToCartButton(

                onAddToCart = onAddToCart
            )
        }
    }
}