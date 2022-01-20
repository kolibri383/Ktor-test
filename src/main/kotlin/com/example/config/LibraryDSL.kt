package com.example.config

import java.sql.Connection
import java.sql.DriverManager

class LibraryDSL {
    private val userName = "postgres"
    private val password = "1234"
    private val url = "jdbc:postgresql://localhost:5432/library"

    fun getConn():Connection?{
        var conn: Connection? = null
        try{
            println( DriverManager.getDriver(url))
            conn = DriverManager.getConnection(url,userName,password)
        }
        catch (e:Exception){
            e.printStackTrace()
        }
        return conn
    }
}