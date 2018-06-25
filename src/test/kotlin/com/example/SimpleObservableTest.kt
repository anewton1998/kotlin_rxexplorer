package com.example

import io.reactivex.Observable
import org.testng.Assert.assertTrue
import org.testng.annotations.Test

class SimpleObservableTest {

    @Test
    fun testObservable() {

        lateinit var result : String
        val observable = Observable.just( "Hello" )
        observable.subscribe{ result = it }
        assertTrue( result.equals( "Hello" ) )
    }

    @Test
    fun testObservableSubscribe() {

        var result = ""
        val observable = Observable.fromArray( "a", "b", "c", "d", "e", "f", "g" )
        observable.subscribe(
            { i -> result += i },
            { throwable -> throwable.printStackTrace()  },
            { result += "_Completed" }
        )
        assertTrue( result.equals( "abcdefg_Completed" ) )

    }

}