package com.y19th.core.domain.interactors.transition

import com.y19th.core.domain.interactors.base.BaseInteractor
import com.y19th.core.domain.models.transition.Transition
import com.y19th.core.domain.repository.transition.LocalTransitionRepository
import com.y19th.core.resources.models.Stage

internal class TransitionInteractorImpl(
    private val localTransitionRepository: LocalTransitionRepository
) : TransitionInteractor, BaseInteractor() {

    override suspend fun update(stage: Stage) = changeContext {
        localTransitionRepository.takeStage(Transition(stage))
    }

    override suspend fun getStage(): Stage = changeContext {
        localTransitionRepository.receive().stage
    }
}