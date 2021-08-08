package jakir.cse24.jetpackcomposeexample.ui.view

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import jakir.cse24.jetpackcomposeexample.model.JetpackExample
import jakir.cse24.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme
import jakir.cse24.jetpackcomposeexample.ui.view.TitleText
import jakir.cse24.jetpackcomposeexample.ui.view.items.ExampleItemCard
import jakir.cse24.jetpackcomposeexample.viewModel.ExampleViewModel

class MainActivity : ComponentActivity() {
    private val viewModel : ExampleViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeExampleTheme {
               ExampleApp(viewModel = viewModel,contx = this)
            }
        }
    }
}

@Composable
fun ExampleApp(viewModel: ExampleViewModel,contx: Context) {
    val examples = viewModel.examplesList.value
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = "Jetpack Compose Example") })
            },
            content = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    TitleText(text = "List of Jetpack Practice Example")
                    ExampleList(examples = examples!!,contx)

                }
            }
        )
    }
}

@Composable
fun ExampleList(examples: List<JetpackExample>,contx: Context){
    LazyColumn(modifier = Modifier.fillMaxWidth()){
        itemsIndexed(items = examples){ _, item ->
            ExampleItemCard(exampleItem = item, onclick = {
                Toast.makeText(contx, "", Toast.LENGTH_SHORT).show()
            }) 
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
}