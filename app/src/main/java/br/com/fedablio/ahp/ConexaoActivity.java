package br.com.fedablio.ahp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import br.com.fedablio.dao.ConexaoDAO;

public class ConexaoActivity extends Activity {

    private String id = "";
    private String endereco = "";
    private String porta = "";
    private String palavra = "";
    private EditText etEndereco;
    private EditText etPorta;
    private EditText etPalavra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conexao);
        etEndereco = (EditText) findViewById(R.id.editTextEnderecoConexao);
        etPorta = (EditText) findViewById(R.id.editTextPortaConexao);
        etPalavra = (EditText) findViewById(R.id.editTextPalavraConexao);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            id = bundle.getString("_ID_");
            endereco = bundle.getString("_URL_");
            porta = bundle.getString("_PORTA_");
            palavra = bundle.getString("_PALAVRA_");
        }
        etEndereco.setText(endereco);
        etPorta.setText(porta);
        etPalavra.setText(palavra);
        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
    }

    public void executar_alteracao(View view){
        if(etEndereco.getText().length() != 0 && etPorta.getText().length() != 0 && etPalavra.getText().length() != 0){
            AsyncTask<Void, Void, Void> executarTarefa = new AsyncTask<Void, Void, Void>() {
                long parametro1 = Long.parseLong(id);
                String parametro2 = etEndereco.getText().toString();
                String parametro3 = etPorta.getText().toString();
                String parametro4 = etPalavra.getText().toString();
                @Override
                protected Void doInBackground(Void... params) {
                    new ConexaoDAO(ConexaoActivity.this).abre();
                    new ConexaoDAO(ConexaoActivity.this).alterar(parametro1, parametro2, parametro3, parametro4);
                    return null;
                }
                @Override
                protected void onPostExecute(Void aVoid) {
                    Intent intent = new Intent(ConexaoActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    super.onPostExecute(aVoid);
                }
            };
            executarTarefa.execute((Void[])null);
        }else{
            Toast.makeText(this,"There are blank fields.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_conexao, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mnPrincipal) {
            Intent intent = new Intent(ConexaoActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}