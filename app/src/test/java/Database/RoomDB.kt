package Database

import Dao.NoteDao
import Entity.NoteEntity
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version = 1)

abstract class RoomDB : RoomDatabase() {

    companion object {

        fun init(context: Context): RoomDB {

            var db = Room.databaseBuilder(context, RoomDB::class.java, "Note.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
            return db
        }

    }

    abstract fun note() : NoteDao

}