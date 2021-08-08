package jakir.cse24.jetpackcomposeexample.ui.view.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jakir.cse24.jetpackcomposeexample.model.JetpackExample

@Composable
fun ExampleItemCard(
    exampleItem: JetpackExample,
    onclick: ()->Unit
){
    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .clickable(onClick = onclick),
        shape = RoundedCornerShape(8.dp),
    elevation = 4.dp) {
        Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Text(text = exampleItem.name,modifier = Modifier.padding(8.dp))
        }
    }
}