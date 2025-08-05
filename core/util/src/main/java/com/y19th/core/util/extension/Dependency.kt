package com.y19th.core.util.extension

import android.content.Context
import com.y19th.core.util.di.DependencyCollector
import org.koin.core.component.get

fun DependencyCollector.context(): Context = get()