package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xff0c1559)) // Set the background color to custom blue
                )
                DiceRollerWithImage()
            }
        }
    }
}

@Composable
fun DiceRollerWithImage() {
    var result by remember { mutableStateOf(1) }
    val imageResource = when(result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentWidth(Alignment.CenterHorizontally),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = imageResource), contentDescription = "null")
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                result = (1..6).random()
                      },
            modifier = Modifier.size(150.dp, 50.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff2563eb))
        )
        {
            Text(
                stringResource(R.string.Button_name),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        }

    }
}

@Preview
@Composable
fun DiceRollerApp() {
    DiceRollerWithImage()
}