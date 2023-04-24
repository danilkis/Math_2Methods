import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import androidx.compose.material3.*
@ExperimentalMaterial3Api


// Data for RecyclerView 1
@OptIn(ExperimentalMaterial3Api::class)

fun main() = application {
    data class CardItem(val title: String, val description: String)

// Data for RecyclerView 1
    val recyclerView1Data = listOf(
        CardItem("Итерация 1", "Description 1.1"),
        CardItem("Итерация 2", "Description 1.2"),
        CardItem("Итерация 3", "Description 1.3")
    )

// Data for RecyclerView 2
    val recyclerView2Data = listOf(
        CardItem("Итерация 1", "Description 2.1"),
        CardItem("Итерация 2", "Description 2.2"),
        CardItem("Итерация 3", "Description 2.3")
    )
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
                        var text by remember { mutableStateOf(TextFieldValue("")) }
                        OutlinedTextField(
                            value = text,
                            onValueChange = { newText -> text = newText },
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            label = { Text("a11") },
                            maxLines = 1
                        )
                        var text1 by remember { mutableStateOf(TextFieldValue("")) }
                        OutlinedTextField(
                            value = text1,
                            onValueChange = { newText -> text1 = newText },
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            label = { Text("a12") },
                            maxLines = 1
                        )
                        var text2 by remember { mutableStateOf(TextFieldValue("")) }
                        OutlinedTextField(
                            value = text2,
                            onValueChange = { newText -> text2 = newText },
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            label = { Text("a13") },
                            maxLines = 1
                        )
                        var free1 by remember { mutableStateOf(TextFieldValue("")) }
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
                        var text3 by remember { mutableStateOf(TextFieldValue("")) }
                        OutlinedTextField(
                            value = text3,
                            onValueChange = { newText -> text3 = newText },
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            label = { Text("a21") },
                            maxLines = 1
                        )
                        var text4 by remember { mutableStateOf(TextFieldValue("")) }
                        OutlinedTextField(
                            value = text4,
                            onValueChange = { newText -> text4 = newText },
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            label = { Text("a22") },
                            maxLines = 1
                        )
                        var text5 by remember { mutableStateOf(TextFieldValue("")) }
                        OutlinedTextField(
                            value = text5,
                            onValueChange = { newText -> text5 = newText },
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            label = { Text("a23") },
                            maxLines = 1
                        )
                        var free2 by remember { mutableStateOf(TextFieldValue("")) }
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
                        var text6 by remember { mutableStateOf(TextFieldValue("")) }
                        OutlinedTextField(
                            value = text6,
                            onValueChange = { newText -> text6 = newText },
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            label = { Text("a31") },
                            maxLines = 1
                        )
                        var text7 by remember { mutableStateOf(TextFieldValue("")) }
                        OutlinedTextField(
                            value = text7,
                            onValueChange = { newText -> text7 = newText },
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            label = { Text("a32") },
                            maxLines = 1
                        )
                        var text8 by remember { mutableStateOf(TextFieldValue("")) }
                        OutlinedTextField(
                            value = text8,
                            onValueChange = { newText -> text8 = newText },
                            modifier = Modifier
                                .padding(5.dp)
                                .width(60.dp),
                            label = { Text("a33") },
                            maxLines = 1
                        )
                        var free3 by remember { mutableStateOf(TextFieldValue("")) }
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
                    Spacer(modifier = Modifier.height(16.dp))
                    // Dropdown menu
                    // Display selected option

                    Spacer(modifier = Modifier.height(16.dp))
                    // Button to display count
                    Button(
                        onClick = { },
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
