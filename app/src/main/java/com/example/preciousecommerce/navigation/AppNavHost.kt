package com.example.preciousecommerce.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.preciousecommerce.ui.theme.screens.home.HomeScreen
import com.example.preciousecommerce.ui.theme.screens.login.LoginScreen
import com.example.preciousecommerce.ui.theme.screens.products.AddProductsScreen
import com.example.preciousecommerce.ui.theme.screens.products.ViewProductsScreen
import com.example.preciousecommerce.ui.theme.screens.signup.SignupScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination:String = LOGIN_URL
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier){
        composable(LOGIN_URL){
            LoginScreen(navHostController = navController)
        }
        composable(SIGNUP_URL){
            SignupScreen(navHostController = navController)
        }
        composable(HOME_URL){
            HomeScreen(navHostController = navController)
        }
        composable(ADD_PRODUCTS_URL){
            AddProductsScreen(navHostController = navController)
        }
        composable(VIEW_PRODUCTS_URL){
            ViewProductsScreen(navHostController = navController)
        }
    }
    
}