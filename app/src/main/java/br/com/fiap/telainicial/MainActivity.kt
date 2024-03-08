package br.com.fiap.telainicial

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.telainicial.ui.theme.TelaInicialTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TelaInicialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                BuscaDestino()
                }

            }

        }
    }
}

@Composable
fun BuscaDestino() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Spacer(modifier = Modifier.height(10.dp))
            Icon(
                modifier = Modifier
                    .size(35.dp) // Ajustando o tamanho do ícone
                    .padding(top = 8.dp), // Ajustando o espaçamento do ícone
                painter = painterResource(id = R.drawable.baseline_dehaze_24),
                contentDescription = "Ícone de Busca"
            )

            Spacer(modifier = Modifier.height(24.dp)) // Adicionando espaço entre o ícone e o texto
        }

        Text(
            text = "Onde você quer ir?",
            modifier = Modifier.padding(horizontal = 15.dp) // Ajustando o padding horizontal do texto
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Terminal Parque Dom Pedro II") },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = "Ícone de Pesquisa",
                    modifier = Modifier.size(30.dp)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp) // Ajustando padding horizontal do input
        )

        Spacer(modifier = Modifier.height(16.dp)) // Adicionando espaço abaixo do input

        AvisoLocalizacao()

        Spacer(modifier = Modifier.height(16.dp)) // Adicionando espaço abaixo do aviso de localização

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = "Locais salvos",
                style = LocalTextStyle.current.copy(fontSize = 14.sp),
            )
            Text(
                text = "Adicionar",
                style = LocalTextStyle.current.copy(fontSize = 14.sp, color = MaterialTheme.colorScheme.primary),
                modifier = Modifier.padding(end = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        DefinirCasa()

        DefinirTrabalho()

        ChamarUber(context = LocalContext.current)

        Spacer(modifier = Modifier.weight(1f))

        MenuOpcoes()
    }
}

@Composable
fun AvisoLocalizacao() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = 5.dp)
    ) {
        Spacer(modifier = Modifier.width(24.dp)) // Adicionando espaço para alinhar o ícone de localização

        Icon(
            modifier = Modifier.size(38.dp),
            painter = painterResource(id = R.drawable.baseline_emergency_share_24),
            contentDescription = "Ícone de Localização"
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "Sua localização é necessária para fornecer informações precisas sobre a viagem até seu destino.",
            style = LocalTextStyle.current.copy(fontSize = 14.sp),
        )
    }
}

@Composable
fun DefinirCasa() {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 14.dp)
        ) {
            Icon(
                modifier = Modifier.size(27.dp),
                painter = painterResource(id = R.drawable.baseline_home_24),
                contentDescription = "Ícone de Casa"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = "Casa",
                    style = LocalTextStyle.current.copy(fontSize = 16.sp),
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Toque para configurar",
                    style = LocalTextStyle.current.copy(fontSize = 12.sp),
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                modifier = Modifier.size(27.dp),
                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                contentDescription = "Ícone de seta para a direita"
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        Spacer(modifier = Modifier.height(12.dp))

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp), // Adicionando espaçamento lateral para o Divider
            color = Color.Gray,
            thickness = 1.dp
        )
        Spacer(modifier = Modifier.height(15.dp))
    }
}

@Composable
fun DefinirTrabalho() {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 14.dp)
        ) {
            Icon(
                modifier = Modifier.size(27.dp),
                painter = painterResource(id = R.drawable.baseline_home_repair_service_24),
                contentDescription = "Ícone de trabalho"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = "Trabalho",
                    style = LocalTextStyle.current.copy(fontSize = 16.sp),
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Toque para configurar",
                    style = LocalTextStyle.current.copy(fontSize = 12.sp),
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                modifier = Modifier.size(27.dp),
                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                contentDescription = "Ícone de seta para a direita"
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        Spacer(modifier = Modifier.height(10.dp))

    }
}


@Composable
fun ChamarUber(context: Context) {
    Column {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.padding(start = 15.dp),
            text = "Serviços de táxi e transporte por aplicativo",
            style = LocalTextStyle.current.copy(fontSize = 13.sp),
        )
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 14.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        val uberIntent = Intent(Intent.ACTION_VIEW).apply {
                            data = Uri.parse("uber://")
                            setPackage("com.ubercab")
                        }
                        if (uberIntent.resolveActivity(context.packageManager) != null) {
                            context.startActivity(uberIntent)
                        } else {
                            // Uber app is not installed, open Google Play
                            val playStoreIntent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=com.ubercab")
                            )
                            context.startActivity(playStoreIntent)
                        }
                    },
                painter = painterResource(id = R.drawable.image_ub), // Substitua pelo recurso do ícone do Uber
                contentDescription = "Ícone do Uber"
            )
            Text(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clickable {
                        val playStoreIntent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=com.ubercab")
                        )
                        context.startActivity(playStoreIntent)
                    },
                text = "Chamar Uber",
                style = LocalTextStyle.current.copy(fontSize = 16.sp),
            )
        }
    }
}

@Composable
fun MenuOpcoes() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp) // Altura ajustada para acomodar ícones e legendas
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)) // Arredondando os cantos
            .background(color = MaterialTheme.colorScheme.primary) // Usando a cor primária do tema
            .padding(horizontal = 16.dp), // Adicionando espaço horizontal
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavigationItem(imageResId = R.drawable.baseline_route_white_24dp, label = "Rotas")
            BottomNavigationItem(imageResId = R.drawable.baseline_place_white_24dp, label = "Paradas")
            BottomNavigationItem(imageResId = R.drawable.baseline_directions_bus_white_24dp, label = "Linhas")
        }
    }
}

@Composable
fun BottomNavigationItem(@DrawableRes imageResId: Int, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Icon(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(36.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            color = Color.Black,
            fontSize = 12.sp
        )
    }
}





















