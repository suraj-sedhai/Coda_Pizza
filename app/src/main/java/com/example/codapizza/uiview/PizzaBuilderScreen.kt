@file:Suppress("DEPRECATION")

package com.example.codapizza.uiview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codapizza.R
import com.example.codapizza.model.Pizza
import com.example.codapizza.model.Topping
import com.example.codapizza.model.ToppingPosition

@Composable
private fun ToppingsList(modifier: Modifier) {



    var pizza by remember { mutableStateOf(Pizza()) }



    LazyColumn(
        modifier = modifier
    ) {
        items(Topping.values()) { topping ->
            ToppingCell(
                topping = topping,
                placement = pizza.toppings[topping],
                onClickTopping = {
                    // TODO
                    val isOnPizza = pizza.toppings[topping] != null
                    pizza = pizza.withTopping(
                        topping = topping,
                        placement = if (isOnPizza) {
                            null
                        } else {
                            ToppingPosition.All
                        }
                    )
                }
            )
        }

    }
}

    @Composable
    fun OrderButton(
        modifier: Modifier = Modifier
    ) {
        Button(
            modifier = modifier,
            onClick = {
                // TODO
            }
        ) {
            Text(
                text = stringResource(R.string.place_order_button).toUpperCase(Locale.current)
            )
        }
    }


    @Preview
    @Composable
    fun PizzaBuilderScreen(
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier = modifier
                .padding(25.dp)

        ) {
            ToppingsList(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f, fill = true)



            )

            OrderButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }

    }


