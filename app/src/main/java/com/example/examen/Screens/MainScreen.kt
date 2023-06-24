package com.example.examen.Screens

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examen.Data.Lista
import com.example.examen.Data.Personas
import com.example.examen.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    var lista= Lista().list_personas
    Content(lista)
}

@Composable
fun Content(listaPersonas: List<Personas>) {
    LazyColumn {
        items(listaPersonas) { personas ->
        Greeting(listaPersonas = personas)
        }

    }
}

@Composable
fun Greeting(listaPersonas: Personas) {

    var isExpanded by remember { mutableStateOf(false) }
    val extrapadding = animateDpAsState(
        if (isExpanded) 10.dp else 0.dp
    )
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .padding(5.dp)
            .padding(bottom = extrapadding.value)
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth()) {
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Nombre:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(start = 20.dp)
                )
                Spacer(modifier = Modifier.size(25.dp))
                Text(
                    text = listaPersonas.nombre, fontSize = 17.sp, modifier = Modifier
                        .alignBy(LastBaseline)
                        .padding(start = 46.dp)
                )
            }
            if (isExpanded) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Apellido:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp,
                        modifier = Modifier.padding(start = 20.dp)
                    )
                    Spacer(modifier = Modifier.size(23.dp))
                    Text(
                        text = listaPersonas.apellido, fontSize = 17.sp, modifier = Modifier
                            .alignBy(LastBaseline)
                            .padding(start = 46.dp)
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Telefono:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp,
                        modifier = Modifier.padding(start = 20.dp)
                    )
                    Spacer(modifier = Modifier.size(64.dp))
                    Text(text = listaPersonas.telefono, fontSize = 17.sp)
                }
                }
            IconButton(onClick = {isExpanded =! isExpanded}, modifier = Modifier.align(alignment = Alignment.End)) {
                Icon(
                    imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = if(isExpanded){
                        stringResource(R.string.show_less)
                    } else {
                        stringResource(R.string.show_more)
                    }
                )

            }
            }


        }
    }



@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}