package com.example.mapd721_a3_edirisinghe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
//https://stackoverflow.com/questions/60247480/color-from-hex-string-in-jetpack-compose

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
    val purple = Color(0xFF5922dd)

    NavHost(navigationController, startDestination = "animationSelection") {
        composable("animationSelection") { AnimationSelection(navigationController = navigationController, purpleColor = purple) }
        composable("transitionAnimation") { TransitionAnimationDisplay(navigationController = navigationController, purpleColor = purple) }
        composable("scaleAnimation") { ScaleAnimationDisplay(navigationController = navigationController, purpleColor = purple) }
        composable("infiniteAnimation") { InfiniteAnimationDisplay(navigationController = navigationController, purpleColor = purple) }
        composable("enterExitAnimation") { EnterExitAnimationDisplay(navigationController = navigationController, purpleColor = purple) }
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
fun AnimationSelection(navigationController: NavController, purpleColor: Color){
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(140.dp))
        Button(
            modifier = Modifier
                .height(60.dp)
                .padding(
                    start = 20.dp, end = 20.dp
                ),
            onClick = {
                navigationController.navigate("transitionAnimation")
            },
            colors = ButtonDefaults.buttonColors(containerColor = purpleColor),
            border = ButtonDefaults.outlinedButtonBorder

        ) {
            Text(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                text = "Transition Animation",
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier
                .height(60.dp)
                .padding(
                    start = 20.dp, end = 20.dp
                ),
            onClick = {
                navigationController.navigate("scaleAnimation")
            },
            colors = ButtonDefaults.buttonColors(containerColor = purpleColor),
            border = ButtonDefaults.outlinedButtonBorder

        ) {
            Text(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                text = "Scale Animation",
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier
                .height(60.dp)
                .padding(
                    start = 20.dp, end = 20.dp
                ),
            onClick = {
                navigationController.navigate("infiniteAnimation")
            },
            colors = ButtonDefaults.buttonColors(containerColor = purpleColor),
            border = ButtonDefaults.outlinedButtonBorder

        ) {
            Text(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                text = "Infinite Animation",
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier
                .height(60.dp)
                .padding(
                    start = 20.dp, end = 20.dp
                ),
            onClick = {
                navigationController.navigate("enterExitAnimation")
            },
            colors = ButtonDefaults.buttonColors(containerColor = purpleColor),
            border = ButtonDefaults.outlinedButtonBorder

        ) {
            Text(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                text = "Enter-Exit Animation",
                color = Color.White
            )
        }
    }
}

@Composable
fun TransitionAnimationDisplay(navigationController: NavController, purpleColor: Color) {
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
        colors = ButtonDefaults.buttonColors(containerColor = purpleColor),
        border = ButtonDefaults.outlinedButtonBorder

    ) {
        Row {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                text = "Transition Animation",
                color = Color.White
            )
        }
    }
}

@Composable
fun ScaleAnimationDisplay(navigationController: NavController, purpleColor: Color) {
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
        colors = ButtonDefaults.buttonColors(containerColor = purpleColor),
        border = ButtonDefaults.outlinedButtonBorder

    ) {
        Row {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                text = "Scale Animation",
                color = Color.White
            )
        }
    }
}

@Composable
fun InfiniteAnimationDisplay(navigationController: NavController, purpleColor: Color) {
    Button(
        modifier = Modifier
            .height(60.dp)
            .padding(
                start = 20.dp, end = 20.dp
            ),
        onClick = {
            navigationController.navigate("animationSelection")
        },
        colors = ButtonDefaults.buttonColors(containerColor = purpleColor),
        border = ButtonDefaults.outlinedButtonBorder

    ) {
        Row {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                text = "Infinite Animation",
                color = Color.White
            )
        }
    }
}

@Composable
fun EnterExitAnimationDisplay(navigationController: NavController, purpleColor: Color) {
    Button(
        modifier = Modifier
            .height(60.dp)
            .padding(
                start = 20.dp, end = 20.dp
            ),
        onClick = {
            navigationController.navigate("animationSelection")
        },
        colors = ButtonDefaults.buttonColors(containerColor = purpleColor),
        border = ButtonDefaults.outlinedButtonBorder

    ) {
        Row {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                text = "EnterExit Animation",
                color = Color.White
            )
        }
    }
}