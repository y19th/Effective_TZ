package com.y19th.feature.authenticate.logic

import com.y19th.dextension.core.BaseState
import com.y19th.dextension.extensions.property.Stateful
import com.y19th.dextension.extensions.property.statefulProperty

internal data class AuthenticateState(
	val isLoading: Boolean = false,
	val email: Stateful<String> = statefulProperty(""),
	val password: Stateful<String> = statefulProperty(""),
	val valid: Boolean = false
): BaseState