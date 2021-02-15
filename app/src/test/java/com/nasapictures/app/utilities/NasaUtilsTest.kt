package com.nasapictures.app.utilities

import junit.framework.TestCase.assertEquals
import org.junit.Test

class NasaUtilsTest{

    @Test
    fun `check for date value 2021-02-17`(){
        val date = fetchDisplayDate("2021-02-17")
        assertEquals(date,"17 Feb, 2021")
    }

}