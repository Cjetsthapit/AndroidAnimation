import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ScaleScreen(navController: NavController) {

    var clicked by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(targetValue = if (clicked) 2f else 1f)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { clicked = !clicked },
            modifier = Modifier.graphicsLayer(scaleX = scale, scaleY = scale)
        ) {
            Text("Click me to animate")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ScaleScreenPreview() {
    // Mocking NavController for preview
    val navController = rememberNavController()

    // Previewing the ScaleScreen with the mocked NavController
    ScaleScreen(navController = navController)
}