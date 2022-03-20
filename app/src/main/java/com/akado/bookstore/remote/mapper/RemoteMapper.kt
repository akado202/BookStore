package com.akado.bookstore.remote.mapper

interface RemoteMapper<in M, out E> {

    fun mapToData(from: M): E

}