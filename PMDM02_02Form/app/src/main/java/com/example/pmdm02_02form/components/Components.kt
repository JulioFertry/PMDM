package com.example.pmdm02_02form.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmdm02_02form.R


@Composable
fun TitleBox(title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().padding(5.dp)
    ) {
        Text(
            text = title,
            color = colorResource(R.color.title_color),
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
        )
    }

}


@Composable
fun StringBox(
    titleText: String,
    placeholderText: String,
    thisText: String = "",
    onTextChange: (String) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth().padding(10.dp)
    ) {
        Text(
            text = titleText,
            color = colorResource(id = R.color.black),
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        )

        TextField(
            value = thisText,
            onValueChange = onTextChange,
            placeholder = { Text(
                text = placeholderText,
                fontSize = 12.sp,
                color = colorResource(id = R.color.disbaled_grey)
            )},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            singleLine = true
        )
    }

}


@Composable
fun SendButton(onClickAct: () -> Unit, isEnabled: Boolean = false) {
    Button(
        onClick = onClickAct,
        shape = RoundedCornerShape(16.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 15.dp,
            pressedElevation = 5.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.blue_green),
            contentColor = colorResource(id = R.color.white),
            disabledContainerColor = colorResource(id = R.color.disbaled_grey)
        ),
        modifier = Modifier.fillMaxWidth().padding(5.dp).width(150.dp).height(50.dp),
        enabled = isEnabled
    ) {
        Text(
            text = "ENVIAR",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}


@Composable
fun TextCheckBox(thisText: String, isChecked: MutableState<Boolean>) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(10.dp)
            .clickable { isChecked.value = !isChecked.value }
            .padding(5.dp)
            .fillMaxWidth()
    ) {
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = {isChecked.value = it}
        )

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = thisText,
            style = TextStyle(fontSize = 12.sp)
        )
    }
}


@Composable
fun Message(message: String) {
    Text(
        text = message,
        color = colorResource(id = R.color.black),
        style = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
        )
    )
}