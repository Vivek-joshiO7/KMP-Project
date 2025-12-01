package com.vivek.demo.ui.screens.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.vivek.demo.ui.theme.Black
import com.vivek.demo.ui.theme.BlueLite
import com.vivek.demo.ui.theme.White
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabeledCheckbox(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    checkboxColor: CheckboxColors = CheckboxDefaults.colors(BlueLite),
    modifier: Modifier,
    text: String,
    textColor: Color = Black,
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        CompositionLocalProvider(LocalMinimumInteractiveComponentSize provides Dp.Unspecified) {
            Checkbox(checked = checked, onCheckedChange = onCheckedChange, colors = checkboxColor, modifier = Modifier)
        }
        Text(text, color = textColor, modifier = Modifier.padding(start = 5.dp))
    }
}

@Preview
@Composable
fun LabeledCheckboxPreview() {
    LabeledCheckbox(checked = true, onCheckedChange = {}, modifier = Modifier, text = "Remember me", textColor = White)
}