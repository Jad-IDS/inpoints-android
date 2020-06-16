package com.ids.inpoint.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.ids.inpoint.model.comments
import java.util.ArrayList

class ResponsePost {

    @SerializedName("Id")
    @Expose
    var id: Int? = null
    @SerializedName("Title")
    @Expose
    var title: String? = null
    @SerializedName("Type")
    @Expose
    var type: Int? = null
    @SerializedName("Details")
    @Expose
    var details: String? = null
    @SerializedName("PublishDate")
    @Expose
    var publishDate: String? = null
    @SerializedName("Time")
    @Expose
    var time: String? = null
    @SerializedName("Language")
    @Expose
    var language: Any? = null
    @SerializedName("ViewNumber")
    @Expose
    var viewNumber: Int? = null
    @SerializedName("LikeNumber")
    @Expose
    var likeNumber: Int? = null
    @SerializedName("CommentNumber")
    @Expose
    var commentNumber: Int? = null



    @SerializedName("Verified")
    @Expose
    var verified: Boolean? = null
    @SerializedName("UserId")
    @Expose
    var userId: Int? = null
    @SerializedName("UserName")
    @Expose
    var userName: String? = null
    @SerializedName("Image")
    @Expose
    var image: String? = null
    @SerializedName("NumberOfFollowers")
    @Expose
    var numberOfFollowers: Int? = null
    @SerializedName("Level")
    @Expose
    var level: Int? = 0
    @SerializedName("Points")
    @Expose
    var points: Int? = null
    @SerializedName("Badges")
    @Expose
    var badges: Int? = null
    @SerializedName("DivType")
    @Expose
    var divType: Int? = null
    @SerializedName("ShowInTimeLine")
    @Expose
    var showInTimeLine: Boolean? = null
    @SerializedName("Color")
    @Expose
    var color: String? = null
    @SerializedName("ColorHex")
    @Expose
    var colorHex: String? = null
    @SerializedName("Liked")
    @Expose
    var liked: Boolean? = null
    @SerializedName("Followed")
    @Expose
    var followed: Boolean? = null
    @SerializedName("IsPublic")
    @Expose
    var isPublic: Boolean? = null
    @SerializedName("TeamUserId")
    @Expose
    var teamUserId: Int? = null
    @SerializedName("Location")
    @Expose
    var location: String? = null


    @SerializedName("CanQuit")
    @Expose
    var CanQuit: Int? = 0


    @SerializedName("StartupUserId")
    @Expose
    var StartupUserId: Int? = null

    @SerializedName("SuperAdmin")
    @Expose
    var SuperAdmin: Boolean? = null

    @SerializedName("Shared")
    @Expose
    var Shared: Boolean? =false


    @SerializedName("SharedPostId")
    @Expose
    var SharedPostId: Int? = 0


    @SerializedName("SharedPostUserId")
    @Expose
    var SharedPostUserId: Int? = 0



    @SerializedName("SharedPostUserImage")
    @Expose
    var SharedPostUserImage: String? = ""


    @SerializedName("SharedPostUserName")
    @Expose
    var SharedPostUserName: String? = ""

    @SerializedName("ShareLink")
    @Expose
    var ShareLink: String? = ""




    @SerializedName("JobTypeId")
    @Expose
    var JobTypeId: Int? = 0
    @SerializedName("ContactInfo")
    @Expose
    var ContactInfo: String? = ""
    @SerializedName("CompanyName")
    @Expose
    var CompanyName: String? = ""
    @SerializedName("RequestTypeId")
    @Expose
    var RequestTypeId:  Int? = 0
    @SerializedName("RequestDescription")
    @Expose
    var RequestDescription: String? = ""
    @SerializedName("JobTypeNameEn")
    @Expose
    var JobTypeNameEn: String? = ""
    @SerializedName("JobTypeNameAr")
    @Expose
    var JobTypeNameAr: String? = ""
    @SerializedName("RequestTypeNameEn")
    @Expose
    var RequestTypeNameEn: String? = ""
    @SerializedName("RequestTypeNameAr")
    @Expose
    var RequestTypeNameAr: String? = ""
    @SerializedName("Links")
    @Expose
    var Links: String? = ""
    @SerializedName("ArticleTypeId")
    @Expose
    var ArticleTypeId:  Int? = 0
    @SerializedName("ArticleTypeNameEn")
    @Expose
    var ArticleTypeNameEn: String? = ""
    @SerializedName("ArticleTypeNameAr")
    @Expose
    var ArticleTypeNameAr: String? = ""


    @SerializedName("PostTypeEn")
    @Expose
    var PostTypeEn: String? = ""
    @SerializedName("PostTypeAr")
    @Expose
    var PostTypeAr: String? = ""


    @SerializedName("Medias")
    @Expose
    var medias: List<Media>? = null
    @SerializedName("EventDates")
    @Expose
    var eventDates: List<EventDate>? = null


    var showComments: Boolean? = false
    var settingsViewVisible: Boolean? = false
    var isShowMore: Boolean? = false
    var isParticipant: Int? = 0
    var arrayComments: ArrayList<ResponseComments>? = arrayListOf()
    var sharedPost: ResponseSharePost? = ResponseSharePost()

    constructor()
}