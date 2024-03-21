import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sthapit.androidanimation.R

@Composable
fun TransitionScreen(navController: NavController) {
    var imageYPosition by remember { mutableStateOf(-1f) }

    // Animate the Y-position change
    val animatedYPosition = animateDpAsState(
        targetValue = if (imageYPosition == 1f) 0.dp else 500.dp,
        animationSpec = tween(durationMillis = 1000), label = "demo"
    )

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp)
    ) {
        Button(
            onClick = { imageYPosition *= -1f },
        ) {
            Text(if (imageYPosition == 1f) "Land Rocket" else "Launch Rocket")
        }

        Image(
            painter = painterResource(id = R.drawable.rocket),
            contentDescription = "Example Image",
            modifier = Modifier
                .offset(y = animatedYPosition.value)
        )
    }

}

