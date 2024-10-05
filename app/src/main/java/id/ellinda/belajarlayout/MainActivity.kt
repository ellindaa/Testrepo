package id.ellinda.belajarlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.ellinda.belajarlayout.ui.theme.BelajarLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BelajarLayoutTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { paddingValues -> // Menambahkan paddingValues
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues), // Menggunakan paddingValues dari Scaffold
                        color = Color(0xFF073042)
                    ) {
                        NameCard()
                    }
                }
            }
        }
    }
}

@Composable
fun NameCard() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        val image = painterResource(R.drawable.android_logo)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(0.3f)
        )
        Text(text = stringResource(R.string.nama), fontSize = 50.sp, color = Color.White)
        Text(text = stringResource(R.string.judul), fontSize = 11.sp, color = Color.Green)
        ContactRow(
            icon = Icons.Rounded.Phone,
            text = stringResource(R.string.no_hp)
        )
        ContactRow(
            icon = Icons.Rounded.Share,
            text = stringResource(R.string.instagram)
        )
        ContactRow(
            icon = Icons.Rounded.Email,
            text = stringResource(R.string.email)
        )
    }
}

@Composable
fun ContactRow(icon: ImageVector, text: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.weight(4f)
        )
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Green,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BelajarLayoutTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF073042)
        ) {
            NameCard()
        }
    }
}
