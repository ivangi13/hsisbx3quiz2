package com.example.hsisbx3quiz2

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hsisbx3quiz2.ui.theme.Hsisbx3quiz2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Hsisbx3quiz2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Hsisbx3quiz2()
                }
            }
        }
    }
}

@Composable
fun Hsisbx3quiz2(modifier: Modifier = Modifier) {

    var nipInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("")}


    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val image = painterResource(R.drawable.ic_logo)
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .size(200.dp)
                .padding(top = 40.dp)
        )
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = stringResource(R.string.no_induk),
                textAlign = TextAlign.Start,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(10.dp)
            )
            InputNip(
                value = nipInput,
                onValueChange = { nipInput = it },
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
            )
            Text(
                text = stringResource(R.string.pass_word),
                textAlign = TextAlign.Start,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(10.dp)
            )
            InputPassword(
                value = passwordInput,
                onValueChange = { passwordInput = it },
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
            )
        }
        val login = LocalContext.current
        Button(
            onClick = {
                if (nipInput != "" && passwordInput != "") toastLogin(login, R.string.go_beranda)
                else if (passwordInput != "") toastLogin(login, R.string.tanpa_nip)
                else if (nipInput != "") toastLogin(login, R.string.tanpa_password)
                else toastLogin(login, R.string.tanpa_nip_password)
            },
            shape = RoundedCornerShape(10.dp),
            modifier = modifier
                .fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.login_access))
        }
        Text(
            text = stringResource(R.string.not_access),
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            modifier = modifier.padding(10.dp)
        )
        val ikhwan = LocalContext.current
        Text(
            text = stringResource(R.string.cs_ikhwan),
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            fontStyle = FontStyle.Italic,
            modifier = modifier
                .clickable {
                    Toast
                        .makeText(ikhwan, R.string.hub_cs_ikhwan, Toast.LENGTH_SHORT)
                        .show()
                }
                .padding(10.dp)
        )
        val akhwat = LocalContext.current
        Text(
            text = stringResource(R.string.cs_akhwat),
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            fontStyle = FontStyle.Italic,
            modifier = modifier
                .clickable {
                    Toast
                        .makeText(akhwat, R.string.hub_cs_akhwat, Toast.LENGTH_SHORT)
                        .show()
                }
                .padding(10.dp)
        )
        val faq = LocalContext.current
        OutlinedButton(
            onClick = {
                Toast.makeText(faq, R.string.go_faq, Toast.LENGTH_SHORT).show()
            },
            shape = RoundedCornerShape(10.dp),
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 80.dp)
        ) {
            Text(text = stringResource(R.string.lihat_faq))
        }
    }
}

fun toastLogin(login: Context, message: Int) {
    Toast.makeText(login, message, Toast.LENGTH_SHORT).show()
}


@Composable
fun InputNip(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        label = { Text(stringResource(R.string.isi_no_induk))},
        modifier = modifier
    )
}

@Composable
fun InputPassword(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(R.string.isi_pass_word))},
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun Hsisbx3quiz2Preview() {
    Hsisbx3quiz2Theme {
        Hsisbx3quiz2()
    }
}

/**
 * TODO 1: Buat non-composable function
 * - dalam halam ini kita memakai toast karena dipakai berulang2 di banyak tempat
 * - tidak diawali dengan anotasi @Composable
 * - contoh:
 *          fun toastLogin(context: Context, message: Int) {
 *              Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
 *          }
 * 
 *
 * - contoh memanggil function ini
 *              val context = LocalContext.current
 *              Button(onClick = {
 *                  toastLogin(context, R.string.cs_akhwat)
 *              }) {
 *                  Text("Tombol")
 *              }
 */
