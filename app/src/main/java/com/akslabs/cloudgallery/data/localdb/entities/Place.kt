package com.akslabs.cloudgallery.data.localdb.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "places")
data class Place(
    @PrimaryKey val id: Int,
    val name: String,
    val city: String?,
    val state: String?,
    val country: String?,
    val lat: Double?,
    val lon: Double?,
    val photoCount: Int
)
