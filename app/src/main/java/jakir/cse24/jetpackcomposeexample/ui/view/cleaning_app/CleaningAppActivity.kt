package jakir.cse24.jetpackcomposeexample.ui.view.cleaning_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import jakir.cse24.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme
import jakir.cse24.jetpackcomposeexample.ui.view.cleaning_app.composables.LoginPage

class CleaningAppActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LoginPage()
                }
            }
        }
    }
}
