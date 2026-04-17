package br.edu.ifsp.scl.sc3045366.fasttripplanner.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TripDetailsScreen() {
    var destination by remember { mutableStateOf("") }
    var numberOfDays by remember { mutableStateOf("") }
    var dailyBudget by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = destination,
            onValueChange = { destination = it },
            label = { Text("Destination") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = numberOfDays,
            onValueChange = { numberOfDays = it },
            label = { Text("Number of Days") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = dailyBudget,
            onValueChange = { dailyBudget = it },
            label = { Text("Daily Budget") },
            modifier = Modifier.fillMaxWidth()
        )

        var errorMessage by remember { mutableStateOf("") }

        Button(
            onClick = {
                if (destination.isEmpty() ||  numberOfDays.isEmpty() || dailyBudget.isEmpty()) {
                    errorMessage = "Please fill in all fields."
                    return@Button
                }

                val days = numberOfDays.toIntOrNull()
                if (days == null || days <= 0) {
                    errorMessage = "Number of days must be a positive integer."
                    return@Button
                }

                val budget = dailyBudget.toDoubleOrNull()
                if (budget == null || budget <= 0.0) {
                    errorMessage = "Daily budget must be a positive number."
                    return@Button
                }

                errorMessage = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Next")
        }
    }
}