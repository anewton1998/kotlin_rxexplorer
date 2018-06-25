package com.example

import io.reactivex.Observable
import org.testng.Assert.assertTrue
import org.testng.annotations.Test

class SimpleMapTest {

    @Test
    fun testMap() {
        var result = ""
        Observable.fromArray( "a", "b", "c", "d", "e", "f", "g" )
            .map( String::toUpperCase )
            .subscribe{ result += it }
        assertTrue( result.equals( "ABCDEFG" ) )
    }

    fun getTitle() : Observable<String> {
        return Observable.fromArray( "title" )
    }

    @Test
    fun testFlatMap() {
        var result = ""
        Observable.just( "book1", "book2", "book3" )
                .flatMap { getTitle() }
                .subscribe{ result += it }

        assertTrue( result.equals( "titletitletitle" ) )
    }

}