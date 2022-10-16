package com.rkhvstnv.testdeliveryhs.utils

import android.content.Context
import android.util.TypedValue
import android.widget.ImageView
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineExceptionHandler


fun ImageView.loadImage(path: String){
    Glide.with(context).load(path).centerCrop().into(this)
}
fun ImageView.loadImage(@DrawableRes drawable: Int){
    Glide.with(context).load(drawable).centerCrop().into(this)
}

fun Context.getAttrColor(
    @AttrRes attrColor: Int,
    typedValue: TypedValue = TypedValue(),
    resolveRef: Boolean = true
): Int {
    theme.resolveAttribute(attrColor, typedValue, resolveRef)
    return typedValue.data
}

val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
    throwable.printStackTrace()
}