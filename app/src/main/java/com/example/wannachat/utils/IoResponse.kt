package com.example.wannachat.utils

import retrofit2.HttpException
import java.io.IOException
import kotlin.coroutines.cancellation.CancellationException


sealed interface IoResponse<out T> {
    data class Success<T>(val value: T) : IoResponse<T>
    data object NetworkError : IoResponse<Nothing>
    data object OtherError : IoResponse<Nothing>
}


fun <T, R> IoResponse<T>.ioMapper(mapper: (T) -> R): IoResponse<R> {
    return when (this) {
        is IoResponse.Success -> IoResponse.Success(mapper(value))
        is IoResponse.NetworkError -> this
        is IoResponse.OtherError -> this
    }
}


// coroutines - network call
suspend fun <T> handleApiCall(call: suspend () -> T): IoResponse<T> {
    return try {
        IoResponse.Success(call())
    } catch (ex: CancellationException) {
        throw ex
    } catch (ex: HttpException) {
        ex.printStackTrace()
        IoResponse.OtherError
    } catch (ex: IOException) {
        ex.printStackTrace()
        IoResponse.NetworkError
    } catch (ex: Throwable) {
        ex.printStackTrace()
        IoResponse.OtherError
    }
}





