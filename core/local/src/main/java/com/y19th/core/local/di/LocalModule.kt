package com.y19th.core.local.di

import com.y19th.core.domain.repository.courses.LocalCoursesRepository
import com.y19th.core.domain.repository.transition.LocalTransitionRepository
import com.y19th.core.local.dao.CourseDao
import com.y19th.core.local.dao.TransitionDao
import com.y19th.core.local.database.MainDatabase
import com.y19th.core.local.database.defaultDatabaseBuilder
import com.y19th.core.local.repository.LocalCourseRepositoryImpl
import com.y19th.core.local.repository.LocalTransitionRepositoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val databaseModule = module {
    single { defaultDatabaseBuilder() }.bind<MainDatabase>()
}

internal val daoModule = module {
    factory<TransitionDao> { get<MainDatabase>().transitionDao() }
    factory<CourseDao> { get<MainDatabase>().courseDao() }
}

val localModule = module {
    includes(daoModule, databaseModule)
    factoryOf(::LocalTransitionRepositoryImpl).bind<LocalTransitionRepository>()
    factoryOf(::LocalCourseRepositoryImpl).bind<LocalCoursesRepository>()
}

