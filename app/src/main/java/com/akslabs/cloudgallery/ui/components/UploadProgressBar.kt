package com.akslabs.cloudgallery.ui.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CloudUpload
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

/**
 * Upload progress bar matching the Uploads screen style.
 * Shows batch progress (Uploading X of 50) and remaining count.
 */
@Composable
fun UploadProgressBar(
    current: Int,
    total: Int,
    totalDone: Int,
    totalPhotos: Int,
    currentFileName: String?,
    modifier: Modifier = Modifier
) {
    val remaining = totalPhotos - totalDone
    val progress = if (total > 0 && current > 0) current.toFloat() / total.toFloat() else 0f
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = spring(stiffness = Spring.StiffnessLow),
        label = "upload_progress"
    )

    // Determine display text and progress
    val statusText = when {
        total > 0 && current > 0 -> "Uploading $current of $total"
        totalPhotos > 0 && totalDone > 0 -> "Backed up $totalDone of $totalPhotos"
        totalPhotos > 0 -> "Starting backup..."
        else -> "Preparing backup..."
    }
    val overallProgress = if (totalPhotos > 0 && totalDone > 0) totalDone.toFloat() / totalPhotos.toFloat() else 0f
    val displayProgress = if (progress > 0f) progress else overallProgress
    val animatedDisplayProgress by animateFloatAsState(
        targetValue = displayProgress,
        animationSpec = spring(stiffness = Spring.StiffnessLow),
        label = "upload_display_progress"
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Thumbnail of current upload
                if (currentFileName != null && currentFileName.startsWith("content://")) {
                    AsyncImage(
                        model = currentFileName,
                        contentDescription = "Uploading",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(Modifier.width(12.dp))
                } else {
                    Icon(
                        Icons.Rounded.CloudUpload,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                }
                Text(
                    text = statusText,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.weight(1f))
                Text(
                    text = if (remaining > 0) "$remaining remaining" else "Complete",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(Modifier.height(8.dp))
            LinearProgressIndicator(
                progress = { if (displayProgress > 0f) animatedDisplayProgress else 0f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(RoundedCornerShape(3.dp)),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceContainerHighest
            )
            if (currentFileName != null && currentFileName.isNotEmpty() && !currentFileName.startsWith("content://")) {
                Spacer(Modifier.height(4.dp))
                val displayName = "Photo ${currentFileName.substringAfterLast("/")}"
                Text(
                    text = displayName,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
                    maxLines = 1
                )
            }
        }
    }
}
