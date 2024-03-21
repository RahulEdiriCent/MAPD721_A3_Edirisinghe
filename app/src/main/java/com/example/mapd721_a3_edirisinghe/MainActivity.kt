package com.example.mapd721_a3_edirisinghe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mapd721_a3_edirisinghe.ui.theme.MAPD721_A3_EdirisingheTheme

//References:
//https://stackoverflow.com/questions/70142043/how-to-navigate-from-a-screen-to-another-in-jetpack-compose-using-navcontroller
//

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MAPD721_A3_EdirisingheTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //AnimationSelection(navigationController = )
                    StartApp()
                }
            }
        }
    }
}

@Composable
fun StartApp(){
    val navigationController = rememberNavController()

    NavHost(navigationController, startDestination = "animationSelection") {
        composable("animationSelection") { AnimationSelection(navigationController = navigationController) }
        composable("transitionAnimation") { TransitionAnimationDisplay(navigationController = navigationController) }
        composable("scaleAnimation") { ScaleAnimationDisplay(navigationController = navigationController) }
        composable("infiniteAnimation") { InfiniteAnimationDisplay(navigationController = navigationController) }
        composable("enterExitAnimation") { EnterExitAnimationDisplay(navigationController = navigationController) }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MAPD721_A3_EdirisingheTheme {
        //Greeting("Android")
        StartApp()
    }
}

@Composable
fun AnimationSelection(navigationController: NavController){
    Column() {
        Button(
            modifier = Modifier
                //.fillMaxSize()
                .height(60.dp)
                .padding(
                    start = 20.dp, end = 20.dp
                ),
            onClick = {
                navigationController.navigate("transitionAnimation")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
            border = ButtonDefaults.outlinedButtonBorder

        ) {
            Text(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                text = "Transition Animation",
                color = Color.Black
            )
        }
        Button(
            modifier = Modifier
                //.fillMaxSize()
                .height(60.dp)
                .padding(
                    start = 20.dp, end = 20.dp
                ),
            onClick = {
                navigationController.navigate("scaleAnimation")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
            border = ButtonDefaults.outlinedButtonBorder

        ) {
            Text(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                text = "Scale Animation", color = Color.Black
            )
        }
        Button(
            modifier = Modifier
                //.fillMaxSize()
                .height(60.dp)
                .padding(
                    start = 20.dp, end = 20.dp
                ),
            onClick = {
                navigationController.navigate("infiniteAnimation")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
            border = ButtonDefaults.outlinedButtonBorder

        ) {
            Text(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                text = "Infinite Animation", color = Color.Black
            )
        }
        Button(
            modifier = Modifier
                //.fillMaxSize()
                .height(60.dp)
                .padding(
                    start = 20.dp, end = 20.dp
                ),
            onClick = {
                navigationController.navigate("enterExitAnimation")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
            border = ButtonDefaults.outlinedButtonBorder

        ) {
            Text(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                text = "Enter-Exit Animation",
                color = Color.Black
            )
        }
    }
}

@Composable
fun TransitionAnimationDisplay(navigationController: NavController) {
    Button(
        modifier = Modifier
            //.fillMaxSize()
            .height(60.dp)
            .padding(
                start = 20.dp, end = 20.dp
            ),
        onClick = {
            navigationController.navigate("animationSelection")
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
        border = ButtonDefaults.outlinedButtonBorder

    ) {
        Text(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp),
            text = "<- Transition Animation",
            color = Color.Black
        )
    }
}

@Composable
fun ScaleAnimationDisplay(navigationController: NavController) {
    Button(
        modifier = Modifier
            //.fillMaxSize()
            .height(60.dp)
            .padding(
                start = 20.dp, end = 20.dp
            ),
        onClick = {
            navigationController.navigate("animationSelection")
                  },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
        border = ButtonDefaults.outlinedButtonBorder

    ) {
        Text(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp),
            text = "<- Scale Animation",
            color = Color.Black
        )
    }
}

@Composable
fun InfiniteAnimationDisplay(navigationController: NavController) {
    Button(
        modifier = Modifier
            //.fillMaxSize()
            .height(60.dp)
            .padding(
                start = 20.dp, end = 20.dp
            ),
        onClick = {
            navigationController.navigate("animationSelection")
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
        border = ButtonDefaults.outlinedButtonBorder

    ) {
        Text(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp),
            text = "<- Infinite Animation",
            color = Color.Black
        )
    }
}

@Composable
fun EnterExitAnimationDisplay(navigationController: NavController) {
    Button(
        modifier = Modifier
            //.fillMaxSize()
            .height(60.dp)
            .padding(
                start = 20.dp, end = 20.dp
            ),
        onClick = {
            navigationController.navigate("animationSelection")
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
        border = ButtonDefaults.outlinedButtonBorder

    ) {
        Text(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp),
            text = "<- Enter-Exit Animation",
            color = Color.Black
        )
    }
}