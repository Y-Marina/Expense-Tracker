package com.marina.expensetracker.feature.stats

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.marina.expensetracker.R
import com.marina.expensetracker.widget.ExpenseTextView

@Composable
fun StatsScreen(navController: NavController) {
    Scaffold(
        topBar = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.chevron_left),
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterStart),
                        colorFilter = ColorFilter.tint(Color.Black)
                    )
                    ExpenseTextView(
                        text = "Statistics",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.Center)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.dots_menu),
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.Center),
                        colorFilter = ColorFilter.tint(Color.Black)
                    )
                }
            }
    ) {
        Column(modifier = Modifier.padding(it)) { }
    }
}

@Composable
fun LineChart() {
}
