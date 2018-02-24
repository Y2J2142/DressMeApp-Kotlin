package com.example.y2j2142.dressmeapp.adapters
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.y2j2142.dressmeapp.R
import com.example.y2j2142.dressmeapp.model.Clothing
import kotlinx.android.synthetic.main.clothing_adapter_row.view.*


class WardrobeClothingAdapter(var activity: Activity, var items: MutableList<Clothing>) : BaseAdapter()
{
    private class ViewHolder(view:View)
    {
        var name:TextView? = null

        init {
            name = view.ClothingName
        }

    }

    override fun getView(pos: Int, convertView: View?, p2: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder
        if(convertView == null)
        {
            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.clothing_adapter_row, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        }
        else
        {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var clothing = items[pos]
        viewHolder.name?.text = clothing.name

        return view as View
    }

    override fun getItem(index: Int): Any = items[index]

    override fun getItemId(pos: Int): Long = pos.toLong()

    override fun getCount(): Int = items.size

}