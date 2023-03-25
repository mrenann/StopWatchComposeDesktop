package ui
import classes.StopWatch
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen

object StopWatchScreen : Screen {

    val stopWatch = StopWatch()

    @Composable
    @Preview
    override fun Content() {
        var isActive by remember { mutableStateOf(false) }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().weight(1F).background(Color(190, 184, 219)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stopWatch.formattedTime,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.Black
                )
            }

            Spacer(Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    shape = CircleShape,
                    colors = buttonColors(Color(158, 144, 232)),
                    onClick = {
                        if (isActive.not()) stopWatch.start() else stopWatch.pause()
                        isActive = isActive.not()
                    }
                ) {
                    if (isActive.not()) Text("Iniciar") else Text("Pausar")
                }
                Spacer(Modifier.width(16.dp))
                Button(
                    shape = CircleShape,
                    colors = buttonColors(Color(158, 144, 232)),
                    onClick = {
                        isActive = false
                        stopWatch.reset()
                    }
                ) {
                    Text("Resetar")
                }
            }
            Spacer(Modifier.height(16.dp))
        }
    }
}
