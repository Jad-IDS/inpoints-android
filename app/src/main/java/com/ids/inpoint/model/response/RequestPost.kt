package com.ids.inpoint.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class RequestPost {
    @SerializedName("Id")
    var Id : Int? = null

    @SerializedName("Title")
    var Title : String? = null

    @SerializedName("Type")
    var Type  : Int? = null

    @SerializedName("Details")
    var Details : String? = null

    @SerializedName("PublishDate")
    var PublishDate : String? = null

    @SerializedName("UserId")
    var UserId : Int? = null

    @SerializedName("DivType")
    var DivType : Int? = null

    @SerializedName("ShowInTimeLine")
    var ShowInTimeLine  : Boolean? = null

    @SerializedName("Medias")
    var Medias  : List<RequestMedia>? = null


    @SerializedName("JobTypeId")
    var jobTypeId : Int? = null
    @SerializedName("RequestTypeId")
    var requestTypeId : Int? = null
    @SerializedName("ArticleTypeId")
    var articleTypeId : Int? = null
    @SerializedName("ContactInfo")
    var ContactInfo : String? = null
    @SerializedName("CompanyName")
    var CompanyName : String? = null
    @SerializedName("RequestDescription")
    var RequestDescription : String? = null
    @SerializedName("JobTypeNameEn")
    var JobTypeNameEn : String? = null
    @SerializedName("JobTypeNameAr")
    var JobTypeNameAr : String? = null
    @SerializedName("RequestTypeNameEn")
    var RequestTypeNameEn : String? = null
    @SerializedName("RequestTypeNameAr")
    var RequestTypeNameAr : String? = null
    @SerializedName("Links")
    var Links : String? = null
    @SerializedName("ArticleTypeNameEn")
    var ArticleTypeNameEn : String? = null
    @SerializedName("ArticleTypeNameAr")
    var ArticleTypeNameAr : String? = null






    constructor(
        Id: Int?,
        Title: String?,
        Type: Int?,
        Details: String?,
        PublishDate: String?,
        UserId: Int?,
        DivType: Int?,
        ShowInTimeLine: Boolean?,
        Medias: List<RequestMedia>?
    ) {
        this.Id = Id
        this.Title = Title
        this.Type = Type
        this.Details = Details
        this.PublishDate = PublishDate
        this.UserId = UserId
        this.DivType = DivType
        this.ShowInTimeLine = ShowInTimeLine
        this.Medias = Medias
    }

    constructor(
        Id: Int?,
        Title: String?,
        Type: Int?,
        Details: String?,
        PublishDate: String?,
        UserId: Int?,
        DivType: Int?,
        ShowInTimeLine: Boolean?,
        Medias: List<RequestMedia>?,
        jobTypeId: Int?,
        requestTypeId: Int?,
        articleTypeId: Int?,
        ContactInfo: String?,
        CompanyName: String?,
        RequestDescription: String?,
        JobTypeNameEn: String?,
        JobTypeNameAr: String?,
        RequestTypeNameEn: String?,
        RequestTypeNameAr: String?,
        Links: String?,
        ArticleTypeNameEn: String?,
        ArticleTypeNameAr: String?
    ) {
        this.Id = Id
        this.Title = Title
        this.Type = Type
        this.Details = Details
        this.PublishDate = PublishDate
        this.UserId = UserId
        this.DivType = DivType
        this.ShowInTimeLine = ShowInTimeLine
        this.Medias = Medias
        this.jobTypeId = jobTypeId
        this.requestTypeId = requestTypeId
        this.articleTypeId = articleTypeId
        this.ContactInfo = ContactInfo
        this.CompanyName = CompanyName
        this.RequestDescription = RequestDescription
        this.JobTypeNameEn = JobTypeNameEn
        this.JobTypeNameAr = JobTypeNameAr
        this.RequestTypeNameEn = RequestTypeNameEn
        this.RequestTypeNameAr = RequestTypeNameAr
        this.Links = Links
        this.ArticleTypeNameEn = ArticleTypeNameEn
        this.ArticleTypeNameAr = ArticleTypeNameAr
    }


}