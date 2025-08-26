package com.akslabs.cloudgallery.ui.main.screens.remote

enum class DownloadState {
    ENQUEUED,
    BLOCKED,
    CHECKING,
    DOWNLOADING,
    DOWNLOADED,
    NOT_DOWNLOADED,
    FAILED,
}