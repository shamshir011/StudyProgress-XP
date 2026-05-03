package com.example.studyprogressxp.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [SkillEntity::class], version = 4, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun skillDao(): SkillDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        val MIGRATION_3_4 = object : Migration(3, 4) {
            override fun migrate(db: SupportSQLiteDatabase) {

                // 1. Create new table with EXACT schema
                db.execSQL("""
            CREATE TABLE skills_new (
                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                name TEXT NOT NULL,
                imagePath TEXT,
                xp INTEGER NOT NULL,
                level INTEGER NOT NULL,
                goal TEXT NOT NULL,
                streakDays INTEGER NOT NULL
            )
        """.trimIndent())

                // 2. Copy + transform old data
                db.execSQL("""
            INSERT INTO skills_new (id, name, imagePath, xp, level, goal, streakDays)
            SELECT 
                id,
                name,
                imagePath,
                xp,
                level,
                CASE 
                    WHEN dailyGoalMinutes = 30 THEN '30m'
                    WHEN dailyGoalMinutes = 60 THEN '1h'
                    WHEN dailyGoalMinutes = 120 THEN '2h'
                    ELSE '30m'
                END,
                0
            FROM skills
        """.trimIndent())

                // 3. Drop old table
                db.execSQL("DROP TABLE skills")

                // 4. Rename new table
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
                    .addMigrations(MIGRATION_3_4)
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}