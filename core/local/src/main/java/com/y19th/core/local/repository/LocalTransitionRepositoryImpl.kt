package com.y19th.core.local.repository

import com.y19th.core.domain.models.transition.Transition
import com.y19th.core.domain.repository.transition.LocalTransitionRepository
import com.y19th.core.local.dao.TransitionDao
import com.y19th.core.local.mapper.toTransition
import com.y19th.core.local.mapper.toTransitionEntity

internal class LocalTransitionRepositoryImpl(
    private val dao: TransitionDao
) : LocalTransitionRepository {

    override suspend fun takeStage(transition: Transition) {
        dao.replace(transition.toTransitionEntity())
    }

    override suspend fun receive(): Transition {
        return dao.take()?.toTransition() ?: Transition()
    }
}