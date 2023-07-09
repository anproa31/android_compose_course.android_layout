package com.anbuiii.compose_article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anbuiii.compose_article.ui.theme.Compose_articleTheme
import com.anbuiii.compose_article.ui.theme.Dark_Green
import com.anbuiii.compose_article.ui.theme.Green
import com.anbuiii.compose_article.ui.theme.LightGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_articleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
//                    ComposeArticleApp()
//                    TaskManager()
//                    ComposeQuadrant()
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun ComposeArticleApp() {
    ArticleCard(
        title = stringResource(R.string.title_jetpack_compose_tutorial),
        shortDescription = stringResource(R.string.short_desc),
        longDescription = stringResource(id = R.string.long_desc),
        imagePainter = painterResource(id = R.drawable.bg_compose_background)
    )
}

@Composable
private fun ArticleCard(
    title: String,
    shortDescription: String,
    longDescription: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Image(painter = imagePainter, contentDescription = null)
        Text(text = title, modifier = Modifier.padding(16.dp), fontSize = 24.sp)
        Text(
            text = shortDescription,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = longDescription,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun TaskManager() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val image = painterResource(id = R.drawable.ic_task_completed)
        Image(painter = image, contentDescription = null)
        Text(
            text = stringResource(id = R.string.task_complete),
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = stringResource(id = R.string.nice_work), fontSize = 16.sp
        )
    }
}

@Composable
fun ComposeQuadrant() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposeInfoCard(
                title = stringResource(id = R.string.first_title),
                description = stringResource(id = R.string.first_description),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )

            ComposeInfoCard(
                title = stringResource(R.string.second_title),
                description = stringResource(R.string.second_description),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }

        Row(Modifier.weight(1f)) {
            ComposeInfoCard(
                title = stringResource(id = R.string.third_title),
                description = stringResource(id = R.string.third_description),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            ComposeInfoCard(
                title = stringResource(R.string.fourth_title),
                description = stringResource(R.string.fourth_description),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }

    }
}

@Composable
private fun ComposeInfoCard(
    title: String, description: String, backgroundColor: Color, modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title, modifier = Modifier.padding(bottom = 16.dp), fontWeight = FontWeight.Bold
        )
        Text(
            text = description, textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = LightGreen)
            .padding(top = 250.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Introduction(
            imagePainter = painterResource(id = R.drawable.android_logo),
            full_name = stringResource(id = R.string.full_name),
            title = stringResource(id = R.string.title)
        )
        Spacer(modifier = Modifier.padding(top = 200.dp))
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Contact(
                icon = painterResource(id = R.drawable.ic_baseline_local_phone_24),
                contact = stringResource(
                    id = R.string.contact_phone
                )
            )
            Contact(
                icon = painterResource(id = R.drawable.ic_baseline_share_24),
                contact = stringResource(
                    id = R.string.contact_website
                )
            )
            Contact(
                icon = painterResource(id = R.drawable.ic_baseline_email_24),
                contact = stringResource(
                    id = R.string.contact_email
                )
            )
        }
    }
}

@Composable
private fun Introduction(imagePainter: Painter, full_name: String, title: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = imagePainter, contentDescription = null,
            modifier = Modifier
                .height(120.dp)
                .width(120.dp)
                .background(Dark_Green),
        )
        Text(
            text = full_name,
            color = Color.Black,
            modifier = Modifier.padding(top = 10.dp, bottom = 15.dp),
            fontSize = 40.sp
        )
        Text(text = title, color = Green, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun Contact(icon: Painter, contact: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp, start = 80.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(painter = icon, contentDescription = null)
        Text(text = contact, modifier = Modifier.padding(start = 25.dp), color = Dark_Green)
    }
}


@Preview(showBackground = true)
@Composable
fun ComposeArticlePreview() {
    Compose_articleTheme {
//        ComposeArticleApp()
//        TaskManager()
//        ComposeQuadrant()
        BusinessCardApp()
    }
}




