package com.example.preciousecommerce.ui.theme.screens.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.preciousecommerce.data.AuthViewModel
import com.example.preciousecommerce.navigation.LOGIN_URL
import com.example.preciousecommerce.ui.theme.PreciousEcommerceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Signup Here",
            color = Color.Red,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )
        Spacer(modifier = Modifier.height(20.dp))

        var name by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        OutlinedTextField(
            value = name,
            onValueChange = {name= it},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            label = { Text(text = "Enter name")}
        )
        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            label = { Text(text = "Enter email")}
        )
        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {password= it},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            label = { Text(text = "Enter password")}
        )
        Spacer(modifier = Modifier.height(30.dp))

        val context = LocalContext.current
        val authViewModel = AuthViewModel(navController,context)
        Button(onClick = {
            authViewModel.signup(name,email,password)
        }) {
            Text(text = "Register ")
        }
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
            navController.navigate(LOGIN_URL)
        }) {
            Text(text = "Login Instead")
        }








    }

    }


@Composable
@Preview(showBackground = true )
fun SignupScreenPreview(){
    PreciousEcommerceTheme {
        SignupScreen(navController = rememberNavController())
    }
}
