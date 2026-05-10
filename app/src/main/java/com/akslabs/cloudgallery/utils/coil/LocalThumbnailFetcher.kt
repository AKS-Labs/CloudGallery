package com.akslabs.cloudgallery.utils.coil

import coil.ImageLoader
import coil.decode.DataSource
import coil.decode.ImageSource
import coil.fetch.FetchResult
import coil.fetch.Fetcher
import coil.fetch.SourceResult
import coil.request.Options
import com.akslabs.cloudgallery.data.localdb.entities.RemotePhoto

/**
 * Coil Fetcher that reads thumbnail bytes directly from the local Room DB.
 * Zero network during scroll — all data comes from the thumbnailBytes BLOB column.
 */
class LocalThumbnailFetcher(
    private val remotePhoto: RemotePhoto,
    private val options: Options,
) : Fetcher {

    override suspend fun fetch(): FetchResult? {
        val bytes = remotePhoto.thumbnailBytes ?: return null
        val buffer = okio.Buffer().write(bytes)
        return SourceResult(
            source = ImageSource(buffer, options.context),
            mimeType = "image/jpeg",
            dataSource = DataSource.DISK
        )
    }

    class Factory : Fetcher.Factory<RemotePhoto> {
        override fun create(
            data: RemotePhoto,
            options: Options,
            imageLoader: ImageLoader,
        ): Fetcher {
            return LocalThumbnailFetcher(data, options)
        }
    }
}
