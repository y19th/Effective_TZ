package com.y19th.core.data.models

internal interface Transformable<out O : Any> {

    fun transform(): O
}