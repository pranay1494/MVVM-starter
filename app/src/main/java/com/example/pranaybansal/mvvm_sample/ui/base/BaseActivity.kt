package com.example.pranaybansal.mvvm_sample.ui.base

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.pranaybansal.mvvm_sample.BuildConfig
import com.example.pranaybansal.mvvm_sample.MyApplication
import com.example.pranaybansal.mvvm_sample.injection.component.ActivityComponent
import com.example.pranaybansal.mvvm_sample.injection.component.DaggerActivityComponent

import com.example.pranaybansal.mvvm_sample.injection.module.ActivityModule
import com.example.pranaybansal.mvvm_sample.utils.DialogUtils
import com.example.pranaybansal.mvvm_sample.utils.NetworkUtils
import com.google.firebase.components.Component
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import javax.inject.Inject
import javax.inject.Named

open class BaseActivity : AppCompatActivity(), BaseView {

    private lateinit var mActivityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeDagger()
        if (BuildConfig.DEBUG)
            AppCenter.start(application, "89a08374-e6bd-47fa-8a24-7ded496e9e61", Analytics::class.java, Crashes::class.java)
        else
            AppCenter.start(application, "ccf43fd5-7cf6-42d0-8c2b-def2e17a96a8", Analytics::class.java, Crashes::class.java)
    }

    private fun initializeDagger() {
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .applicationComponent((application as MyApplication).getApplictionComponent())
                .build()
    }

    fun getActivityComponent(): ActivityComponent {
        return mActivityComponent
    }

    override fun showLoading(context: Context, message: String) {
        DialogUtils.displayProgressDialog(context, message)
    }

    override fun hideLoading() {
        DialogUtils.cancelProgressDialog()
    }

    override fun showToast(@StringRes resId: Int) {
        showToast(getString(resId))
    }

    override fun isNetworkConnected(): Boolean {
        return NetworkUtils.isNetworkConnected(applicationContext)
    }

    override fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    override fun showToast(message: String?) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Some Error", Toast.LENGTH_SHORT).show()
        }
    }

    override fun invalidAuthCode() {
        Toast.makeText(this, "Invalid Authcode", Toast.LENGTH_SHORT).show()
    }
}