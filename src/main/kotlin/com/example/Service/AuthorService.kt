package com.example.Service

import com.example.domain.Author

interface AuthorService {
    fun getAll():List<Author>
    fun getById(id: Int):Author?
    fun delete(id: Int):Boolean
    fun create(newAuthor: Author):Boolean
//    fun update(id: Int, update: Map<String,>):Boolean
}