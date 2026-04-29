package br.edu.ifsp.scl.sc3045366.fasttripplanner

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.edu.ifsp.scl.sc3045366.fasttripplanner.ui.screens.TripSummaryScreen
import br.edu.ifsp.scl.sc3045366.fasttripplanner.ui.theme.FastTripPlannerTheme

class TripSummaryActivity : ComponentActivity() {

    companion object {
        const val EXTRA_DESTINATION = "extra_destination"
        const val EXTRA_DAYS = "extra_days"
        const val EXTRA_DAILY_BUDGET = "extra_daily_budget"
        const val EXTRA_ACCOMMODATION = "extra_accommodation"
        const val EXTRA_TRANSPORT = "extra_transport"
        const val EXTRA_FOOD = "extra_food"
        const val EXTRA_TOURS = "extra_tours"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val destination = intent.getStringExtra(EXTRA_DESTINATION) ?: ""
        val days = intent.getIntExtra(EXTRA_DAYS, 0)
        val dailyBudget = intent.getDoubleExtra(EXTRA_DAILY_BUDGET, 0.0)
        val accommodation = intent.getStringExtra(EXTRA_ACCOMMODATION) ?: "Econômica"
        val hasTransport = intent.getBooleanExtra(EXTRA_TRANSPORT, false)
        val hasFood = intent.getBooleanExtra(EXTRA_FOOD, false)
        val hasTours = intent.getBooleanExtra(EXTRA_TOURS, false)

        setContent {
            FastTripPlannerTheme {
                TripSummaryScreen(
                    destination = destination,
                    days = days,
                    dailyBudget = dailyBudget,
                    accommodation = accommodation,
                    hasTransport = hasTransport,
                    hasFood = hasFood,
                    hasTours = hasTours,
                    onRestart = {
                        val intent = Intent(this, TripDetailsActivity::class.java).apply {
                            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                        }
                        startActivity(intent)
                        finish()
                    }
                )
            }
        }
    }
}
