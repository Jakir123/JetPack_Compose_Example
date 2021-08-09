package jakir.cse24.jetpackcomposeexample.ui.view.cleaning_app.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import jakir.cse24.jetpackcomposeexample.R
import jakir.cse24.jetpackcomposeexample.ui.theme.orangish
import jakir.cse24.jetpackcomposeexample.ui.theme.purplish

@Composable
@Preview
fun LoginPage() {
   Box {
      BgCard()
      MainCard()
   }
}

@Composable
fun BgCard() {
   val signupText = buildAnnotatedString {
      append("Don't have an account? ")
      withStyle(SpanStyle(color = orangish)) {
         append("Sign up here!")
      }
   }
   Surface(color = purplish, modifier = Modifier.fillMaxSize()) {
      Column(verticalArrangement = Arrangement.Bottom,
         horizontalAlignment = Alignment.CenterHorizontally
      ) {
         Row {
//            Image(R.drawable.ic_fb)
            Image(painter = painterResource(id = R.drawable.ic_fb),"")
            HSpacer( 4.dp)
            Image(painter = painterResource(id = R.drawable.ic_google),"")
            HSpacer( 4.dp)
            Image(painter = painterResource(id = R.drawable.ic_twitter),"")

         }
         Text(text = signupText, color = Color.White,modifier = Modifier.padding(bottom = 8.dp))
      }
   }
}

@Composable
fun MainCard() {
   val emailState = remember { mutableStateOf(TextFieldValue("")) }
   val passState = remember { mutableStateOf(TextFieldValue("")) }
   Surface(color = Color.White, modifier = Modifier
      .fillMaxHeight()
      .padding(bottom = 100.dp)
      .fillMaxWidth(),
      shape = RoundedCornerShape(60.dp).copy(topStart = ZeroCornerSize,  topEnd= ZeroCornerSize)) {
      Column(modifier = Modifier
         .padding(16.dp)
         .fillMaxSize(),
         horizontalAlignment = Alignment.CenterHorizontally,
      ) {

         val modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)

         TopImage()
         VSpacer(8.dp)
         Column(modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            EmailInputField(emailState,modifier)
            VSpacer(4.dp)
            PasswordInputField(passState, modifier)
            VSpacer(8.dp)
            ForgetPassword(modifier)
            VSpacer(12.dp)
            LoginButton(modifier = modifier)
         }
      }
   }
}

@Composable
fun TopImage() {
   Image(painter = painterResource(id = R.drawable.ic_vaccum), contentDescription = "")
}


@Composable
fun EmailInputField(emailState: MutableState<TextFieldValue>,modifier: Modifier) {
   OutlinedTextField(value = emailState.value, onValueChange = {
      emailState.value = it
   },leadingIcon = {Icon(Icons.Filled.Email,"") },
      label = { Text(text = "Email Address")},
      modifier = modifier)
}


@Composable
fun PasswordInputField(passState: MutableState<TextFieldValue>,modifier: Modifier) {
   OutlinedTextField(value = passState.value, onValueChange = {
      passState.value = it
   },
      label = { Text(text = "Password")},
      leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "")},
      keyboardOptions = KeyboardOptions(
         keyboardType = KeyboardType.Number
      ),
      modifier = modifier)

}

@Composable
fun VSpacer(padding: Dp) {
   Spacer(modifier = Modifier.padding(vertical = padding))
}


@Composable
fun HSpacer(padding: Dp) {
   Spacer(modifier = Modifier.padding(horizontal = padding))
}

@Composable
fun ForgetPassword(modifier: Modifier) {
   CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
      Text(text = "Forgot password?", textAlign = TextAlign.End, modifier = modifier)
   }
}

@Composable
fun LoginButton(modifier:Modifier) {
   Button(onClick = {},
      colors = ButtonDefaults.buttonColors(backgroundColor = orangish,
      contentColor = Color.White),
      modifier = modifier,
      contentPadding = PaddingValues(8.dp)) {
      LoginText()
   }
}

@Composable
fun LoginText() {
   Text(text = "Log In",fontWeight = FontWeight.ExtraBold)
}