package mx.com.rifat.rickandmorty.resource.component.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun SpannableText(
    spanText: String,
    compText: String,
    colorSpan: Color
) {
    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = colorSpan,
                fontWeight = FontWeight.Bold
            )
        ) {
            append(spanText)
        }
        append(compText)
    }

    Text(
        text = annotatedString,
        fontSize = 10.sp
        )
}

@Preview(showBackground = true)
@Composable
private fun CardPreview() {
    SpannableText(
        spanText = "I have read, ",
        compText = "Terms and Condition",
        colorSpan = Color.Blue
    )
}