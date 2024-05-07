package br.senai.sp.jandira.contato.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.senai.sp.jandira.contato.model.Contato

@Dao
interface ContatoDAO {

    @Insert
    fun salvar(contato: Contato): Long

    @Update
    fun atualizar(contato: Contato): Int

    @Delete
    fun excluir(contato: Contato)

    @Query("SELECT * FROM tbl_contatos ORDER BY nome ASC")
    fun listarTodosOsContatos(): List<Contato>

    @Query("select * from tbl_contatos where nome = :nome order by nome ASC")
    fun BuscarContatoPeloNome(nome: String): List<Contato>
    @Query("select * from tbl_contatos where id = :id")
    fun BuscarContatoPeloID(id: Long): Contato

    
}