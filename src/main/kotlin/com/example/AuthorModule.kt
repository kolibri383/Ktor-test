package com.example

import com.example.Service.AuthorService
import com.example.Service.AuthorServiceImpl
import com.example.dao.AuthorDao
import com.example.dao.AuthorDaoImpl
import org.koin.dsl.module



val authorModule = module(createdAtStart = true) {
    single{ com.example.config.LibraryDSL() }
    single<AuthorDao>{AuthorDaoImpl(get())}
    single<AuthorService> { AuthorServiceImpl(get()) }
}