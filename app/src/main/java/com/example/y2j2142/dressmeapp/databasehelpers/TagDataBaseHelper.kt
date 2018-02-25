package com.example.y2j2142.dressmeapp.databasehelpers

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.y2j2142.dressmeapp.model.Tag
import org.jetbrains.anko.db.*

class TagRowParser : RowParser<Tag>
{
    override fun parseRow(columns: Array<Any?>): Tag {
        return Tag(id = columns[0] as Long,
                category = columns[1] as String,
                name = columns[2] as String,
                weight = columns[3] as Long ,
                imagePath = columns[4] as String)
    }
}


class TagDataBaseHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "MyDatabase", null, 1) {
    companion object {
        private var instance: TagDataBaseHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): TagDataBaseHelper {
            if (instance == null) instance = TagDataBaseHelper(ctx.applicationContext)
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables
        db.createTable(Tag.TABLE_NAME, true,
                Tag.COLUMN_ID to INTEGER + PRIMARY_KEY + UNIQUE,
                Tag.CATEGORY to TEXT,
                Tag.NAME to TEXT,
                Tag.WEIGHT to INTEGER,
                Tag.IMAGE_PATH to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable(Tag.TABLE_NAME, true)
    }

    fun getAllTags(): List<Tag>
    {
        val db = readableDatabase
        val rowParser = TagRowParser()
        var tagList:MutableList<Tag> = mutableListOf()
        db.select(Tag.TABLE_NAME).exec({
            tagList = parseList(rowParser).toMutableList()
        })
        return tagList
    }

    fun addTag(t: Tag )
    {
        val db = writableDatabase
        db.insert(Tag.TABLE_NAME,
            Tag.COLUMN_ID to t.id,
                Tag.WEIGHT to t.weight,
                Tag.NAME to t.name,
                Tag.CATEGORY to t.category,
                Tag.IMAGE_PATH to t.imagePath)
    }

    fun removeTag(id:Long)
    {
        val db =writableDatabase
        db.delete(Tag.TABLE_NAME, "id = $id")
    }
}



// Access property for Context
val Context.database: TagDataBaseHelper
    get() = TagDataBaseHelper.getInstance(applicationContext)