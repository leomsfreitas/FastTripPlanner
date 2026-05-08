package br.edu.ifsp.scl.sc3045366.fasttripplanner.ui.screens

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import br.edu.ifsp.scl.sc3045366.fasttripplanner.TripSummaryActivity

@Composable
fun TripOptionsScreen(
    destination: String,
    days: Int,
    dailyBudget: Double,
    onBack: () -> Unit
) {
    val context = LocalContext.current

    var accommodation by rememberSaveable { mutableStateOf("Econômica") }
    var hasTransport by rememberSaveable { mutableStateOf(false) }
    var hasFood by rememberSaveable { mutableStateOf(false) }
    var hasTours by rememberSaveable { mutableStateOf(false) }
    var economicMode by rememberSaveable { mutableStateOf(value = false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Opções da Viagem",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Modo Econômico", style = MaterialTheme.typography.titleMedium)

        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(checked = economicMode, onCheckedChange = {economicMode = it})
            Text(text = "Ativar")
        }

        Text(text = "Hospedagem", style = MaterialTheme.typography.titleMedium)

        listOf("Econômica", "Conforto", "Luxo").forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                RadioButton(
                    selected = accommodation == option,
                    onClick = { accommodation = option }
                )
                Text(text = option)
            }
        }

        if (economicMode) {
            accommodation = "Econômica"
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Serviços Adicionais", style = MaterialTheme.typography.titleMedium)

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = hasTransport, onCheckedChange = { hasTransport = it })
            Text(text = "Transporte (+R$ 300,00)")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = hasFood, onCheckedChange = { hasFood = it })
            Text(text = "Alimentação (+R$ 50,00/dia)")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = hasTours, onCheckedChange = { hasTours = it })
            Text(text = "Passeios (+R$ 120,00/dia)")
        }

        if (economicMode) {
            hasTours = false
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                val intent = Intent(context, TripSummaryActivity::class.java).apply {
                    putExtra(TripSummaryActivity.EXTRA_DESTINATION, destination)
                    putExtra(TripSummaryActivity.EXTRA_DAYS, days)
                    putExtra(TripSummaryActivity.EXTRA_DAILY_BUDGET, dailyBudget)
                    putExtra(TripSummaryActivity.EXTRA_ACCOMMODATION, accommodation)
                    putExtra(TripSummaryActivity.EXTRA_TRANSPORT, hasTransport)
                    putExtra(TripSummaryActivity.EXTRA_FOOD, hasFood)
                    putExtra(TripSummaryActivity.EXTRA_TOURS, hasTours)
                    putExtra(TripSummaryActivity.ECONOMIC_MODE, economicMode)
                }
                context.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular")
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
    }
}
