import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.movieapp.R
import com.example.movieapp.presentation.components.lottie_icons.LottieItems
import com.example.movieapp.presentation.search.SearchUiState

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    goToMainScreen: () -> Unit,
) {

    val onValueChanged by remember {
        mutableStateOf("")
    }
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Icon(
                modifier = Modifier.clickable {
                    goToMainScreen()
                }, imageVector = Icons.Default.ArrowBack, contentDescription = null
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.search_screen)
            )
        }
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            value = onValueChanged,
            onValueChange = {
                onValueChanged
            },
            shape = RoundedCornerShape(25.dp),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Color.Gray,
                )
            },
            placeholder = {
                Text(
                    text = "Start Search",
                    color = Color.Gray,
                    minLines = 1
                )
            },
        )
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            LottieItems(
                modifier = Modifier.size(240.dp),
                lottie = R.raw.search
            )
        }
    }
}