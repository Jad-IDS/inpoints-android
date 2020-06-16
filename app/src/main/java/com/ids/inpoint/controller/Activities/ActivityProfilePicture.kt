package com.ids.inpoint.controller.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.ids.inpoint.R
import java.util.ArrayList

class ActivityProfilePicture : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_profile_image)
       var  ImageView = findViewById(R.id.image_place_holder) as ImageView

        var image_url = intent.getSerializableExtra("profile_pic") as String


        Glide.with(ImageView!!.context).load(image_url).into(ImageView!!)


    }

}