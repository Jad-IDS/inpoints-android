package com.ids.inpoint.controller.Activities

import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.widget.GridLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import com.ids.inpoint.R
import com.ids.inpoint.controller.Adapters.AdapterTeamFiles
import com.ids.inpoint.controller.Adapters.AdapterTeamFolders
import com.ids.inpoint.controller.Adapters.RVOnItemClickListener.RVOnItemClickListener
import com.ids.inpoint.controller.Base.AppCompactBase
import com.ids.inpoint.controller.MyApplication
import com.ids.inpoint.controller.MyApplication.Companion.arrayFolders
import com.ids.inpoint.custom.player.interfaces.VideoViewContract
import com.ids.inpoint.model.response.ResponseFolders
import com.ids.inpoint.model.response.ResponseTeamFile
import com.ids.inpoint.utils.AppHelper
import com.ids.inpoint.utils.RetrofitClientAuth
import com.ids.inpoint.utils.RetrofitInterface
import kotlinx.android.synthetic.main.activity_team_create_folder.*

import kotlinx.android.synthetic.main.loading_trans.*
import kotlinx.android.synthetic.main.toolbar_general.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


class ActivityTeamCreateFolder : AppCompactBase(),RVOnItemClickListener {
    override fun onItemClicked(view: View, position: Int) {
        when {
            view.id == R.id.btEdit -> {
                editFolder(adapterFolders.arrayFiles[position].id!!, position)
            }
            view.id == R.id.btDelete -> {
                deletedFolder(adapterFolders.arrayFiles[position].id!!, position)
            }
        }
    }


