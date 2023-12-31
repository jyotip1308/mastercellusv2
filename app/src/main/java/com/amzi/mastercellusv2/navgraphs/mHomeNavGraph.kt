package com.amzi.mastercellusv2.navgraphs

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.amzi.mastercellusv2.AllScreens.Home.DetailsScreen
import com.amzi.mastercellusv2.AllScreens.Home.HomeScreen
import com.amzi.mastercellusv2.AllScreens.starterScreens.MainStarterScreen
import com.amzi.mastercellusv2.utility.mGraph

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screens.Home.route,
        route = mGraph.HOME
    ){
//        starterNavGraph(navController)
//        composable(route = Screens.Starter.route){
//            StarterScreen()
//        }

        composable(route = mGraph.STARTER){
                MainStarterScreen()
        }

        composable(route = Screens.Home.route){
            HomeScreen()

//            HomeScreen{
//                if(){
//
//                }else{
//
//                }
//
//            }
        }


        composable(route = Screens.Detail.route,
            arguments = listOf(
                navArgument(DETAILS_ARGUMENT_KEY){
                    type = NavType.StringType
                },
                navArgument(DETAILS_ARGUMENT_NAME){
                    type = NavType.StringType
                }

            )){

            Log.d("AMZI: ", it.arguments?.getString(DETAILS_ARGUMENT_KEY).toString())
            Log.d("AMZI: ", it.arguments?.getString(DETAILS_ARGUMENT_NAME).toString())
            DetailsScreen(it.arguments?.getString(DETAILS_ARGUMENT_NAME).toString())
        }



      /*  composable(route = Screens.Splash.route,
            arguments = listOf(
                navArgument(AUTH_ARGUMENT_ID){
                    type = NavType.IntType
                    defaultValue = 0
                }
            )){

            Log.d("AMZI: ", it.arguments?.getInt(AUTH_ARGUMENT_ID).toString())
            SplashScreen()
        }*/

    }
}