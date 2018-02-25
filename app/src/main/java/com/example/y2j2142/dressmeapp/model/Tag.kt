package com.example.y2j2142.dressmeapp.model

data class Tag(val category:String = "", val name:String="", val weight: Long = 0, val id: Long = 0, val imagePath: String = "")
{
    companion object {
        const val COLUMN_ID = "id"
        const val TABLE_NAME = "tags"
        const val CATEGORY = "category"
        const val NAME = "name"
        const val WEIGHT = "weight"
        const val IMAGE_PATH = "image_path"
    }

}