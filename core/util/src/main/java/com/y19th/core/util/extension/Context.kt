package com.y19th.core.util.extension

import android.content.Context
import android.content.ContextWrapper
import androidx.activity.ComponentActivity

@get:JvmName("CustomActivityGetter")
val Context.activity: ComponentActivity
    get() = getActivity() ?: throw NullPointerException("have no component activity")

private tailrec fun Context.getActivity(): ComponentActivity? = when(this) {
    is ComponentActivity -> this
    is ContextWrapper -> baseContext.getActivity()
    else -> null
}