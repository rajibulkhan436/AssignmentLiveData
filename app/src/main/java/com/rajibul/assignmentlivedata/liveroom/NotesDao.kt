package com.rajibul.assignmentlivedata.liveroom

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NotesDao {
    @Insert
    suspend fun insertNotes(notesEntity: NotesEntity)

    @Query("SELECT * FROM NotesEntity")
    fun getNotes(): LiveData<List<NotesEntity>>
}