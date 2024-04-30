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
    fun salvar(contato: Contato)

    @Update
    fun atualizar(contato: Contato)

    @Delete
    fun excluir(contato: Contato)

    @Query("SELECT * FROM tbl_contatos order by nome ASC")
    fun listarTodosOsContatos(contato: Contato)

    @Query("select * from tbl_contatos where nome = :nome order by nome ASC")
    fun BuscarContatoPeloNome(nome: String): List<Contato>
}