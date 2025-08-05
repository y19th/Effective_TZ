package com.y19th.feature.authenticate.ui

import android.content.Context
import android.content.Intent
import android.util.Patterns
import androidx.core.net.toUri
import com.arkivanov.decompose.ComponentContext
import com.y19th.core.util.di.DependencyCollector
import com.y19th.core.util.extension.activity
import com.y19th.dextension.core.ScreenComponent
import com.y19th.feature.authenticate.logic.AuthenticateEvents
import com.y19th.feature.authenticate.logic.AuthenticateState
import org.koin.core.component.get


internal class AuthenticateComponent(
    componentContext: ComponentContext
) : ScreenComponent<AuthenticateState, AuthenticateEvents>(
    componentContext = componentContext,
    initialState = AuthenticateState()
) {
    private val context: Context by lazy { DependencyCollector.get() }

    override fun handleEvent(event: AuthenticateEvents) {
        when (event) {
            is AuthenticateEvents.OnEmailChanged -> {
                update {
                    copy(
                        email = email.update(
                            value = event.newValue,
                            isError = !Patterns.EMAIL_ADDRESS.matcher(event.newValue).matches()
                        )
                    )
                }

                calculateValid()
            }

            is AuthenticateEvents.OnPasswordChanged -> {
                update {
                    copy(
                        password = password.update(
                            value = event.newValue,
                            isError = event.newValue.isEmpty()
                        )
                    )
                }

                calculateValid()
            }

            AuthenticateEvents.OnValidateAuthenticate -> {

            }

            AuthenticateEvents.OnOkClicked -> {
                startBrowserActivity("https://ok.ru/")
            }

            AuthenticateEvents.OnVkClicked -> {
                startBrowserActivity("https://vk.com/")
            }
        }
    }

    private fun startBrowserActivity(uri: String) {
        context.activity.startActivity(Intent(Intent.ACTION_VIEW, uri.toUri()))
    }

    private fun calculateValid() {
        update {
            copy(
                valid = (!email.isError && email.value.isNotEmpty()) && (!password.isError && password.value.isNotEmpty())
            )
        }
    }
}