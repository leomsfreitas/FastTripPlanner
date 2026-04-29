package br.edu.ifsp.scl.sc3045366.fasttripplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.edu.ifsp.scl.sc3045366.fasttripplanner.ui.screens.TripOptionsScreen
import br.edu.ifsp.scl.sc3045366.fasttripplanner.ui.theme.FastTripPlannerTheme

class TripOptionsActivity : ComponentActivity() {

    companion object {
        const val EXTRA_DESTINATION = "extra_destination"
        const val EXTRA_DAYS = "extra_days"
        const val EXTRA_DAILY_BUDGET = "extra_daily_budget"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val destination = intent.getStringExtra(EXTRA_DESTINATION) ?: ""
        val days = intent.getIntExtra(EXTRA_DAYS, 0)
        val dailyBudget = intent.getDoubleExtra(EXTRA_DAILY_BUDGET, 0.0)

        setContent {
            FastTripPlannerTheme {
                TripOptionsScreen(
                    destination = destination,
                    days = days,
                    dailyBudget = dailyBudget,
                    onBack = { finish() }
                )
            }
        }
    }
}
