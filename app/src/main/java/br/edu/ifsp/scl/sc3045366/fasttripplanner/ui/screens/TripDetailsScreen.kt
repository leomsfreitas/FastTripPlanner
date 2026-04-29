package br.edu.ifsp.scl.sc3045366.fasttripplanner.ui.screens

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import br.edu.ifsp.scl.sc3045366.fasttripplanner.TripOptionsActivity

@Composable
fun TripDetailsScreen() {
    val context = LocalContext.current

    var destination by rememberSaveable { mutableStateOf("") }
    var numberOfDays by rememberSaveable { mutableStateOf("") }
    var dailyBudget by rememberSaveable { mutableStateOf("") }
    var errorMessage by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Dados da Viagem",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = destination,
            onValueChange = { destination = it },
            label = { Text("Destino") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = numberOfDays,
            onValueChange = { numberOfDays = it },
            label = { Text("Número de Dias") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = dailyBudget,
            onValueChange = { dailyBudget = it },
            label = { Text("Orçamento Diário (R$)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        Button(
            onClick = {
                if (destination.isBlank() || numberOfDays.isBlank() || dailyBudget.isBlank()) {
                    errorMessage = "Preencha todos os campos."
                    return@Button
                }

                val days = numberOfDays.toIntOrNull()
                if (days == null || days <= 0) {
                    errorMessage = "Número de dias deve ser um inteiro positivo."
                    return@Button
                }

                val budget = dailyBudget.toDoubleOrNull()
                if (budget == null || budget <= 0.0) {
                    errorMessage = "Orçamento diário deve ser um número positivo."
                    return@Button
                }

                errorMessage = ""

                val intent = Intent(context, TripOptionsActivity::class.java).apply {
                    putExtra(TripOptionsActivity.EXTRA_DESTINATION, destination)
                    putExtra(TripOptionsActivity.EXTRA_DAYS, days)
                    putExtra(TripOptionsActivity.EXTRA_DAILY_BUDGET, budget)
                }
                context.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Próximo")
        }
    }
}
