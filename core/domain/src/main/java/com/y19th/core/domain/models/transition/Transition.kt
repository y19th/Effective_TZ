package com.y19th.core.domain.models.transition

import com.y19th.core.resources.models.Stage

@JvmInline
value class Transition(
    val stage: Stage = Stage.Undefined
)
