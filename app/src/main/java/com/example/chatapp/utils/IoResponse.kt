package com.example.chatapp.utils


// step 1° Ok
sealed interface IoResponse<out T> {

    data class Success<T>(val value: T) : IoResponse<T>
    data class NetworkError(val throwable: Throwable) : IoResponse<Nothing>
    data class OtherError(val throwable: Throwable) : IoResponse<Nothing>
}

// step 2°
fun <T, R> IoResponse<T>.ioMapper(mapper: (T) -> R): IoResponse<R> {
    return when (this) {
        is IoResponse.Success -> IoResponse.Success(mapper(value))

        is IoResponse.NetworkError -> this
        is IoResponse.OtherError -> this
    }
}





