package br.edu.ifsp.scl.sc3045366.fasttripplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.edu.ifsp.scl.sc3045366.fasttripplanner.ui.screens.TripDetailsScreen
import br.edu.ifsp.scl.sc3045366.fasttripplanner.ui.theme.FastTripPlannerTheme

class TripDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FastTripPlannerTheme {
                TripDetailsScreen()
            }
        }
    }
}