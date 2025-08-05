package com.y19th.core.resources.models

enum class Stage(val value: Int) {
    Undefined(-1),
    NonAuthorized(0),
    Authorized(1);

    companion object {
        fun find(value: Int): Stage = when(value) {
            NonAuthorized.value -> NonAuthorized
            Authorized.value -> Authorized
            else -> Undefined
        }
    }
}