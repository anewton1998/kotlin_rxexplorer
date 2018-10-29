package com.example

import io.reactivex.Completable
import io.reactivex.Observable
import org.testng.Assert.assertTrue
import org.testng.annotations.Test

class CompletableTest {

    val list = ArrayList<String>()

    @Test
    fun testAndThenLambda() {
        list.clear()
        Completable.complete().andThen {
            doA()
        }.andThen{
            doB()
        }.andThen {
            doC()
        }.subscribe()
        println( list.size )
        assertTrue( list.size.equals( 0 ) )
    }

    @Test
    fun testAndThenLambdaSubscribe() {
        list.clear()
        Completable.complete().andThen {
            doA().subscribe()
        }.andThen{
            doB().subscribe()
        }.andThen {
            doC().subscribe()
        }.subscribe()
        println( list.size )
        assertTrue( list.size.equals( 1 ) )
    }

    @Test
    fun testAndThen() {
        list.clear()
        Completable.complete().andThen(
                doA()
        ).andThen(
                doB()
        ).andThen(
                doC()
        ).subscribe()
        println( list.size )
        assertTrue( list.size.equals( 1 ) )
    }


    fun doA() : Completable {
        return Completable.create {
            list.add( "doingA" )
        }
    }

    fun doB() : Completable {
        return Completable.create {
            list.add( "doingB" )
        }
    }

    fun doC() : Completable {
        return Completable.create {
            list.add( "doingC" )
        }
    }

}