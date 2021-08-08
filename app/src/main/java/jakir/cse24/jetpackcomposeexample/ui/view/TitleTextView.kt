package jakir.cse24.jetpackcomposeexample.ui.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TitleText(text: String){
    Text(text = text,
        modifier = Modifier.padding(16.dp),
        style = MaterialTheme.typography.h6,
        fontWeight = FontWeight.Bold)
}