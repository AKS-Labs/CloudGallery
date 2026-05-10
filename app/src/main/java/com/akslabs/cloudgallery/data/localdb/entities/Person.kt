package com.akslabs.cloudgallery.data.localdb.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "people")
data class Person(
    @PrimaryKey val id: Int,
    val name: String?,
    val photoCount: Int,
    val faceSampleRemoteId: String?
)
