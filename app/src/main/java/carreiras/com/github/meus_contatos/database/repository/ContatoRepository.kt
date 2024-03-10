package carreiras.com.github.meus_contatos.database.repository

import android.content.Context
import carreiras.com.github.meus_contatos.database.dao.ContatoDb
import carreiras.com.github.meus_contatos.model.Contato

class ContatoRepository(context: Context) {
    private val db = ContatoDb.getDatabase(context).contatoDao()
    fun salvar(contato: Contato): Long {
        return db.salvar(contato)
    }

    fun atualizar(contato: Contato): Int {
        return db.atualizar(contato)
    }

    fun excluir(contato: Contato): Int {
        return db.excluir(contato)
    }

    fun listarContatos(): List<Contato> {
        return db.listarContatos()
    }

    fun buscarContatoPeloId(id: Int): Contato {
        return db.buscarContatoPeloId(id)
    }
}