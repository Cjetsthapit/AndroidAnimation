import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavController
import com.sthapit.androidanimation.R


@Composable
fun EnterExitScreen(navController: NavController) {

    var visible by remember { mutableStateOf(true) }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { visible = !visible }) {
            Text(if (visible) "Hide Image" else "Show Image")
        }
        AnimatedVisibility(
            visible = visible,
            enter = slideIn(initialOffset = { fullSize ->
                // Starting from the top-left corner off-screen
                IntOffset(-fullSize.width / 4, -fullSize.height / 4)
            }) + fadeIn(animationSpec = tween(durationMillis = 1000)),
            exit = fadeOut(animationSpec = tween(durationMillis = 1000)),
            modifier = Modifier.fillMaxSize()
        ) {
            // Replace "path/to/your/image.png" with the actual path

            Image(
                painterResource(id = R.drawable.butterfly),
                contentDescription = "Exit Animation Image",
//                modifier = Modifier.fillMaxSize(),
//                contentScale = ContentScale.Crop
            )
        }


    }

}