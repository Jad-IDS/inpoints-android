package com.ids.inpoint.controller.Adapters


import com.ids.inpoint.model.response.ResponseBranch



import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.ids.inpoint.R
import com.ids.inpoint.controller.Adapters.RVOnItemClickListener.Action
import com.ids.inpoint.controller.Adapters.RVOnItemClickListener.RVOnItemClickListener
import com.ids.inpoint.custom.CustomTextViewBold
import com.ids.inpoint.custom.CustomTextViewMedium
import com.ids.inpoint.model.ItemRectangularCard
import com.ids.inpoint.model.response.ResponseOpeningHour
import com.ids.inpoint.model.response.ResponseStartupProduct
import java.util.*


class AdapterOpeningHours(private val context: Context, val items: ArrayList<ResponseOpeningHour>,
                             private val itemClickListener: RVOnItemClickListener
) :
    RecyclerView.Adapter<AdapterOpeningHours.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(com.ids.inpoint.R.layout.item_startup_product, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvTitle.text = items[position].day
        holder.tvSubTitle1.text = items[position].fromTime +" - "+items[position].toTime
        //holder.tvSubTitle2.text = items[position].subtitle2


    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var tvTitle = itemView.findViewById(com.ids.inpoint.R.id.tvTitle) as CustomTextViewBold
        var tvSubTitle1 =itemView.findViewById(com.ids.inpoint.R.id.tvSubTitle1) as CustomTextViewMedium
        val tvSubTitle2 =itemView.findViewById(com.ids.inpoint.R.id.tvSubTitle2) as CustomTextViewMedium

        val btView =itemView.findViewById(com.ids.inpoint.R.id.btView) as ImageView
        val ivIcon =itemView.findViewById(com.ids.inpoint.R.id.ivIcon) as ImageView


        val btEdit = itemView.findViewById(com.ids.inpoint.R.id.btEdit) as ImageView
        val btDelete = itemView.findViewById(com.ids.inpoint.R.id.btDelete) as ImageView

        init {

            btEdit.id=R.id.btEditB
            btDelete.id=R.id.btDeleteB
            itemView.setOnClickListener(this)
            btEdit.setOnClickListener(this)
            btDelete.setOnClickListener(this)
            btEdit.visibility=View.GONE

            btView.visibility=View.GONE
        }

        override fun onClick(v: View) {
            itemClickListener.onItemClicked(v, layoutPosition)
        }
    }
}
