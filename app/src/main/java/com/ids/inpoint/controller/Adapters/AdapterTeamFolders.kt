package com.ids.inpoint.controller.Adapters


import android.widget.ImageView
import android.widget.TextView


import com.ids.inpoint.model.ItemSpinner


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SpinnerAdapter
import com.ids.inpoint.R
import com.ids.inpoint.controller.Adapters.RVOnItemClickListener.RVOnItemClickListener
import com.ids.inpoint.controller.MyApplication
import com.ids.inpoint.custom.CustomTextViewMedium
import com.ids.inpoint.model.response.ResponseFolders

import com.ids.inpoint.model.response.ResponseTeamFile
import com.ids.inpoint.utils.AppConstants
import com.ids.inpoint.utils.AppHelper
import java.lang.Exception


import java.util.*


class AdapterTeamFolders(val arrayFiles: ArrayList<ResponseFolders>, private val itemClickListener: RVOnItemClickListener,type:Int) :
    RecyclerView.Adapter<AdapterTeamFolders.VHprivacy>() {

    var fileType=type

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHprivacy {
        return VHprivacy(LayoutInflater.from(parent.context).inflate(com.ids.inpoint.R.layout.item_team_folders, parent, false))
    }

    override fun onBindViewHolder(holder: VHprivacy, position: Int) {

        try{ holder.tvFolderName.text=arrayFiles[position].FolderName}catch (e:Exception){}


/*        if(arrayFiles[position].userId==MyApplication.userLoginInfo.id){
            holder.btDelete.visibility=View.VISIBLE
            holder.btEdit.visibility=View.VISIBLE
        }else{
            holder.btDelete.visibility=View.GONE
            holder.btEdit.visibility=View.GONE
        }*/


    }

    override fun getItemCount(): Int {
        return arrayFiles.size
    }

    inner class VHprivacy(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var btEdit: ImageView = itemView.findViewById(com.ids.inpoint.R.id.btEdit) as ImageView
        var btDelete: ImageView = itemView.findViewById(com.ids.inpoint.R.id.btDelete) as ImageView

        var tvFolderName: TextView = itemView.findViewById(com.ids.inpoint.R.id.tvFolderName) as TextView





        init {
            itemView.setOnClickListener(this)
            btEdit.setOnClickListener(this)
            btDelete.setOnClickListener(this)
        }

        override fun onClick(v: View) {

            itemClickListener.onItemClicked(v, layoutPosition)
        }
    }
}
