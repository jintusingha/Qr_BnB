package com.jintu.qr_bnb.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.jintu.qr_bnb.R

@Composable
fun AppTopBar(

    titleContent: @Composable () -> Unit,

    startAction: @Composable (() -> Unit)? = null,

    endAction: @Composable (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(R.dimen.padding_medium))
            .heightIn(min = 56.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (startAction != null) {
            startAction()
        } else {
//            Spacer(modifier = Modifier.weight(1f))
        }


        Spacer(modifier = Modifier.weight(0.5f))
        titleContent()
        Spacer(modifier = Modifier.weight(0.5f))


        if (endAction != null) {
            endAction()
        } else {
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}