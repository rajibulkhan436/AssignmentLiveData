package com.rajibul.assignmentlivedata.liveroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rajibul.assignmentlivedata.R

@Database(version = 1, entities = [NotesEntity::class])
abstract class NotesDatabase:RoomDatabase() {
    abstract fun notesDao(): NotesDao

    companion object {
        private var notesDatabase: NotesDatabase? = null

        fun getDatabase(context: Context): NotesDatabase {
            if (notesDatabase == null) {
                notesDatabase = Room.databaseBuilder(context,
                    NotesDatabase::class.java,
                    context.resources.getString(R.string.app_name)
                ).build()
            }
            return notesDatabase!!

        }
    }
}