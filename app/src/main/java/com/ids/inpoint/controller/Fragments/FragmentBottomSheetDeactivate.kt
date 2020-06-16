package com.ids.inpoint.controller.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.R
import android.content.Intent
import android.support.annotation.Nullable
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v4.app.DialogFragment
import android.util.Log
import android.widget.Toast
import com.ids.inpoint.controller.Activities.ActivityLogin
import com.ids.inpoint.model.response.ResponseSaveComment
import com.ids.inpoint.utils.AppConstants
import com.ids.inpoint.utils.JsonParameters
import com.ids.inpoint.utils.RetrofitClientAuth
import com.ids.inpoint.utils.RetrofitInterface
import kotlinx.android.synthetic.main.bottom_sheet_deactivate.*
import kotlinx.android.synthetic.main.loading_trans.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FragmentBottomSheetNotification : BottomSheetDialogFragment(){

    var permanent : Boolean = false
    var success : Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(com.ids.inpoint.R.layout.bottom_sheet_deactivate, container, false)


    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL,com.ids.inpoint.R.style.CustomBottomSheetDialogTheme)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()




    }
    fun init() {

        cbDeactivateTemporary.isChecked = true

        cbDeactivateFully.setOnClickListener {

            permanent = true
            cbDeactivateTemporary.isChecked = false
        }
        cbDeactivateTemporary.setOnClickListener {

            permanent = false
            cbDeactivateFully.isChecked = false

        }

        btCancelBottom.setOnClickListener {
            dismiss()
        }

        btDeactivateAssured.setOnClickListener {
            Deactivate(permanent)
        }

    }

    private fun Deactivate(permanent: Boolean){

       /// loading.visibility= View.VISIBLE
        RetrofitClientAuth.client?.create(RetrofitInterface::class.java)
            ?.DeactivateAccount(permanent)?.enqueue(object : Callback<Boolean> {
                override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                    try{
                        success = response.body()!!


                        if(success){

                            Toast.makeText(activity, "Success", Toast.LENGTH_LONG)
                            dismiss()
                            startActivity(Intent(activity!!, ActivityLogin::class.java))
                            activity!!.finish()


                        }
                        else{
                            Toast.makeText(activity,"Failure",Toast.LENGTH_LONG)
                        }
                    }catch (E:Exception){


                    }
                }
                override fun onFailure(call: Call<Boolean>, throwable: Throwable) {
                  //  loading.visibility=View.GONE
                    Toast.makeText(activity,"failed", Toast.LENGTH_LONG).show()
                }
            })

     //   loading.visibility= View.GONE




    }


}