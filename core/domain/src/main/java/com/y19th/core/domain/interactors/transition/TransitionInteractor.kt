package com.y19th.core.domain.interactors.transition

import com.y19th.core.resources.models.Stage

interface TransitionInteractor {

    suspend fun getStage(): Stage

    suspend fun update(stage: Stage)
}