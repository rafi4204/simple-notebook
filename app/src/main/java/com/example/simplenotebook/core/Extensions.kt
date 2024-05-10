package com.example.simplenotebook.core

import timber.log.Timber
import kotlin.coroutines.cancellation.CancellationException

/**
 * Attempts [block], returning a successful [Result] if it succeeds, otherwise a [Result.Failure]
 * taking care not to break structured concurrency
 *
 * @see <a href=" https://github.com/Kotlin/kotlinx.coroutines/issues/1814">kotlinx.coroutines discussion</a>
 */
suspend fun <T> suspendRunCatching(block: suspend () -> T): Result<T> = try {
    Result.success(block())
} catch (cancellationException: CancellationException) {
    throw cancellationException
} catch (exception: Exception) {
    Timber.e(exception)
    Result.failure(exception)
}