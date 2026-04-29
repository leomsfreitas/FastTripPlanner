package br.edu.ifsp.scl.sc3045366.fasttripplanner.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.text.NumberFormat
import java.util.Locale

@Composable
fun TripSummaryScreen(
    destination: String,
    days: Int,
    dailyBudget: Double,
    accommodation: String,
    hasTransport: Boolean,
    hasFood: Boolean,
    hasTours: Boolean,
    onRestart: () -> Unit
) {
    val custoBase = days * dailyBudget

    val accommodationMultiplier = when (accommodation) {
        "Conforto" -> 1.5
        "Luxo" -> 2.2
        else -> 1.0
    }
    val custoHospedagem = custoBase * accommodationMultiplier

    val extraTransport = if (hasTransport) 300.0 else 0.0
    val extraFood = if (hasFood) 50.0 * days else 0.0
    val extraTours = if (hasTours) 120.0 * days else 0.0

    val totalCost = custoHospedagem + extraTransport + extraFood + extraTours

    val currency = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Resumo da Viagem",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Destino: $destination")
        Text(text = "Número de dias: $days")
        Text(text = "Orçamento diário: ${currency.format(dailyBudget)}")
        Text(text = "Hospedagem: $accommodation")

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Serviços Adicionais:", style = MaterialTheme.typography.titleMedium)

        if (hasTransport) Text(text = "  • Transporte: ${currency.format(extraTransport)}")
        if (hasFood) Text(text = "  • Alimentação: ${currency.format(extraFood)}")
        if (hasTours) Text(text = "  • Passeios: ${currency.format(extraTours)}")
        if (!hasTransport && !hasFood && !hasTours) Text(text = "  Nenhum serviço selecionado")

        Spacer(modifier = Modifier.height(16.dp))

        HorizontalDivider()

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Custo Total: ${currency.format(totalCost)}",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onRestart,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Reiniciar Planejamento")
        }
    }
}
