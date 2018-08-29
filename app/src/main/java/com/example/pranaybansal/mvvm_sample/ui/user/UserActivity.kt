package com.example.pranaybansal.mvvm_sample.ui.user

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.pranaybansal.mvvm_sample.R
import com.example.pranaybansal.mvvm_sample.ViewModelProviderFactory
import com.example.pranaybansal.mvvm_sample.data.remote.ApiService
import com.example.pranaybansal.mvvm_sample.databinding.ActivityMainBinding
import com.example.pranaybansal.mvvm_sample.injection.DatabaseInfo
import com.example.pranaybansal.mvvm_sample.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Named

class UserActivity : BaseActivity() {

    val TAG = this.javaClass.simpleName

    lateinit var mViewModel : UserViewModel

    @field:Named("asd")
    @Inject
    lateinit var name : String

    @Inject
    lateinit var api : ApiService;

    @Inject
    lateinit var viewModelFactory : ViewModelProviderFactory

    lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getActivityComponent().inject(this)

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        mViewModel = ViewModelProviders.of(this,viewModelFactory).get(UserViewModel::class.java)

        mViewModel.getWelcomeMsg()

        btnSubmit.setOnClickListener {
            //showLoading("Loading...")
            mViewModel.getUserData(etName.text.toString())
        }

        mViewModel.welcomeMsg.observe(this, Observer {
            it?.let {
                showToast(it)
            }
        })

        mViewModel.fetchUserData.observe(this, Observer {
            it?.let {
               Log.d(TAG,it.name)
            }
        })
    }
}