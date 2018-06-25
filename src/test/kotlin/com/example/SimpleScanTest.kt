package com.example

import io.reactivex.Observable
import org.testng.Assert.assertTrue
import org.testng.annotations.Test

class SimpleScanTest {

    @Test
    fun testScan() {
        var result = ""
        Observable.just( "a", "b", "c" )
                .scan( StringBuilder(), StringBuilder::append )
                .subscribe{ result += it.toString() }
        assertTrue( result.equals( "aababc" ) )
    }

}