package com.example.gamer.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamer.R
import com.example.gamer.ui.theme.GamerTheme

data class News(
    val title: String,
    val description: String,
    val image: Int
)

@Composable
fun NewsScreen(modifier: Modifier = Modifier) {
    val news = listOf(
        News(
            stringResource(R.string.news1),
            stringResource(R.string.newsDesc1),
            R.drawable.nfs_mostwanted
        ),
        News(
            stringResource(R.string.news2),
            stringResource(R.string.newsDesc2),
            R.drawable.driver
        ),
        News(
            stringResource(R.string.news3),
            stringResource(R.string.newsDesc3),
            R.drawable.grandtheftauto
        ),
        News(
            stringResource(R.string.news1),
            stringResource(R.string.newsDesc1),
            R.drawable.limbo
        ),
        News(
            stringResource(R.string.news2),
            stringResource(R.string.newsDesc2),
            R.drawable.madworld
        ),
        News(
            stringResource(R.string.news3),
            stringResource(R.string.newsDesc3),
            R.drawable.granturismo4
        )

    )


    LazyColumn(
        modifier = modifier
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally

    ) {


        items(news) { newss->
            NewsItem(title = newss.title, description = newss.description, image = newss.image)

        }
    }

}

@Composable
fun NewsItem(title: String, description: String, image: Int) {
    Card(
        onClick = {},
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp),
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth(0.9f)
            .height(350.dp)
    ) {

        Image(
            painter = painterResource(id = image),
            contentDescription = "",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(175.dp)
        )
        Text(
            text = title, modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(), style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
        )
        Text(
            text = description,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()

        )
        TextButton (onClick = {},
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Show More")}
    }
}


@Preview(showBackground = true)
@Composable
fun NewsScreenPreview() {
    GamerTheme {
        NewsScreen()
    }
}

