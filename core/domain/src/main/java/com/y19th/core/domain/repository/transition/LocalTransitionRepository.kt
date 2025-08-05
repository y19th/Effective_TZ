package com.y19th.core.domain.repository.transition

import com.y19th.core.domain.models.transition.Transition

interface LocalTransitionRepository {

    suspend fun takeStage(transition: Transition)

    suspend fun receive(): Transition
}