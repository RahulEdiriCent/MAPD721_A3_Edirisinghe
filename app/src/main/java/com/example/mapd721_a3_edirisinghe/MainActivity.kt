package com.example.mapd721_a3_edirisinghe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.graphics.shapes.RoundedPolygon
import androidx.graphics.shapes.toPath
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mapd721_a3_edirisinghe.ui.theme.MAPD721_A3_EdirisingheTheme

//References:
//https://stackoverflow.com/questions/70142043/how-to-navigate-from-a-screen-to-another-in-jetpack-compose-using-navcontroller
//https://stackoverflow.com/questions/60247480/color-from-hex-string-in-jetpack-compose
//https://developer.android.com/reference/kotlin/androidx/compose/animation/core/InfiniteTransition
//https://developer.android.com/jetpack/compose/graphics/draw/shapes
//https://developer.android.com/jetpack/compose/animation/value-based#animate-as-state

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
        Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
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
                    text = "= Transition Animation =",
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
                    text = "= Scale Animation =",
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
                    text = "= Infinite Animation =",
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
                    text = "= Enter-Exit Animation =",
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun TransitionAnimationDisplay(navigationController: NavController, purpleColor: Color) {

    Column(modifier = Modifier.fillMaxSize()){
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
}

@Composable
fun ScaleAnimationDisplay(navigationController: NavController, purpleColor: Color) {
    var enabled by remember { mutableStateOf(true) }

    val alpha: Float by animateFloatAsState(
        if (enabled) 1f else 0.5f,
        animationSpec = tween(durationMillis = 1200, easing = LinearEasing),
        label = "3")

    Column(modifier = Modifier.fillMaxSize()) {
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
        Spacer(modifier= Modifier.height(10.dp))
        Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Button(
                modifier = Modifier
                    .height(60.dp / alpha)
                    .width(220.dp / alpha)
                    .padding(
                        start = 5.dp, end = 5.dp
                    ),
                onClick = {
                    enabled = !enabled
                },
                colors = ButtonDefaults.buttonColors(containerColor = purpleColor),
                border = ButtonDefaults.outlinedButtonBorder
            ) {

                Text(
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                    text = " Scale Animation",
                    color = Color.White
                )
            }
            Spacer(modifier= Modifier.height(30.dp))
            Box(
                Modifier
                    .height(70.dp * alpha)
                    .width(70.dp * alpha)
                    .graphicsLayer(alpha = alpha)
                    .background(Color.Red)
            )
        }
    }
}

@Composable
fun InfiniteAnimationDisplay(navigationController: NavController, purpleColor: Color) {
    val infiniteTransition = rememberInfiniteTransition(label = "1")

    val colorShift by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Green,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "2"
    )
    Column(modifier = Modifier.fillMaxSize()) {
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
        Spacer(modifier = Modifier.height(50.dp))
        Box(
            modifier = Modifier
                .drawWithCache {
                    val roundedPolygon = RoundedPolygon(
                        numVertices = 6,
                        radius = size.minDimension / 2,
                        centerX = size.width / 2,
                        centerY = size.height / 2
                    )
                    val roundedPolygonPath = roundedPolygon
                        .toPath()
                        .asComposePath()
                    onDrawBehind {
                        drawPath(roundedPolygonPath, color = colorShift)
                    }
                }
                .fillMaxSize()
        )
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