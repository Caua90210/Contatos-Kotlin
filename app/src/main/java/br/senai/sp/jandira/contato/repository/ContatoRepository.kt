package br.senai.sp.jandira.contato.repository

import android.content.Context
import br.senai.sp.jandira.contato.dao.ContatoDb
import br.senai.sp.jandira.contato.model.Contato

class ContatoRepository(context: Context) {

    private val db = ContatoDb.getBancoDeDados(context).contatoDao()


    fun salvar(contato: Contato): Long{
        return db.salvar(contato)
    }

    fun listarTodosOsContatos(): List<Contato>{
        return db.listarTodosOsContatos()
    }

}