package com.ocean.jetpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ocean.jetpackcomposebasic.ui.theme.JetpackComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeBasicTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyAPP(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val expand = remember {
        mutableStateOf(false)
    }
        val extraPadding = if (expand.value) 45.dp else 0.dp

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 2.dp, horizontal = 4.dp)
    ) {
        Row(modifier = modifier
            .fillMaxWidth()
            .padding(14.dp)) {
            Column(
                modifier = modifier.weight(1f).padding(bottom = extraPadding)
            ) {
                Text(text = "Hello")
                Text(text = "$name")
            }
            ElevatedButton(
                onClick = { expand.value = !expand.value },//){
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onSecondary)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(id = if (expand.value) R.drawable.icon_expand_less else R.drawable.icon_expand_more),
                        contentDescription = "show more icon",
                        modifier = modifier.size(20.dp),
                        tint = MaterialTheme.colorScheme.primary
                        )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = if (expand.value)"Show Less" else "Show More",
                        color = MaterialTheme.colorScheme.primary
                        )
                }
            }
        }
    }
}

@Composable
fun MyAPP(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("name","NA","compose")
) {
    Column(modifier.padding(vertical = 4.dp)) {
        for (name in names){
            Greeting(name = name)
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    JetpackComposeBasicTheme {
        MyAPP()
    }
}