package ui.classmap

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable

@Composable
fun ClassMap() {

}

@Composable
fun ClassMapBottomBar(onDrawerClick: () -> Unit) {
    TopAppBar(
        title = { Text("LevelUp", style = MaterialTheme.typography.h6) },
        navigationIcon = {
            IconButton({ onDrawerClick() }) {
                Icon(Icons.Default.Menu, "Menu")
            }
        }, actions = {
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
        })
}