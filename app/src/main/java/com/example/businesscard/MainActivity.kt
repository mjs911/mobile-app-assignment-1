package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DisplayBusinessCard()
                }
            }
        }
    }
}

@Composable
fun DisplayBusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color(0xFF073042)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val logoImage = painterResource(id = R.drawable.android_logo)
        Image(
            painter = logoImage,
            contentDescription = "Android Logo",
            modifier = Modifier
                .height(120.dp)
                .width(150.dp)
        )
        Text(text = "Manjot Singh", color = Color.White, fontSize = 32.sp)
        Text(text = "Android Developer", color = Color(0xFF3ddc84))
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 50.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {
        Divider(modifier = Modifier.fillMaxWidth(), thickness = 2.dp, color = Color(0xFF526E7B))
        ContactRow(R.drawable.ic_phone, "(587)927-1777")
        Divider(modifier = Modifier.fillMaxWidth(), thickness = 2.dp, color = Color(0xFF526E7B))
        ContactRow(R.drawable.ic_share, "@AndroidDev")
        Divider(modifier = Modifier.fillMaxWidth(), thickness = 2.dp, color = Color(0xFF526E7B))
        ContactRow(R.drawable.ic_email, "manjot@android.com")
    }
}

@Composable
fun ContactRow(iconId: Int, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp)
    ) {
        val iconImage = painterResource(id = iconId)
        Image(painter = iconImage, contentDescription = null, modifier = Modifier.padding(8.dp))
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        DisplayBusinessCard()
    }
}
