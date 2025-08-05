package com.y19th.feature.authenticate.ui

import android.content.Context
import android.content.Intent
import android.util.Patterns
import androidx.core.net.toUri
import com.arkivanov.decompose.ComponentContext
import com.y19th.core.domain.interactors.transition.TransitionInteractor
import com.y19th.core.navigation.navigators.root.RootConfiguration
import com.y19th.core.navigation.navigators.root.RootNavigator
import com.y19th.core.resources.models.Stage
import com.y19th.core.util.di.DependencyCollector
import com.y19th.core.util.extension.activity
import com.y19th.dextension.core.ScreenComponent
import com.y19th.dextension.extensions.coroutine.onLimitedDefault
import com.y19th.dextension.extensions.coroutine.withMain
import com.y19th.feature.authenticate.logic.AuthenticateEvents
import com.y19th.feature.authenticate.logic.AuthenticateState
import org.koin.core.component.get


internal class AuthenticateComponent(
    componentContext: ComponentContext,
    private val transitionInteractor: TransitionInteractor,
    private val navigator: RootNavigator
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
                scope.onLimitedDefault {
                    transitionInteractor.update(Stage.Authorized)
                    withMain { navigator.handleConfiguration(RootConfiguration.Home) }
                }
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