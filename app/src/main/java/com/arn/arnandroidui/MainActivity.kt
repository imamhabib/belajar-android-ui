package com.arn.arnandroidui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arn.arnandroidui.ui.theme.ArnAndroidUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContent { LoginScreen() }
        setContent {
            ArnAndroidUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                   // Home()
                }
            }
        }
    }
}

@Composable
fun Home(modifier: Modifier = Modifier){

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .fillMaxHeight()
    ) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(5.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hsi_sakinah),
                    contentDescription = "Logo top",
                    modifier = modifier
                        .padding(5.dp)
                        .size(100.dp)
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = modifier
                    .background(Color.LightGray, RoundedCornerShape(15.dp))
                    .size(400.dp)

            ) {
                Text(text = "Isi form CV dulu, yuk!",
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(5.dp)
                )
                Text(text = "Untuk bisa memulai pencarian pasangan, Antum harus mengisi form CV antum " +
                        "terlebih dahulu", textAlign = TextAlign.Center
                )

                Image(
                    painter = painterResource(id = R.drawable.book_search),
                    contentDescription = "Logo top",
                    modifier = modifier
                        .padding(4.dp)
                        .border(2.dp, Color.Blue, RoundedCornerShape(5.dp))
                        .size(200.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = modifier
                        .padding(5.dp)
                ){
                    Text(text = "Lewati",fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,modifier = modifier
                        .border(1.dp, Color.Blue, RoundedCornerShape(15.dp))
                        .height(40.dp)
                        .width(150.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.size(30.dp))
                    Text(text = "Isi CV",fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,color=Color.White,modifier = modifier
                        .background(Color.Blue, RoundedCornerShape(15.dp))
                        .border(1.dp, Color.Blue, RoundedCornerShape(15.dp))
                        .height(40.dp)
                        .width(150.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically)
                    )
                }
            }
        }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .weight(1f, false)
                ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Image(
                    painter = painterResource(id = R.drawable.baseline_home_24),
                    contentDescription = "Tombol Home",
                    modifier = modifier
                        .size(15.dp)
                )
                Text(text="Home")
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Image(
                    painter = painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = "Tombol Pencarian",
                    modifier = modifier
                        .size(15.dp)
                )
                Text(text="Pencarian")
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Image(
                    painter = painterResource(id = R.drawable.baseline_emoji_people_24),
                    contentDescription = "Tombol Profil",
                    modifier = modifier
                        .size(15.dp)
                )
                Text(text="Profil")
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomePreview(){
    ArnAndroidUITheme {
        Home()
    }
}
