import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sthapit.androidanimation.R

@Composable
fun InfiniteScreen(navController: NavController) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val scale by infiniteTransition.animateFloat(
        initialValue = 0.6f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            // Tween animation for smooth scaling
            animation = tween(durationMillis = 30000, easing = LinearEasing),
            // Repeat the animation forever with reverse at the end
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painterResource(id = R.drawable.butterfly),
            contentDescription = "Example Image",
            modifier = Modifier.graphicsLayer(
                scaleX = scale,
                scaleY = scale
            ),
        )
    }

}

@Preview(showBackground = true)
@Composable
fun InfiniteScreenPreview() {
    // Mocking NavController for preview
    val navController = rememberNavController()

    // Previewing the ScaleScreen with the mocked NavController
    InfiniteScreen(navController = navController)
}