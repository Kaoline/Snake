// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun MainScreen(mainViewModel: MainViewModel) {
    MaterialTheme {
        BoardView(mainViewModel.boardViewState)
    }
}

fun main() = application {
    val game = GameMaster(11)
    val mainViewModel = MainViewModel(game)

    Window(onCloseRequest = ::exitApplication,
    onKeyEvent = ::onKeyEvent
    ) {
        MainScreen(mainViewModel)
    }
}

fun onKeyEvent(keyEvent: KeyEvent): Boolean {
    return false
}