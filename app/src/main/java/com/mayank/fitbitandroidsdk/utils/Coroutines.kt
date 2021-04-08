package com.mayank.fitbitandroidsdk.utils

import kotlinx.coroutines.*

/***
 * created by Mayank Malhotra
 ***/

/***
Higher Order Function to use Coroutines simply just use Coroutines.io{} for background thread and Coroutines.main{} for main thread
 ***/
object Coroutines {

    private val job: Job = Job()

    fun io(func: suspend () -> Unit): Job =
        CoroutineScope(Dispatchers.IO + job).launch { func() }

    fun main(func: suspend () -> Unit): Job =
        CoroutineScope(Dispatchers.Main + job).launch { func() }

    fun <T> async(func: suspend () -> T): T {
        return runBlocking {
            val response = async {
                func()
            }
            response.await()
        }
    }

    fun cancelCoroutine(job: Job) {
        job.cancel()
    }

}