package br.com.fedablio.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import br.com.fedablio.model.Porta;

public class PortaDAO {

    private SQLiteDatabase sqLiteDatabase;
    private br.com.fedablio.dao.ConnectionFactory connectionFactory;

    public PortaDAO(Context context){
        connectionFactory = new br.com.fedablio.dao.ConnectionFactory(context);
    }

    public void abre() {
        sqLiteDatabase = connectionFactory.getWritableDatabase();
    }

    public void fecha() {
        if (sqLiteDatabase != null) {
            sqLiteDatabase.close();
        }
    }

    public void alterar(long _id, String nome) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", nome);
        abre();
        sqLiteDatabase.update("porta", contentValues, "_id = " + _id, null);
        fecha();
    }

    public ArrayList<Porta> listaPorta(int id) {
        ArrayList<Porta> lista = new ArrayList<Porta>();
        abre();
        Cursor c = sqLiteDatabase.query("porta", new String[]{"_id", "nome"}, "_id="+id, null, null, null, null, null);
        while(c.moveToNext()){
            Porta porta = new Porta();
            porta.set_id(c.getLong(0));
            porta.setNome(c.getString(1));
            lista.add(porta);
        }
        return lista;
    }

}
