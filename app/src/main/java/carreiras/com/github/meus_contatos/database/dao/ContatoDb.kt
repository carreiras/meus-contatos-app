package carreiras.com.github.meus_contatos.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import carreiras.com.github.meus_contatos.model.Contato

@Database(entities = [Contato::class], version = 1)
abstract class ContatoDb : RoomDatabase() {
    abstract fun contatoDao(): ContatoDao

    companion object {
        private var instance: ContatoDb? = null

        fun getDatabase(context: Context): ContatoDb {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): ContatoDb {
            return Room
                .databaseBuilder(
                    context,
                    ContatoDb::class.java,
                    "contato_db"
                )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }

}