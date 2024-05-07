package br.senai.sp.jandira.contato.screens

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.contato.R
import br.senai.sp.jandira.contato.model.Contato
import br.senai.sp.jandira.contato.repository.ContatoRepository
import br.senai.sp.jandira.contato.ui.theme.ContatoTheme


@Composable
fun FormularioContatos(controladorDeNavegacao: NavHostController) {
    var nomeState = remember { mutableStateOf("") }
    var emailState = remember { mutableStateOf("") }
    var phoneState = remember { mutableStateOf("") }
    var dataNascimentoState = remember { mutableStateOf("") }
    var isAmigoState = remember { mutableStateOf(false) }

    val cr = ContatoRepository(LocalContext.current)

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.title_new_contact),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = nomeState.value,
            onValueChange = { nomeState.value = it },
            label = { Text(text = stringResource(id = R.string.contact_name)) },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = { Text(text = stringResource(id = R.string.email)) },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = phoneState.value,
            onValueChange = { phoneState.value = it },
            label = { Text(text = stringResource(id = R.string.contact_phone)) },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = dataNascimentoState.value,
            onValueChange = { dataNascimentoState.value = it },
            label = { Text(text = stringResource(id = R.string.contact_date)) },
            modifier = Modifier.fillMaxWidth()
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = isAmigoState.value,
                onCheckedChange = { isAmigoState.value = it }
            )
            Text(text = stringResource(id = R.string.contact_friend))
        }

        Button(
            onClick = {
                val contato = Contato(
                    nome = nomeState.value,
                    email = emailState.value,
                    telefone = phoneState.value,
                    isAmigo = isAmigoState.value
                )
                cr.salvar(contato)
                controladorDeNavegacao.navigate("home")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.save))
        }
    }
}


