package com.example.apptemplet.di.scope

import javax.inject.Scope
import kotlin.annotation.Retention

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity
