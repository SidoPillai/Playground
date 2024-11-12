package com.androidnomad.playground.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.androidnomad.playground.models.Author
import com.androidnomad.playground.models.Item
import com.androidnomad.playground.ui.theme.MyApplicationTheme

@Composable
fun ItemCard(
    modifier: Modifier,
    item: Item,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .then(
                Modifier
                    .clickable {
                        onClick()
                    }
            ),
        shape = RoundedCornerShape(6.dp),
        content = {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://example.com/image.jpg")
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(com.androidnomad.playground.R.drawable.ic_placeholder),
                    contentDescription = "item thumbnail",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(300.dp, 400.dp)
                        .clip(RoundedCornerShape(6.dp)),
                )
            }
        }
    )
}

@Preview
@Composable
fun Preview_ItemCard() {

    val mockItem = Item(
        author = Author(
            fullName = "John Doe",
            id = "author123",
            thumbnailUrl = "https://example.com/thumbnail.jpg",
            udn = "johndoe123"
        ),
        created = System.currentTimeMillis(),
        firstPublished = System.currentTimeMillis() - 86400000L, // 1 day ago
        id = "item123",
        lastPublished = System.currentTimeMillis() - 43200000L, // 12 hours ago
        locale = "en-US",
        refresh = "Every 24 hours",
        snippet = "This is a sample snippet for the item, providing a quick summary of the content.",
        thumbnail = "https://example.com/item_thumbnail.jpg",
        title = "Sample Item Title",
        topics = listOf("Technology", "Science", "Education"),
        type = "Article"
    )

    MyApplicationTheme {
        ItemCard(
            modifier = Modifier,
            item = mockItem
        )
    }
}