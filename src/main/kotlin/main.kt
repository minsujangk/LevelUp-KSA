import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.desktop.Window
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

fun main() = Window {
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    DesktopMaterialTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                TopAppBar(
                    title = { Text("LevelUp", style = MaterialTheme.typography.h6) },
                    navigationIcon = {
                        IconButton({ coroutineScope.launch { scaffoldState.drawerState.open() } }) {
                            Icon(Icons.Default.Menu, "Menu")
                        }
                    })
            },
            drawerContent = {
                Box(
                    modifier = Modifier.fillMaxSize()
                        .pointerInput(Unit) {
                            detectTapGestures { coroutineScope.launch { scaffoldState.drawerState.close() } }
                        }) {
                    Surface(
                        modifier = Modifier.width(320.dp).fillMaxHeight()
                            .pointerInput(Unit) {
                                detectTapGestures {
                                    // disable tab close here
                                }
                            },
                        elevation = 4.dp
                    ) { Text("dsfasd") }
                }
            },
            drawerBackgroundColor = Color.Transparent,
            drawerElevation = 0.dp,
            drawerGesturesEnabled = false,
            scaffoldState = scaffoldState
        ) {
            Box {}
        }
    }
}