package com.fevziomurtekin.githubjobs.base

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T? = null): Resource<T> {
            return Resource(
                Status.SUCCES,
                data,
                null
            )
        }

        fun <T> error(msg: String): Resource<T> {
            return Resource(
                Status.ERROR,
                null,
                msg
            )
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(
                Status.LOADING,
                data,
                null
            )
        }

        fun <T> empty(msg: String): Resource<T> {
            return Resource(
                Status.EMPTY,
                null,
                msg
            )
        }
    }
}