package com.example.dao

import com.example.config.LibraryDSL
import nu.studer.sample.tables.Autor.AUTOR
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import com.example.domain.Author as AuthorDTO

class AuthorDaoImpl(private val library: LibraryDSL) : AuthorDao {

    private val create = DSL.using(library.getConn(),SQLDialect.POSTGRES)

    override fun create() {
        TODO("Not yet implemented")
    }


    override fun getAll(): List<AuthorDTO> {
        val authors: MutableList<AuthorDTO> = mutableListOf()
        create.select().from(AUTOR).fetch().toList().map {
            val autor = AuthorDTO(it.getValue(AUTOR.ID))
            autor.firstName = it.getValue(AUTOR.FIRST_NAME)
            autor.lastName = it.getValue(AUTOR.LASR_NAME)
            authors.add(autor)
        }
        return authors
    }

    override fun getByID(id:Int):AuthorDTO? {
        val result = create.select()
            .from(AUTOR)
            .where(AUTOR.ID.eq(id))
            .fetch()
        if (result.isNotEmpty){
            val author = AuthorDTO(id)
            author.firstName = result.getValue(0,AUTOR.FIRST_NAME)
            author.lastName = result.getValue(0,AUTOR.LASR_NAME)
            return author
        }

        return null
    }

}