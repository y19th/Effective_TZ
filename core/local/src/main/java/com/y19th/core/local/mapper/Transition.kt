package com.y19th.core.local.mapper

import com.y19th.core.domain.models.transition.Transition
import com.y19th.core.local.entities.TransitionEntity
import com.y19th.core.resources.models.Stage


internal fun Transition.toTransitionEntity() = TransitionEntity(stage = stage.value)

internal fun TransitionEntity.toTransition() = Transition(stage = Stage.find(stage))