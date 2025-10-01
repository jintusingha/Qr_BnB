package com.jintu.qr_bnb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jintu.qr_bnb.presentation.navigation.AppNavigation


import com.jintu.qr_bnb.ui.theme.Qr_BnbTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Qr_BnbTheme {
                AppNavigation()

            }
        }
    }
}

