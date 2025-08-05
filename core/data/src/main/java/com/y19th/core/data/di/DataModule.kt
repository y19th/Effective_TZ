package com.y19th.core.data.di

import com.y19th.core.data.network.MainApi
import com.y19th.core.data.network.retrofitBuilder
import com.y19th.core.data.repository.DataCoursesRepositoryImpl
import com.y19th.core.domain.repository.courses.DataCoursesRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

internal val retrofitModule = module {
    single { retrofitBuilder() }
    single { get<Retrofit>().create(MainApi::class.java) }
}

val dataModule = module {
    includes(retrofitModule)
    factoryOf(::DataCoursesRepositoryImpl).bind<DataCoursesRepository>()
}