package com.akslabs.cloudgallery.ui.main.screens.about

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountTree
import androidx.compose.material.icons.rounded.ArrowOutward
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Stars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.akslabs.cloudgallery.BuildConfig
import com.akslabs.cloudgallery.R
import com.akslabs.cloudgallery.ui.components.IconTextCard
import com.akslabs.cloudgallery.ui.components.ListCategoryHeader
import com.akslabs.cloudgallery.utils.Constants

@Composable
fun AboutScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    fun openLinkFromHref(href: String) {
        context.startActivity(
            Intent(Intent.ACTION_VIEW, Uri.parse(href))
        )
    }

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(4.dp))
        ListCategoryHeader(title = stringResource(R.string.app))
        Spacer(modifier = Modifier.height(6.dp))

        IconTextCard(
            settingHeaderText = stringResource(R.string.version),
            settingSummaryText = "${BuildConfig.VERSION_NAME} (${BuildConfig.VERSION_CODE})",
            imageVector = Icons.Rounded.Info
        ) {}
        Spacer(modifier = Modifier.height(6.dp))

        IconTextCard(
            settingHeaderText = stringResource(R.string.source_code),
            imageVector = Icons.Rounded.AccountTree
        ) {
            openLinkFromHref(Constants.REPO_GITHUB)
        }
        Spacer(modifier = Modifier.height(6.dp))

        IconTextCard(
            settingHeaderText = stringResource(R.string.license),
            imageVector = Icons.Rounded.Stars
        ) {
            openLinkFromHref(Constants.LICENSE)
        }
        Spacer(modifier = Modifier.height(6.dp))

        Spacer(modifier = Modifier.size(6.dp))
        ListCategoryHeader(title = stringResource(R.string.contributors))
        Spacer(modifier = Modifier.size(6.dp))

        IconTextCard(
            settingHeaderText = stringResource(R.string.see_on_github),
            imageVector = Icons.Rounded.ArrowOutward
        ) {
            openLinkFromHref(Constants.CONTRIBUTORS_GITHUB)
        }
    }
}
