package com.example.dao

import com.example.domain.Author

interface AuthorDao {
    fun create()
    fun getAll():List<Author>
    fun getByID(id:Int):Author?
}