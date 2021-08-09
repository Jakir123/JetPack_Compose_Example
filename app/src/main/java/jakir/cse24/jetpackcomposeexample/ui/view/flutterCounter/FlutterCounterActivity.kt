package jakir.cse24.jetpackcomposeexample.ui.view.flutterCounter

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import jakir.cse24.jetpackcomposeexample.model.JetpackExample
import jakir.cse24.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme
import jakir.cse24.jetpackcomposeexample.ui.view.items.ExampleItemCard
import jakir.cse24.jetpackcomposeexample.viewModel.ExampleViewModel
import jakir.cse24.jetpackcomposeexample.viewModel.FlutterCounterViewModel

class FlutterCounterActivity : ComponentActivity() {
    private val viewModel : FlutterCounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeExampleTheme {
               CounterApp(contx= this)
            }
        }
    }
}

@Composable
fun CounterApp(contx: Context) {
    val counter = remember {
        mutableStateOf(0)
    }
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = {CounterTopBar(contx)},
            floatingActionButton = { CounterFab(counter)},
            content = { CounterContent(counter)}
        )
    }
}

@Composable
fun CounterTopBar(contx: Context){
    TopAppBar(
        title = { Text(text = "Flutter Counter Example") },
        navigationIcon = {
            IconButton(onClick = { onBackPressed(contx)}) {
                Icon(Icons.Default.ArrowBack,"Back")
            }
        },
        contentColor = Color.White
    )
}

@Composable
fun CounterFab(counter: MutableState<Int>){
    FloatingActionButton(onClick = { counter.value++ }) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
    }
}

@Composable
fun CounterContent(counter: MutableState<Int>){

   Column(
       Modifier
           .padding(16.dp)
           .fillMaxSize(),
       horizontalAlignment = Alignment.CenterHorizontally,
       verticalArrangement = Arrangement.Center) {
       DescriptionText(text = "You have pushed the button this many times")
       CounterText(text = "${counter.value}")
   }
}

@Composable
fun DescriptionText(text:String){
    Text(text = text,
        modifier = Modifier.padding(16.dp),
        style = MaterialTheme.typography.body1,
        fontWeight = FontWeight.Medium)
}
@Composable
fun CounterText(text:String){
    Text(text = text,
        modifier = Modifier.padding(16.dp),
        style = MaterialTheme.typography.h4,
        fontWeight = FontWeight.Bold)
}

fun onBackPressed(contx:Context){
//    contx.finish
}
