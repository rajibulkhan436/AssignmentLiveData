package com.rajibul.assignmentlivedata.liveroom

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NotesEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String? = null,
    var description: String? = null
)
