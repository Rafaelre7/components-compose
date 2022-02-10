package com.example.components_compose.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.components_compose.BuildConfig
import com.example.components_compose.navigation.screenDrawer
import com.example.components_compose.ui.theme.Purple500

@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onDestinationClicked: (route: String, title: String) -> Unit
) {
    val versionName = BuildConfig.VERSION_NAME

    Column(
        modifier
            .background(Purple500)
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
            ) {
                Text(
                    text = "Componenents Compose",
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "v $versionName",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

        Divider(color = Color.White, thickness = 1.dp)

        screenDrawer.forEach { screen ->
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier
                    .clickable {
                        onDestinationClicked(screen.title, screen.route)
                    }
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(screen.icon, contentDescription = "Small Icon", tint = Color.White)

                Text(
                    text = screen.title,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
        }

    }
}