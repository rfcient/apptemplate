package com.example.apptemplet.utils

interface Mapper<R, D> {
    fun mapFrom(type: R): D
}
