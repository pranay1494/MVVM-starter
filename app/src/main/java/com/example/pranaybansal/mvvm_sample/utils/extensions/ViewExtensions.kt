package com.example.pranaybansal.mvvm_sample.utils.extensions

import android.app.Activity
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

fun View.setVisible(isVisible : Boolean){
    this.visibility = if(isVisible) View.VISIBLE else View.GONE
}

fun<T> ImageView.loadImage(resourseId:T){
    Glide.with(context)
            .load(resourseId)
            .into(this)
}

fun Toast.display(activity: Activity?, msg : String, isLong : Boolean){
    Toast.makeText(activity,msg,if (isLong)Toast.LENGTH_LONG else Toast.LENGTH_SHORT).show()
}

fun Snackbar.setVisible(isVisible: Boolean?) {
    if(isVisible != true) this.show() else this.dismiss()
}

fun String.sayHi(){

}