package com.example.Service

import com.example.dao.AuthorDao
import com.example.domain.Author

class AuthorServiceImpl(private val authorDao: AuthorDao) : AuthorService {
    override fun getAll(): List<Author> =
       authorDao.getAll()


    override fun getById(id: Int): Author? {
        return authorDao.getByID(id)
    }

    override fun delete(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun create(newAutor: Author): Boolean {
        TODO("Not yet implemented")
    }
}