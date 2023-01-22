package br.com.fedablio.ahp;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import br.com.fedablio.dao.PortaDAO;
import br.com.fedablio.model.Porta;

public class PortaActivity extends Activity {

    ArrayList<Porta> listaPortaBanco = null;
    private EditText etNomeD2;
    private EditText etNomeD3;
    private EditText etNomeD5;
    private EditText etNomeD6;
    private EditText etNomeD7;
    private EditText etNomeA0;
    private EditText etNomeA1;
    private EditText etNomeA2;
    private EditText etNomeA3;
    private EditText etNomeA4;
    String idD2, nomeD2, idD3, nomeD3, idD5, nomeD5, idD6, nomeD6, idD7, nomeD7, idA0, nomeA0, idA1, nomeA1, idA2, nomeA2, idA3, nomeA3, idA4, nomeA4 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porta);
        etNomeD2 = (EditText) findViewById(R.id.editTextNomeD2);
        etNomeD3 = (EditText) findViewById(R.id.editTextNomeD3);
        etNomeD5 = (EditText) findViewById(R.id.editTextNomeD5);
        etNomeD6 = (EditText) findViewById(R.id.editTextNomeD6);
        etNomeD7 = (EditText) findViewById(R.id.editTextNomeD7);
        etNomeA0 = (EditText) findViewById(R.id.editTextNomeA0);
        etNomeA1 = (EditText) findViewById(R.id.editTextNomeA1);
        etNomeA2 = (EditText) findViewById(R.id.editTextNomeA2);
        etNomeA3 = (EditText) findViewById(R.id.editTextNomeA3);
        etNomeA4 = (EditText) findViewById(R.id.editTextNomeA4);
        seleciona_porta();
        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
    }

    private void seleciona_porta(){
        AsyncTask<Void, Void, Void> executaTrem = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                new PortaDAO(PortaActivity.this).abre();
                listaPortaBanco = new PortaDAO(PortaActivity.this).listaPorta(1);
                for(Porta porta : listaPortaBanco){
                    idD2 = String.valueOf(porta.get_id());
                    nomeD2 = porta.getNome();
                }
                listaPortaBanco = new PortaDAO(PortaActivity.this).listaPorta(2);
                for(Porta porta : listaPortaBanco){
                    idD3 = String.valueOf(porta.get_id());
                    nomeD3 = porta.getNome();
                }
                listaPortaBanco = new PortaDAO(PortaActivity.this).listaPorta(3);
                for(Porta porta : listaPortaBanco){
                    idD5 = String.valueOf(porta.get_id());
                    nomeD5 = porta.getNome();
                }
                listaPortaBanco = new PortaDAO(PortaActivity.this).listaPorta(4);
                for(Porta porta : listaPortaBanco){
                    idD6 = String.valueOf(porta.get_id());
                    nomeD6 = porta.getNome();
                }
                listaPortaBanco = new PortaDAO(PortaActivity.this).listaPorta(5);
                for(Porta porta : listaPortaBanco){
                    idD7 = String.valueOf(porta.get_id());
                    nomeD7 = porta.getNome();
                }
                listaPortaBanco = new PortaDAO(PortaActivity.this).listaPorta(6);
                for(Porta porta : listaPortaBanco){
                    idA0 = String.valueOf(porta.get_id());
                    nomeA0 = porta.getNome();
                }
                listaPortaBanco = new PortaDAO(PortaActivity.this).listaPorta(7);
                for(Porta porta : listaPortaBanco){
                    idA1 = String.valueOf(porta.get_id());
                    nomeA1 = porta.getNome();
                }
                listaPortaBanco = new PortaDAO(PortaActivity.this).listaPorta(8);
                for(Porta porta : listaPortaBanco){
                    idA2 = String.valueOf(porta.get_id());
                    nomeA2 = porta.getNome();
                }
                listaPortaBanco = new PortaDAO(PortaActivity.this).listaPorta(9);
                for(Porta porta : listaPortaBanco){
                    idA3 = String.valueOf(porta.get_id());
                    nomeA3 = porta.getNome();
                }
                listaPortaBanco = new PortaDAO(PortaActivity.this).listaPorta(10);
                for(Porta porta : listaPortaBanco){
                    idA4 = String.valueOf(porta.get_id());
                    nomeA4 = porta.getNome();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                etNomeD2.setText(nomeD2);
                etNomeD3.setText(nomeD3);
                etNomeD5.setText(nomeD5);
                etNomeD6.setText(nomeD6);
                etNomeD7.setText(nomeD7);
                etNomeA0.setText(nomeA0);
                etNomeA1.setText(nomeA1);
                etNomeA2.setText(nomeA2);
                etNomeA3.setText(nomeA3);
                etNomeA4.setText(nomeA4);
                super.onPostExecute(aVoid);
            }
        };
        executaTrem.execute((Void[]) null);
    }

    public void executar_alteracao(View view){
        nomeD2 = etNomeD2.getText().toString();
        nomeD3 = etNomeD3.getText().toString();
        nomeD5 = etNomeD5.getText().toString();
        nomeD6 = etNomeD6.getText().toString();
        nomeD7 = etNomeD7.getText().toString();
        nomeA0 = etNomeA0.getText().toString();
        nomeA1 = etNomeA1.getText().toString();
        nomeA2 = etNomeA2.getText().toString();
        nomeA3 = etNomeA3.getText().toString();
        nomeA4 = etNomeA4.getText().toString();
        if(nomeD2.length() != 0 && nomeD3.length() != 0 && nomeD5.length() != 0 && nomeD6.length() != 0 && nomeD7.length() != 0 && nomeA0.length() != 0 && nomeA1.length() != 0 && nomeA2.length() != 0 && nomeA3.length() != 0 && nomeA4.length() != 0){
            AsyncTask<Void, Void, Void> executaTrem = new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... params) {
                    new PortaDAO(PortaActivity.this).alterar(Long.parseLong(idD2), nomeD2);
                    new PortaDAO(PortaActivity.this).alterar(Long.parseLong(idD3), nomeD3);
                    new PortaDAO(PortaActivity.this).alterar(Long.parseLong(idD5), nomeD5);
                    new PortaDAO(PortaActivity.this).alterar(Long.parseLong(idD6), nomeD6);
                    new PortaDAO(PortaActivity.this).alterar(Long.parseLong(idD7), nomeD7);
                    new PortaDAO(PortaActivity.this).alterar(Long.parseLong(idA0), nomeA0);
                    new PortaDAO(PortaActivity.this).alterar(Long.parseLong(idA1), nomeA1);
                    new PortaDAO(PortaActivity.this).alterar(Long.parseLong(idA2), nomeA2);
                    new PortaDAO(PortaActivity.this).alterar(Long.parseLong(idA3), nomeA3);
                    new PortaDAO(PortaActivity.this).alterar(Long.parseLong(idA4), nomeA4);
                    return null;
                }
                @Override
                protected void onPostExecute(Void aVoid) {
                    Intent intent = new Intent(PortaActivity.this, br.com.fedablio.ahp.MainActivity.class);
                    startActivity(intent);
                    finish();
                    super.onPostExecute(aVoid);
                }
            };
            executaTrem.execute((Void[]) null);
        }else{
            Toast.makeText(this,"There are blank fields.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_porta, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mnPrincipal) {
            Intent intent = new Intent(PortaActivity.this, br.com.fedablio.ahp.MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
