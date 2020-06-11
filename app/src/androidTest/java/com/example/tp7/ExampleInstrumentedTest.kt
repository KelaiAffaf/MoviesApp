package com.example.tp7

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Assert
import org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    lateinit var mDataBase:AppDatabase
    @Before
    fun initDB() {
        mDataBase =
            Room.inMemoryDatabaseBuilder(InstrumentationRegistry.
            getInstrumentation().context,AppDatabase::class.java).build()
    }
    @Test
     fun testInserandgetMovie() {
        // Context of the app under test.
        val movie1 = Movie(1,"Game of throns","2009")
        mDataBase?.getMovieDo().insert(movie1)

        val list= mDataBase?.getMovieDo().getAMovie()
        Assert.assertEquals(movie1,list.get(0))

    }

    @After
    fun closeDb(){
        mDataBase?.close()
    }
}
