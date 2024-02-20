package com.arn.arnandroidui

import android.content.Context
import android.content.res.Resources
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.arn.arnandroidui.ui.theme.ArnAndroidUITheme

@Composable
fun LoginScreen(modifier: Modifier = Modifier){
    val textNip = remember { mutableStateOf(TextFieldValue()) }
    val textPassword = remember { mutableStateOf(TextFieldValue()) }
    val state = rememberScrollState()

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .fillMaxHeight()
            .verticalScroll(state)
    ) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(5.dp)

        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.hsi_sakinah),
                    contentDescription = stringResource(R.string.label_logo_atas),
                    modifier = modifier
                        .padding(5.dp)
                        .size(100.dp)
                )

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ){

                Text(
                    modifier = Modifier.padding(start = 19.dp, end = 19.dp),
                    text = stringResource(R.string.label_textfield_nip)
                )
                Row(

                ){

                    TextField(
                        modifier = Modifier
                            .padding(start = 19.dp, end = 19.dp, bottom = 16.dp)
                            .weight(1f),
                        shape = RoundedCornerShape(5.dp),
                        value = textNip.value,
                        onValueChange = { textNip.value = it }
                    )
                }


                Text(
                    modifier = Modifier.padding(start = 19.dp, end = 19.dp),
                    text = stringResource(R.string.label_textfield_password)
                )
                Row(

                ){

                    TextField(
                        modifier = Modifier
                            .padding(start = 19.dp, end = 19.dp, bottom = 16.dp)
                            .weight(1f),
                        shape = RoundedCornerShape(5.dp),
                        value = textPassword.value,
                        visualTransformation = PasswordVisualTransformation(),
                        onValueChange = { textPassword.value = it }
                    )
                }

                Row(

                ){
                    val context = LocalContext.current
                    Button(
                        onClick = { Toast.makeText(context,validateData(context,textNip.value,textPassword.value),Toast.LENGTH_SHORT).show() },
                        modifier = Modifier
                            .padding(start = 19.dp, end = 19.dp, bottom = 16.dp)
                            .weight(1f)
                            .height(50.dp),
                        shape = RoundedCornerShape(35),
                        colors = ButtonDefaults.buttonColors(containerColor = Color("#40A2E3".toColorInt()))
                    ){
                        Text(stringResource(R.string.label_button_login))
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = stringResource(R.string.text_no_access))

                val context = LocalContext.current
                val toastIkhwan = stringResource(R.string.toast_ikhwan)
                TextButton(
                    onClick = { Toast.makeText(context, toastIkhwan,Toast.LENGTH_SHORT).show() },
                    modifier = Modifier.padding(start = 19.dp, end = 19.dp),
                ){
                    Text(text = stringResource(R.string.text_cs_ikhwan), color = Color("#40A2E3".toColorInt()))
                }

                val toastAkhwat = stringResource(R.string.toast_akhwat)
                TextButton(
                    onClick = { Toast.makeText(context, toastAkhwat,Toast.LENGTH_SHORT).show() },
                    modifier = Modifier.padding(start = 19.dp, end = 19.dp),
                ){
                    Text(text = stringResource(R.string.text_cs_akhwat), color = Color("#40A2E3".toColorInt()))
                }
            }
        }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .weight(1f, false)
            ,
            horizontalArrangement = Arrangement.Center
        ){
            val context = LocalContext.current
            val  toastFaq = stringResource((R.string.text_faq))
            OutlinedButton(
                onClick = { Toast.makeText(context,toastFaq,Toast.LENGTH_SHORT).show() },
                modifier = Modifier
                    .padding(start = 19.dp, end = 19.dp, bottom = 16.dp)
                    .height(50.dp)
                    .weight(1f),
                border = BorderStroke(1.dp,Color("#40A2E3".toColorInt())),
                shape = RoundedCornerShape(35),
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(color = Color("#40A2E3".toColorInt()), text = stringResource(R.string.text_faq))
                    Image(
                        painter = painterResource(R.drawable.baseline_open_in_new_24),
                        contentDescription = stringResource(R.string.label_logo_faq),
                        modifier = modifier
                            .size(20.dp)
                    )
                }
            }

        }
    }
}

fun validateData(context: Context,textNip: TextFieldValue, textPassword: TextFieldValue):String {
    var textToast:String = ""

    if(textNip.text.isEmpty()){
        textToast = context.getString (R.string.toast_login_nip_false)
    }else if(textPassword.text.isEmpty()){
        textToast = context.getString(R.string.toast_login_password_false)
    }else{
        textToast = context.getString(R.string.toast_login_true)
    }


    return textToast
}

@Preview(showBackground = true)
@Composable
fun LoginPreview(){
    ArnAndroidUITheme {
        LoginScreen()
    }
}