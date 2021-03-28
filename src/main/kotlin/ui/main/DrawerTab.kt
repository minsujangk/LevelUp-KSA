package ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


enum class DrawerTabState(val itemName: String) {
    ClassMap("Class map")
}

@ExperimentalMaterialApi
@Composable
fun DrawerTab(onSelect: () -> Unit) {
    val drawerTabState = remember { mutableStateOf(DrawerTabState.ClassMap) }
    Column {
        DrawerTabState.values().forEach {
            DrawerTabItem(drawerTabState, it, { Icon(Icons.Default.Home, "Home") }, onSelect)
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