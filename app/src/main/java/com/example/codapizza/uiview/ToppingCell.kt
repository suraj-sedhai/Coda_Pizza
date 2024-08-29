package com.example.codapizza.uiview

import androidx.annotation.ColorRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codapizza.R
import com.example.codapizza.model.Topping
import com.example.codapizza.model.ToppingPosition

@Composable
fun ToppingCell(topping: Topping, placement: ToppingPosition?,modifier: Modifier = Modifier,
                onClickTopping: () -> Unit) {


    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clickable { onClickTopping() }
            .padding(vertical = 4.dp, horizontal = 16.dp)
            .background(colorResource(id = R.color.teal_700))

    ) {
        Checkbox(
            checked = (placement != null),
            onCheckedChange = { onClickTopping() })


        Column(modifier = Modifier
            .weight(1f, fill = true)
            .padding(start = 4.dp)) {
            Text(
                text = stringResource(topping.toppingName),
                style = MaterialTheme.typography.bodyLarge,
                color = colorResource(id = R.color.white) // Using a predefined color
            )
            if (placement != null) {
                Text(

                    text = stringResource(placement.label),
                    color = colorResource(id = R.color.white),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }


}



