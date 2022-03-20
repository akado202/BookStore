package com.akado.bookstore.data.mapper

interface DomainMapper<V, D> {

    fun mapToModel(from: V): D

}