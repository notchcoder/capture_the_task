package com.example.capture_the_task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capture_the_task.ui.theme.CapturethetaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CapturethetaskTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CapturethetaskScreen()
                }
            }
        }
    }
}

@Composable
fun CapturethetaskScreen() {
    Column(
        modifier = Modifier.padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(16.dp))
        EditNumberField()
        var checked by remember { mutableStateOf(false) }

        IconToggleButton(
            checked = checked,
            onCheckedChange = { checked = it },
        ) {
            Icon(
                imageVector = if (checked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = if (checked) "favorite on" else "favorite off",
            )
        }

        FloatingActionButton(onClick = { checked = !checked }) {
            Icon(
                imageVector = if (checked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = if (checked) "favorite on" else "favorite off",
            )
        }

        Switch(checked = checked, onCheckedChange = { checked = it })
    }
}

@Composable
fun EditNumberField() {
    var amountInput by remember { mutableStateOf("") }
    TextField(
        value = amountInput,
        onValueChange = { amountInput = it },
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CapturethetaskTheme {
        CapturethetaskScreen()
    }
}