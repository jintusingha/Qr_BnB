package com.jintu.qr_bnb.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import com.jintu.qr_bnb.R

import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jintu.qr_bnb.presentation.model.categoryResponseDto
import com.jintu.qr_bnb.presentation.model.subCategory
import com.jintu.qr_bnb.presentation.components.AppTopBar
import com.jintu.qr_bnb.presentation.viewmodel.MainViewModel
import com.jintu.qr_bnb.ui.components.AppCardTextStyle
import com.jintu.qr_bnb.ui.components.AppCategoryHeader
import com.jintu.qr_bnb.ui.components.AppScreenTitle
import com.jintu.qr_bnb.ui.theme.PrimaryBackground
import com.jintu.qr_bnb.ui.theme.QRB_CartIcon


@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {
    val mainData by viewModel.mainScreenData.observeAsState(initial = null)


        Box(
            modifier = Modifier
                .fillMaxSize()

                .background(PrimaryBackground)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(dimensionResource(R.dimen.padding_medium))
            ) {
                item {
                    WelcomeTopBar()
                    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.height_medium)))
                }

                mainData?.let { data ->
                    items(data.categoryList) { category ->
                        CategorySection(category = category)
                        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.height_large)))
                    }
                } ?: run {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Loading...", color = Color.Gray)
                        }
                    }
                }
            }
        }
    }


@Composable
fun WelcomeTopBar() {
    AppTopBar(

        titleContent = { AppScreenTitle("Welcome") },




        endAction = {
            IconButton(onClick = { /* Handle cart click */ }) {
                Icon(
                    painter = painterResource(R.drawable.shoppingcart),
                    contentDescription = "Cart",
                    tint = QRB_CartIcon,
                    modifier = Modifier.size(dimensionResource(R.dimen.icon_size_header_cart))
                )
            }
        }
    )
}

@Composable
fun CategorySection(category: categoryResponseDto) {
    Column(

        modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium))
    ) {
        AppCategoryHeader(category.categoryName, modifier = Modifier)

        SubCategoryGrid(subCategorylist = category.subCategoryList)
    }
}

@Composable
fun SubCategoryGrid(subCategorylist: List<subCategory>) {

    val chunkedList = subCategorylist.chunked(3)

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        chunkedList.forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                rowItems.forEach { item ->
                    SubCategoryCard(
                        item = item,
                        modifier = Modifier.weight(1f)
                    )
                }

                repeat(3 - rowItems.size) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun SubCategoryCard(
    item: subCategory,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(R.dimen.sub_category_card))
                .clip(RoundedCornerShape(dimensionResource(R.dimen.corner_radius_medium))),
            shape = RoundedCornerShape(dimensionResource(R.dimen.corner_radius_medium))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(getCardBackgroundColor(item.name)),
                contentAlignment = Alignment.Center
            ) {
                if (item.image != 0) {
                    Image(
                        painter = painterResource(id = item.image),
                        contentDescription = item.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {

                    Text(
                        text = item.name.take(1),

                        color = Color.White
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacing_small)))

        AppCardTextStyle(item.name)
    }
}

@Composable
fun getCardBackgroundColor(itemName: String): Color {

    return when (itemName.lowercase()) {
        "snacks" -> Color(0xFFFFE4B5)
        "local meals" -> Color(0xFFB8E6B8)
        "drinks" -> Color(0xFFFFD700)
        "guided treks" -> Color(0xFF87CEEB)
        "bike rentals" -> Color(0xFFDDA0DD)
        "rooms" -> Color(0xFFFFA07A)
        "towel" -> Color(0xFFF5DEB3)
        "dryer" -> Color(0xFFE6E6FA)
        "iron" -> Color(0xFF98FB98)
        else -> Color(0xFFF0F0F0)
    }
}