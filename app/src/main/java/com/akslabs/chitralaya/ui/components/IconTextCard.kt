package com.akslabs.cloudgallery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akslabs.cloudgallery.R

@Composable
fun IconTextCard(
    modifier: Modifier = Modifier,
    settingHeaderText: String,
    settingSummaryText: String? = null,
    imageVector: ImageVector,
    enabled: Boolean = true,
    clickable: () -> Unit,
) {
    Spacer(modifier = modifier.height(6.dp))
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onSecondary)
            .clickable(enabled) {
                clickable()
            }
    ) {
        Row(
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = stringResource(R.string.icon),
                modifier = modifier.size(25.dp)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = modifier.padding(10.dp)
            ) {
                Text(
                    text = settingHeaderText,
                    fontSize = 18.sp
                )
                settingSummaryText?.let {
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(
                        text = it,
                        fontSize = 12.sp,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
        }
    }
}