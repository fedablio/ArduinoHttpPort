package br.com.fedablio.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConnectionFactory extends SQLiteOpenHelper{

    private static final String NOME_DATABASE = "banco_ahp";
    private static final int VERSAO_DATABASE = 1;

    public ConnectionFactory(Context context) {
        super(context, NOME_DATABASE, null, VERSAO_DATABASE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql1 = "CREATE TABLE conexao (_id INTEGER PRIMARY KEY AUTOINCREMENT, endereco TEXT, porta TEXT, palavra TEXT);";
        String sql2 = "INSERT INTO conexao (endereco, porta, palavra) VALUES ('192.168.0.199', '8090', 'fedablio');";
        String sql3 = "CREATE TABLE porta (_id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT);";
        String sql4 = "INSERT INTO porta (nome) VALUES ('Digital 2');";
        String sql5 = "INSERT INTO porta (nome) VALUES ('Digital 3');";
        String sql6 = "INSERT INTO porta (nome) VALUES ('Digital 5');";
        String sql7 = "INSERT INTO porta (nome) VALUES ('Digital 6');";
        String sql8 = "INSERT INTO porta (nome) VALUES ('Digital 7');";
        String sql9 = "INSERT INTO porta (nome) VALUES ('Analog 0');";
        String sql10 = "INSERT INTO porta (nome) VALUES ('Analog 1');";
        String sql11 = "INSERT INTO porta (nome) VALUES ('Analog 2');";
        String sql12 = "INSERT INTO porta (nome) VALUES ('Analog 3');";
        String sql13 = "INSERT INTO porta (nome) VALUES ('Analog 4');";
        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);
        db.execSQL(sql5);
        db.execSQL(sql6);
        db.execSQL(sql7);
        db.execSQL(sql8);
        db.execSQL(sql9);
        db.execSQL(sql10);
        db.execSQL(sql11);
        db.execSQL(sql12);
        db.execSQL(sql13);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
