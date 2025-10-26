package com.example.gamer.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamer.R
import com.example.gamer.ui.theme.GamerTheme

data class Event(
    val imageRes: Int,
    val title: String,
    val plateform: String,
    val price: String
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StoreScreen(modifier: Modifier = Modifier) {
    val events = listOf(
        Event(R.drawable.granturismo4, stringResource(R.string.GT4), stringResource(R.string.gamePlatform1), stringResource(R.string.gamePrice1)),
        Event(R.drawable.limbo, stringResource(R.string.LIMBO), stringResource(R.string.gamePlatform2), stringResource(R.string.gamePrice2)),
        Event(R.drawable.grandtheftauto, stringResource(R.string.GTA), stringResource(R.string.gamePlatform3), stringResource(R.string.gamePrice3)),
        Event(R.drawable.driver, stringResource(R.string.DRIVER), stringResource(R.string.gamePlatform4), stringResource(R.string.gamePrice4)),
        Event(R.drawable.madworld, stringResource(R.string.MADWORLD), stringResource(R.string.gamePlatform5), stringResource(R.string.gamePrice5)),
        Event(R.drawable.nfs_mostwanted, stringResource(R.string.NF), stringResource(R.string.gamePlatform6), stringResource(R.string.gamePrice6))
    )

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier
            .padding(vertical = 10.dp)
            .fillMaxSize()
    ) {
        items(events) { event ->
            EventItem(
                image = event.imageRes,
                title = event.title,
                plateform = event.plateform,
                price = event.price
            )
        }
    }
}

@Composable
fun EventItem(image: Int, title: String, plateform: String, price: String) {
    Card(
        onClick = {},
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp),
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(165.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxHeight()
            )
            Column(
                modifier = Modifier
                    .padding(vertical = 12.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = title,
                    textAlign = TextAlign.Left,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp),
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
                Text(
                    text = plateform,
                    textAlign = TextAlign.Left,
                    color = MaterialTheme.colorScheme.secondary,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 14.sp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
                Text(
                    text = price,
                    textAlign = TextAlign.Left,
                    color = MaterialTheme.colorScheme.secondary,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 14.sp),
                    modifier = Modifier
                        .width(150.dp)
                        .weight(1f)
                )
                IconButton(onClick = {},
                    modifier = Modifier
                        .align(Alignment.End)
                ) {
                    Icon(imageVector = Icons.Filled.AddShoppingCart,
                        contentDescription = "Add to cart",
                        tint = MaterialTheme.colorScheme.primary)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun StoreScreenPreview() {
    GamerTheme {
        StoreScreen()
    }
}
