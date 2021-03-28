package ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ui.classmap.ClassMap

val localDrawerTabState = staticCompositionLocalOf { mutableStateOf(DrawerTabState.Timeline) }

enum class DrawerTabState(val itemName: String) {
    Timeline("Timeline"),
    ClassMap("Class map"),
}

@ExperimentalMaterialApi
@Composable
fun DrawerTab(onSelect: () -> Unit) {
    Column {
        DrawerTabState.values().forEach {
            DrawerTabItem(localDrawerTabState.current, it, { Icon(Icons.Default.Home, "Home") }, onSelect)
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun DrawerTabItem(
    currentState: MutableState<DrawerTabState>,
    displayingState: DrawerTabState,
    icon: @Composable () -> Unit,
    onSelect: () -> Unit
) {
    ListItem(
        modifier = Modifier.selectableGroup()
            .selectable(currentState.value == displayingState) {
                currentState.value = displayingState
                onSelect()
            }.background(
                if (currentState.value == displayingState) Color(0, 0, 0, 0x20)
                else Color.Transparent
            ),
        icon = {
            icon()
        }) {
        Text(displayingState.itemName, style = MaterialTheme.typography.button)
    }
}

@Composable
fun DynamicBottomBar(onDrawerClick: () -> Unit) {
    TopAppBar(
        title = { Text("LevelUp", style = MaterialTheme.typography.h6) },
        navigationIcon = {
            IconButton({ onDrawerClick() }) {
                Icon(Icons.Default.Menu, "Menu")
            }
        }, actions = {
            when (localDrawerTabState.current.value) {
                DrawerTabState.Timeline -> {
                    TabRow(0) {
                        Tab(false, onClick = {}, text = { Text("1학기") })
                        Tab(false, onClick = {}, text = { Text("2학기") })
                        Tab(false, onClick = {}, text = { Text("3학기") })
                        Tab(false, onClick = {}, text = { Text("4학기") })
                        Tab(false, onClick = {}, text = { Text("5학기") })
                        Tab(false, onClick = {}, text = { Text("6학기") })
                    }
                }
                DrawerTabState.ClassMap -> {
                    TabRow(0) {
                        Tab(false, onClick = {}, text = { Text("수학") })
                        Tab(false, onClick = {}, text = { Text("정보과학") })
                        Tab(false, onClick = {}, text = { Text("물리") })
                        Tab(false, onClick = {}, text = { Text("지구과학") })
                        Tab(false, onClick = {}, text = { Text("화학") })
                        Tab(false, onClick = {}, text = { Text("생물") })
                        Tab(false, onClick = {}, text = { Text("국어") })
                        Tab(false, onClick = {}, text = { Text("사회") })
                        Tab(false, onClick = {}, text = { Text("외국어") })
                        Tab(false, onClick = {}, text = { Text("예체능") })
                        Tab(false, onClick = {}, text = { Text("융합") })
                    }
                }
            }
        })
}

@Composable
fun DynamicContent() {
    when (localDrawerTabState.current.value) {
        DrawerTabState.Timeline -> Box {}
        DrawerTabState.ClassMap -> ClassMap()
    }
}