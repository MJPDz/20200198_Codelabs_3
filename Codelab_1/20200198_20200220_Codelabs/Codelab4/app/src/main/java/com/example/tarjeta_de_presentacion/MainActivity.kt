package com.example.tarjeta_de_presentacion

import android.app.Person
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarjeta_de_presentacion.ui.theme.Tarjeta_de_presentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tarjeta_de_presentacionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
private fun Person(
    logo: Painter,
    fullName: String,
    position: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .padding(
                    top = 50.dp,
                    end = 16.dp,
                    bottom = 16.dp,
                    start = 16.dp
                )
        ) {
            Image(
                painter = logo,
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .background(Color(0xFF073042))
            )
        }
        Row(modifier = modifier) {
            Text(
                text = fullName,
                fontSize = 50.sp,
                fontWeight = FontWeight.Light
            )
        }
        Row(modifier = modifier) {
            Text(
                text = position,
                fontSize = 18.sp,
                color = Color(0xFF006A35),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun ContactInformation(
    phoneLogo: Painter,
    shareLogo: Painter,
    mailLogo: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier
                .padding(bottom = 15.dp)
        ) {
            Column {
                Image(
                    painter = phoneLogo,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
            }
            Column {
                Text(
                    text = stringResource(R.string.number_phone)
                )
            }
        }
        Row(
            modifier = modifier
                .padding(bottom = 15.dp)
        ) {
            Column {
                Image(
                    painter = shareLogo,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
            }
            Column {
                Text(
                    text = stringResource(R.string.contact_person)
                )
            }
        }
        Row(
            modifier = modifier
                .padding(bottom = 15.dp)
        ) {
            Column {
                Image(
                    painter = mailLogo,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
            }
            Column {
                Text(
                    text = stringResource(R.string.mail_person)
                )
            }
        }
    }
}

@Composable
private fun BusinessCard() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = 32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Person(
                logo = painterResource(R.drawable.android_logo),
                fullName = stringResource(R.string.businessCard_fullName),
                position = stringResource(R.string.businessCard_position)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ContactInformation(
                phoneLogo = painterResource(R.drawable.phone_logo),
                shareLogo = painterResource(R.drawable.share_logo),
                mailLogo = painterResource(R.drawable.mail_logo)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Tarjeta_de_presentacionTheme {
        BusinessCard()
    }
}