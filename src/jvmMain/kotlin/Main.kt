import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import kotlin.properties.Delegates

@ExperimentalMaterial3Api


// Data for RecyclerView 1
@OptIn(ExperimentalMaterial3Api::class)
fun solveEquationSystem(coefficients: Array<Array<Double>>, freeNumbers: Array<Double>): List<CardItem> {
    val solver = Iteration(coefficients, freeNumbers)
    return solver.solve()
}

@OptIn(ExperimentalMaterial3Api::class)
fun main() = application {
// Data for RecyclerView 1
    var recyclerView1Data = listOf<CardItem>(CardItem("Пока тут пусто", "Пока тут пусто"))
// Data for RecyclerView 2
    var recyclerView2Data = listOf<CardItem>(CardItem("Пока тут пусто", "Пока тут пусто"))
    var a11 by remember { mutableStateOf(TextFieldValue("")) }
    var a12 by remember { mutableStateOf(TextFieldValue("")) }
    var a13 by remember { mutableStateOf(TextFieldValue("")) }
    var free1 by remember { mutableStateOf(TextFieldValue("")) }
    var a21 by remember { mutableStateOf(TextFieldValue("")) }
    var a22 by remember { mutableStateOf(TextFieldValue("")) }
    var a23 by remember { mutableStateOf(TextFieldValue("")) }
    var free2 by remember { mutableStateOf(TextFieldValue("")) }
    var a31 by remember { mutableStateOf(TextFieldValue("")) }
    var a32 by remember { mutableStateOf(TextFieldValue("")) }
    var a33 by remember { mutableStateOf(TextFieldValue("")) }
    var free3 by remember { mutableStateOf(TextFieldValue("")) }
    Window(
        onCloseRequest = ::exitApplication,
        title = "Методы итераций и зейделя",
        state = rememberWindowState(width = 1000.dp, height = 1000.dp)
    ) {
        MaterialTheme {

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Row {
                        // Row 1
                        OutlinedTextField(
                            value = a11,
                            onValueChange = { newText -> a11 = newText },
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            label = { Text("a11") },
                            maxLines = 1
                        )
                        OutlinedTextField(
                            value = a12,
                            onValueChange = { newText -> a12 = newText },
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            label = { Text("a12") },
                            maxLines = 1
                        )
                        OutlinedTextField(
                            value = a13,
                            onValueChange = { newText -> a13 = newText },
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            label = { Text("a13") },
                            maxLines = 1
                        )
                        OutlinedTextField(
                            value = free1,
                            onValueChange = { newText -> free1 = newText },
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            label = { Text("B1") },
                            maxLines = 1
                        )
                    }
                    Row {
                        // Row 2
                        OutlinedTextField(
                            value = a21,
                            onValueChange = { newText -> a21 = newText },
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            label = { Text("a21") },
                            maxLines = 1
                        )
                        OutlinedTextField(
                            value = a22,
                            onValueChange = { newText -> a22 = newText },
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            label = { Text("a22") },
                            maxLines = 1
                        )
                        OutlinedTextField(
                            value = a23,
                            onValueChange = { newText -> a23 = newText },
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            label = { Text("a23") },
                            maxLines = 1
                        )
                        OutlinedTextField(
                            value = free2,
                            onValueChange = { newText -> free2 = newText },
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            label = { Text("B2") },
                            maxLines = 1
                        )
                    }
                    Row {
                        // Row 3
                        OutlinedTextField(
                            value = a31,
                            onValueChange = { newText -> a31 = newText },
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            label = { Text("a31") },
                            maxLines = 1
                        )
                        OutlinedTextField(
                            value = a32,
                            onValueChange = { newText -> a32 = newText },
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            label = { Text("a32") },
                            maxLines = 1
                        )
                        OutlinedTextField(
                            value = a33,
                            onValueChange = { newText -> a33 = newText },
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            label = { Text("a33") },
                            maxLines = 1
                        )
                        OutlinedTextField(
                            value = free3,
                            onValueChange = { newText -> free3 = newText },
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            label = { Text("B3") },
                            maxLines = 1
                        )
                    }

// Convert strings to doubles

// Create the 2D array of doubles
                    Spacer(modifier = Modifier.height(16.dp))
                    // Dropdown menu
                    // Display selected option
                    // Button to display count
                    Button(
                        onClick = {
                            var coefficients = arrayOf(
                                arrayOf(a11.text.toDouble(), a12.text.toDouble(), a13.text.toDouble()),
                                arrayOf(a21.text.toDouble(), a22.text.toDouble(), a23.text.toDouble()),
                                arrayOf(a31.text.toDouble(), a32.text.toDouble(), a33.text.toDouble())
                            )
                            var free = arrayOf(free1.text.toDouble(), free2.text.toDouble(), free3.text.toDouble())
                            recyclerView1Data = solveEquationSystem(coefficients, free)
                            val solver = Seidel(coefficients, free)
                            recyclerView2Data = solver.solve()
                        },
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text("Решить")
                    }
                    LazyColumn {
                        item {
                            Text(
                                text = "Итераций",
                                style = MaterialTheme.typography.h6,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                        items(recyclerView1Data.size) { index ->
                            val CardItem = recyclerView1Data[index]
                            Card(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = CardItem.title,
                                    style = MaterialTheme.typography.h6,
                                    modifier = Modifier.padding(8.dp)
                                )
                                Text(
                                    text = CardItem.description,
                                    style = MaterialTheme.typography.body2,
                                    modifier = Modifier.padding(8.dp)
                                )
                            }
                        }
                        item {
                            Text(
                                text = "Зейделя",
                                style = MaterialTheme.typography.h6,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                        items(recyclerView2Data.size) { index ->
                            val CardItem = recyclerView2Data[index]
                            Card(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = CardItem.title,
                                    style = MaterialTheme.typography.h6,
                                    modifier = Modifier.padding(8.dp)
                                )
                                Text(
                                    text = CardItem.description,
                                    style = MaterialTheme.typography.body2,
                                    modifier = Modifier.padding(8.dp)
                                )
                            }
                        }
                    }
                }
            )
        }
    }
}
