package com.example.learntogetherapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogetherapp.ui.theme.LearnTogetherAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTogetherAppTheme {
                TaskView()
            }
        }
    }
}


@Composable
fun LearnImage() {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(painter = image,
        contentDescription = "test"
    )
}

@Composable
fun ComposeTutorial() {
    Column {
        LearnImage()
        Text(
            text = "Jetpack Compose tutorial",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accel",
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }

}

@Composable
fun TaskView() {
    val image = painterResource(R.drawable.ic_task_completed)
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = image, contentDescription = "Task view")
        Text(
            text = "All tasks completed",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Nice work!"
        )
    }

}

@Composable
private fun ComposableInfoCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}
@Composable
private fun ComposeQuadrants() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(title = "Text composable", description = "Displays text and follows the recommended Material Design guidelines.", backgroundColor = Color(0xFFEADDFF), modifier = Modifier.weight(1f))
            ComposableInfoCard(title = "Image composable", description = "Creates a composable that lays out and draws a given Painter class object.", backgroundColor = Color(0xFFD0BCFF), modifier = Modifier.weight(1f))
        }
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(title = "Row composable", description = "A layout composable that places its children in a horizontal sequence.", backgroundColor = Color(0xFFB69DF8), modifier = Modifier.weight(1f))
            ComposableInfoCard(title = "Column composable", description = "A layout composable that places its children in a vertical sequence.", backgroundColor = Color(0xFFF6EDFF), modifier = Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskCompletePreview() {
    LearnTogetherAppTheme {
        ComposeQuadrants()
//        ComposeTutorial()
//        TaskView()
    }
}