package ui.main

import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.desktop.Window
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ui.classmap.ClassMap
import ui.classmap.ClassMapBottomBar

@ExperimentalMaterialApi
fun main() = Window(size = IntSize(1280, 800)) {
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    DesktopMaterialTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                ClassMapBottomBar { coroutineScope.launch { scaffoldState.drawerState.open() } }
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
                    ) {
                        DrawerTab { coroutineScope.launch { scaffoldState.drawerState.close() } }
                    }
                }
            },
            drawerBackgroundColor = Color.Transparent,
            drawerElevation = 0.dp,
            drawerGesturesEnabled = false,
            scaffoldState = scaffoldState
        ) {
            ClassMap()
        }
    }
}