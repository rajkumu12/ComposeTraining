package com.example.jetpackcompose

import android.content.Intent
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.activity.FieldSActivity
import com.example.jetpackcompose.activity.RecyclerViewInCompose
import kotlinx.coroutines.delay

class MainActivity :ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {

                Column(horizontalAlignment = Alignment.CenterHorizontally){
                    Button(onClick = { startActivity(Intent(this@MainActivity,RecyclerViewInCompose::class.java))}) {
                        Text("Submit Request")
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(onClick = { startActivity(Intent(this@MainActivity,FieldSActivity ::class.java))}) {
                        Text("Submit Request")
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(onClick = { Toast.makeText(this@MainActivity, "click 3", Toast.LENGTH_SHORT).show()}) {
                        Text("Submit Request")
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(onClick = {Toast.makeText(this@MainActivity, "click 4", Toast.LENGTH_SHORT).show() }) {
                        Text("Submit Request")
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(onClick = { Toast.makeText(this@MainActivity, "click 5", Toast.LENGTH_SHORT).show()}) {
                        Text("Submit Request")
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                }
            }

        }
    }
}
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }

        // Main Screen
        composable("main_screen") {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Main Screen", color = Color.Black, fontSize = 24.sp)
            }
        }
    }
}
@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    // Animation
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }))
        // Customize the delay time
        delay(3000L)
        navController.navigate("main_screen")
    }

    // Image
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {
        // Change the logo
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value))
    }
}