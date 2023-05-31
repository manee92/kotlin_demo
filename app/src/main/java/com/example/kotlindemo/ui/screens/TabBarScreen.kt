package com.example.kotlindemo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.DownloadDone
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlindemo.R
import com.example.kotlindemo.ui.theme.LightGreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


val recentListItems = listOf(
    RecentListItem(
        1,
        "Blue-tailed Bee-eater",
        "Lorem ipsum",
        R.drawable.bird_5,
        isFav = true,
        isSaved = true
    ),
    RecentListItem(2, "Indian Peafowl", "Lorem ipsum", R.drawable.bird_6, isSaved = true),
    RecentListItem(3, "Brahminy Starling", "Lorem ipsum", R.drawable.bird_4, isFav = true),
    RecentListItem(4, "Chestnut-headed Bee-eater", "Lorem ipsum", R.drawable.bird_1),
    RecentListItem(5, "Changeable Hawk-eagle", "Lorem ipsum", R.drawable.bird_3, isSaved = true),
)

sealed class TabScreen(
    val title: String,
    val icon: ImageVector,
    val screen: @Composable () -> Unit,
) {
    object Tab1 : TabScreen("Recent", Icons.Filled.AccessTime, screen = { RecentTab() })
    object Tab2 : TabScreen("Favourite", Icons.Filled.Favorite, screen = { FavouriteTab() })
    object Tab3 : TabScreen("Downloads", Icons.Filled.Download, screen = { DownloadsTab() })
}

@OptIn(ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TabBarScreen(
) {
    val tabs = listOf(TabScreen.Tab1, TabScreen.Tab2, TabScreen.Tab3)
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Tab bar demo")
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle navigation icon clicked */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Navigation menu")
                    }
                },
                backgroundColor = LightGreen,
                contentColor = Color.White,
                elevation = 0.dp,
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            Icons.Filled.MoreVert,
                            contentDescription = "Pop up",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) {
        Column() {
            TabRow(
                selectedTabIndex = pagerState.currentPage,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                    )
                },
            ) {
                tabs.forEachIndexed { index, item ->
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                        icon = {
                            Icon(imageVector = item.icon, contentDescription = "")
                        },
                        text = {
                            Text(
                                text = item.title,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                    )
                }
            }
            HorizontalPager(
                state = pagerState, count = tabs.size,
                verticalAlignment = Alignment.Top,
                modifier = Modifier.padding(top = 10.dp)
            ) { page ->
                tabs[page].screen()
            }
        }

    }
}

@Composable
fun RecentTab() {
    LazyColumn(
        verticalArrangement = Arrangement.Top
    ) {
        items(recentListItems) { item ->
            RecentListItem(item)
        }

    }
}

@Composable
fun FavouriteTab() {
    LazyColumn(
        verticalArrangement = Arrangement.Top
    ) {
        items(recentListItems) { item ->
            if(item.isFav) {
                RecentListItem(item)
            }
        }
    }
}

@Composable
fun DownloadsTab() {
    LazyColumn(
        verticalArrangement = Arrangement.Top
    ) {
        items(recentListItems) { item ->
            if(item.isSaved) {
                RecentListItem(item)
            }
        }
    }
}


@Composable
fun RecentListItem(item: RecentListItem) {
    Card(
        modifier = Modifier.padding(10.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 6.dp
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = "Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(size = 10.dp))
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .weight(2f)
            ) {
                Text(
                    text = item.title,
                    style = TextStyle(
                        color = Color(0xFF5c5c5c),
                        fontWeight = FontWeight.W600,
                        fontSize = 16.sp
                    )
                )
                Text(text = item.subtitle,
                    style = TextStyle(
                    color = Color(0xFF5c5c5c),
                ))
            }
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = if (item.isFav) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "",
                    tint = Color(0xFFE93224)
                )
            }
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = if (item.isSaved) Icons.Outlined.DownloadDone else Icons.Filled.Download,
                    contentDescription = "",
                    tint = Color(0xFF757474)
                )
            }
        }
    }
}


data class RecentListItem(
    val id: Int,
    val title: String,
    val subtitle: String,
    val image: Int,
    val isFav: Boolean = false,
    val isSaved: Boolean = false
)


