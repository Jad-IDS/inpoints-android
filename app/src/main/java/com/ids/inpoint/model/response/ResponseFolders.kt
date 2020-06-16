package com.ids.inpoint.model.response



import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseFolders {

    @SerializedName("Id")
    @Expose
    var id: Int? = null
    @SerializedName("FolderName")
    @Expose
    var FolderName: String? = null
    @SerializedName("FolderPath")
    @Expose
    var FolderPath: String? = null



}