    private lateinit var fragmentManager: FragmentManager
    var arrayFilteredFolders=java.util.ArrayList<ResponseFolders>()
    lateinit var adapterFolders: AdapterTeamFolders
    var folderId=0
    var folderName=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.ids.inpoint.R.layout.activity_team_create_folder)
        init()
        getFolders()

    }


    private fun init() {
        supportActionBar!!.hide()
        fragmentManager = supportFragmentManager

        btSave.setOnClickListener{
            if(etFolderName.text.toString().isEmpty())
                AppHelper.createDialog(this,getString(R.string.enter_folder_name))
            else
                createFolder(etFolderName.text.toString())
        }

        btBack.setOnClickListener{
            super.onBackPressed()
        }

        etSearchFolder!!.addTextChangedListener(object:
            TextWatcher {override fun afterTextChanged(s: Editable?) {

        }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                filterFolder(s.toString())
            }

        })

    }
    private fun filterFolder(word:String){
        if(arrayFolders.size>0 && word.isNotEmpty()){
            btClose.visibility=View.VISIBLE
            arrayFilteredFolders.clear()
            for(i in arrayFolders.indices){
                if(arrayFolders[i].FolderName!!.contains(word) )
                    arrayFilteredFolders.add(arrayFolders[i])
            }
        }else {
            arrayFilteredFolders.clear()
            btClose.visibility=View.GONE
            arrayFilteredFolders.addAll(arrayFolders)
        }
        try{ adapterFolders.notifyDataSetChanged()}catch (e:Exception){}
    }



    private fun getFolders(){

        RetrofitClientAuth.client?.create(RetrofitInterface::class.java)
            ?.getFolders(
            )?.enqueue(object : Callback<ArrayList<ResponseFolders>> {
                override fun onResponse(call: Call<ArrayList<ResponseFolders>>, response: Response<ArrayList<ResponseFolders>>) {
                    try{
                        setFolders(response.body())

                    }catch (E: Exception){
                        Log.wtf("exception",E.toString())
                    }
                }
                override fun onFailure(call: Call<ArrayList<ResponseFolders>>, throwable: Throwable) {
                }
            })
    }


    private fun setFolders(body: ArrayList<ResponseFolders>?) {
        try {
            arrayFilteredFolders.clear()
            arrayFilteredFolders.addAll(body!!)


            arrayFolders.clear()
            arrayFolders.addAll(body)
        }catch (e:Exception){}



        adapterFolders = AdapterTeamFolders(arrayFilteredFolders, this, 1)
        val glm = GridLayoutManager(this, 1)
        rvFolders.adapter = adapterFolders
        rvFolders.layoutManager = glm
    }


    private fun editFolder(id:Int,position: Int){
        val builder = AlertDialog.Builder(this)
        val edittext = EditText(this)
        edittext.setSingleLine();
        edittext.setBackgroundResource(R.drawable.bg_recangular_border_gray)
        edittext.setText(adapterFolders!!.arrayFiles[position].FolderName)
        edittext.setPadding(20,20,20,20)
        var params =
            FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params.leftMargin=20
        params.rightMargin=20
        params.topMargin=10
        params.bottomMargin=10

        //  AppHelper.setMargins(this,edittext,120,80,120,80)
        edittext.layoutParams=params
        builder.setView(edittext)
        builder
            .setMessage("Edit Folder")
            .setCancelable(true)
            .setNegativeButton(getString(R.string.cancel)) {
                    dialog, _ -> dialog.cancel()
            }
            .setPositiveButton(getString(R.string.save_changes)) { dialog, _ ->
                if(edittext.text.toString().isNotEmpty()) {
                    folderId=id
                    folderName=edittext.text.toString()
                    sendEditFolder(adapterFolders.arrayFiles[position].FolderName!!,folderName)
                    dialog.cancel()
                }else{
                    Toast.makeText(applicationContext,getString(R.string.file_name_required), Toast.LENGTH_LONG).show()
                }
            }
        val alert = builder.create()
        alert.show()
    }


    private fun deletedFolder(id:Int,position: Int){
        val builder = AlertDialog.Builder(this)
        builder
            .setMessage(getString(R.string.delete_confirmation)+" \n "+ adapterFolders!!.arrayFiles[position].FolderName)
            .setCancelable(true)
            .setNegativeButton(getString(R.string.no)) {
                    dialog, _ -> dialog.cancel()
            }
            .setPositiveButton(getString(R.string.yes)) { dialog, _ ->
                sendDeleteFolder(position,adapterFolders.arrayFiles[position].FolderName!!)
                dialog.cancel()
            }
        val alert = builder.create()
        alert.show()
    }



    private fun sendDeleteFolder(position: Int,folderName:String){
        loading.visibility=View.VISIBLE
        RetrofitClientAuth.client?.create(RetrofitInterface::class.java)
            ?.deleteFolder(
                folderName
            )?.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    try{
                        loading.visibility=View.GONE
                        if(response.isSuccessful){
                            arrayFilteredFolders.removeAt(position)
                            adapterFolders.notifyDataSetChanged()
                        }else{
                            //  AppHelper.createDialog(this@ActivityTeamFiles,response.errorBody()!!.string().replace("\"", ""))
                            AppHelper.createDialog(this@ActivityTeamCreateFolder,getString(R.string.cannot_delete_folder))

                        }


                    }catch (E: Exception){
                        AppHelper.createDialog(this@ActivityTeamCreateFolder,getString(R.string.cannot_delete_folder))

                    }
                }
                override fun onFailure(call: Call<Void>, throwable: Throwable) {
                    loading.visibility=View.GONE
                }
            })
    }


    private fun sendEditFolder(oldName:String,newName:String){
        loading.visibility=View.VISIBLE
        RetrofitClientAuth.client?.create(RetrofitInterface::class.java)
            ?.renameFolder(
                oldName,
                newName
            )?.enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    try{
                        loading.visibility=View.GONE
                        if(response.body()!!.isNotEmpty()){
                            AppHelper.createDialog(this@ActivityTeamCreateFolder,response.body()!!)


                        }else{
                            //  AppHelper.createDialog(this@ActivityTeamFiles,response.errorBody()!!.string().replace("\"", ""))
                            getFolders()
                        }


                    }catch (E: Exception){
                        AppHelper.createDialog(this@ActivityTeamCreateFolder,getString(R.string.cannot_delete_image))

                    }
                }
                override fun onFailure(call: Call<String>, throwable: Throwable) {
                    loading.visibility=View.GONE
                }
            })
    }


    private fun createFolder(folderName: String){
        loading.visibility=View.VISIBLE
        RetrofitClientAuth.client?.create(RetrofitInterface::class.java)
            ?.creatFolder(
                folderName
            )?.enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    try{
                        loading.visibility=View.GONE
                        if(response.body()!!.isEmpty()){
                            getFolders()
                        }else{
                            //  AppHelper.createDialog(this@ActivityTeamFiles,response.errorBody()!!.string().replace("\"", ""))
                            AppHelper.createDialog(this@ActivityTeamCreateFolder,response.body()!!)

                        }


                    }catch (E: Exception){
                        AppHelper.createDialog(this@ActivityTeamCreateFolder,getString(R.string.cannot_delete_image))

                    }
                }
                override fun onFailure(call: Call<String>, throwable: Throwable) {
                    loading.visibility=View.GONE
                }
            })
    }
}

