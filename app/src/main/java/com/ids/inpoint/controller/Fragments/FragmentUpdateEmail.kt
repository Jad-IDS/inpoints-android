package com.ids.inpoint.controller.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import com.ids.inpoint.R
import com.ids.inpoint.controller.Adapters.RVOnItemClickListener.RVOnItemClickListener
import com.ids.inpoint.controller.MyApplication
import com.ids.inpoint.utils.AppHelper
import com.ids.inpoint.utils.RetrofitClientAuth
import com.ids.inpoint.utils.RetrofitInterface
import kotlinx.android.synthetic.main.fragment_update_email.*
import kotlinx.android.synthetic.main.fragment_update_password.*
import kotlinx.android.synthetic.main.fragment_update_password.btBack
import kotlinx.android.synthetic.main.fragment_update_password.btSaveChanges
import kotlinx.android.synthetic.main.fragment_update_password.etNewPassword
import kotlinx.android.synthetic.main.fragment_update_password.etVerifyPassword
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class FragmentUpdateEmail: Fragment() , RVOnItemClickListener {



    override fun onItemClicked(view: View, position: Int) {
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(com.ids.inpoint.R.layout.fragment_update_email, container, false)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setlisteners()
    }

    private fun init(){


    }

    private fun setlisteners(){
        btBack.setOnClickListener{activity!!.onBackPressed()}
        btSaveChanges.setOnClickListener{
            getActivity()!!.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
            updateEmail()}
    }

    private fun updateEmail(){
        if(etOldEmail.text.toString().isEmpty() || etNewEmail.text.toString().isEmpty() || etPassword.text.toString().isEmpty())
            Toast.makeText(activity,getString(R.string.check_empty_fields), Toast.LENGTH_LONG).show()
        else if(!AppHelper.isValidEmail(etNewEmail.text.toString()))
            Toast.makeText(activity,getString(R.string.enter_valid_email),Toast.LENGTH_LONG).show()
        else
            callUpdateEmail(etNewEmail.text.toString(),etPassword.text.toString(),etOldEmail.text.toString())
    }

    private fun callUpdateEmail(new:String , pass : String , old : String ){
        RetrofitClientAuth.client?.create(RetrofitInterface::class.java)
            ?.updateEmail(new,pass,old)?.enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    try{
                        if(response.body()==etNewEmail.text.toString()) {
                            Toast.makeText(activity, getString(R.string.email_updated), Toast.LENGTH_LONG).show()
                            activity!!.onBackPressed()
                        }else
                            AppHelper.createDialog(activity!!,response.body()!!)
                    }catch (E: Exception){ }
                }
                override fun onFailure(call: Call<String>, throwable: Throwable) {
                    Toast.makeText(activity,getString(R.string.failed), Toast.LENGTH_LONG).show()
                }
            })
    }




}