package com.example.studyprogressxp.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [SkillEntity::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun skillDao(): SkillDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(db: SupportSQLiteDatabase) {

                db.execSQL("""
            CREATE TABLE skills_new (
                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                name TEXT NOT NULL,
                imagePath TEXT,
                xp INTEGER NOT NULL,
                level INTEGER NOT NULL,
                dailyGoalMinutes INTEGER NOT NULL,
                streakDays INTEGER NOT NULL
            )
        """)

                db.execSQL("""
            INSERT INTO skills_new (id, name, imagePath, xp, level, dailyGoalMinutes, streakDays)
            SELECT 
                id,
                name,
                imagePath,
                xp,
                1,
                0,
                0
            FROM skills
        """)

                db.execSQL("DROP TABLE skills")
                db.execSQL("ALTER TABLE skills_new RENAME TO skills")
            }
        }

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_db"
                )
                    .addMigrations(MIGRATION_2_3)
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}