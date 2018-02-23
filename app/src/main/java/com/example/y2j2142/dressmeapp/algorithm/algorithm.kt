package com.example.y2j2142.dressmeapp.algorithm

import com.example.y2j2142.dressmeapp.model.Clothing
import com.example.y2j2142.dressmeapp.model.Tag
import java.util.*


fun getClothesByCategory(type:String, wardrobe:List<Clothing>) = wardrobe.filter { it.category == type }

fun getClothesByTag(tag:String, wardrobe: List<Clothing>) = wardrobe.filter { it.tags.contains( Tag(name = tag )) }

fun getWear(category:String, wardrobe: List<Clothing>, tags:List<Tag>): Clothing
{
    var wearList = getClothesByCategory(category, wardrobe)

    tags
            .asSequence()
            .map { t -> wearList.filter { t in it.tags } }
            .forEach { wearList = if (it.isNotEmpty()) it else wearList }
    val random = Random()
    return wearList[(random.nextInt(wearList.size))]
}

fun getClothesAmount(wardrobe: List<Clothing>, category: String) = getClothesByCategory(category, wardrobe).size