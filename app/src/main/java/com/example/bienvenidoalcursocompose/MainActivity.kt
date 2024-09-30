package com.example.bienvenidoalcursocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.bienvenidoalcursocompose.ui.theme.BienvenidoAlCursoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BienvenidoAlCursoComposeTheme {
                EnrollmentScreen()
            }
        }
    }

    @Composable
    fun EnrollmentScreen() {
        var name by remember { mutableStateOf(TextFieldValue()) }
        var email by remember { mutableStateOf(TextFieldValue()) }
        var isSubmitted by remember { mutableStateOf(false) }

        if (isSubmitted) {
            ConfirmationMessage()
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFBBDEFB)), // Color de fondo
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Inscripción al Curso",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0D47A1)
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    TextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Nombre") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Correo Electrónico") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            isSubmitted = true
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Inscribirse")
                    }
                }
            }
        }
    }

    @Composable
    fun ConfirmationMessage() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "¡Te has inscrito exitosamente!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0D47A1)
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewEnrollmentScreen() {
        BienvenidoAlCursoComposeTheme {
            EnrollmentScreen()
        }
    }
}
