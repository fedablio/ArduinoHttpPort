package br.com.fedablio.ahp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import br.com.fedablio.dao.ConexaoDAO;
import br.com.fedablio.model.Conexao;

public class MainActivity extends Activity {

    private EditText etEndereco;
    private EditText etPorta;
    private EditText etPalavra;
    private ArrayList<Conexao> listaConexaoBanco;
    private String selecao1 = "";
    private String selecao2 = "";
    private String selecao3 = "";
    private String selecao4 = "";
    private boolean excecao = false;
    private Exception msg_excecao = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEndereco = (EditText) findViewById(R.id.editTextEndereco);
        etPorta = (EditText) findViewById(R.id.editTextPorta);
        etPalavra = (EditText) findViewById(R.id.editTextPalavra);
        seleciona_conexao();
        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
    }

    public void inicia_automacao(View view){
        if (rede(this)) {
            verifica_url();
            if (excecao != true) {
                Intent intent = new Intent(MainActivity.this, AutomacaoActivity.class);
                intent.putExtra("_ENDERECO_", etEndereco.getText().toString());
                intent.putExtra("_PORTA_", etPorta.getText().toString());
                intent.putExtra("_PALAVRA_", etPalavra.getText().toString());
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this,"Invalid address or Arduino not found.", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this,"No network connection.", Toast.LENGTH_LONG).show();
        }
    }

    public static boolean rede(Context contexto) {
        ConnectivityManager cm = (ConnectivityManager) contexto.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if ((netInfo != null) && (netInfo.isConnectedOrConnecting()) && (netInfo.isAvailable())) {
            return true;
        }
        return false;
    }

    private void seleciona_conexao() {
        AsyncTask<Void, Void, Void> executaTrem = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                new ConexaoDAO(MainActivity.this).abre();
                listaConexaoBanco = new ConexaoDAO(MainActivity.this).listaConexao();
                for (Conexao conexao : listaConexaoBanco) {
                    selecao1 = String.valueOf(conexao.getId());
                    selecao2 = conexao.getEndereco();
                    selecao3 = conexao.getPorta();
                    selecao4 = conexao.getPalavra();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                etEndereco.setText(selecao2);
                etPorta.setText(selecao3);
                etPalavra.setText(selecao4);
                super.onPostExecute(aVoid);
            }
        };
        executaTrem.execute((Void[]) null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mnEndereco) {
            Intent intent = new Intent(MainActivity.this, br.com.fedablio.ahp.ConexaoActivity.class);
            intent.putExtra("_ID_", selecao1);
            intent.putExtra("_URL_", selecao2);
            intent.putExtra("_PORTA_", selecao3);
            intent.putExtra("_PALAVRA_", selecao4);
            startActivity(intent);
            finish();
        }
        if (id == R.id.mnPorta) {
            Intent intent = new Intent(MainActivity.this, PortaActivity.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.mnSobre) {
            Intent intent = new Intent(MainActivity.this, SobreActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void verifica_url() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        HttpClient cliente = null;
        HttpGet requiscao = null;
        BufferedReader in = null;
        StringBuffer sb = null;
        cliente = new DefaultHttpClient();
        requiscao = new HttpGet();
        try {
            requiscao.setURI(new URI("http://" + selecao2 +":"+selecao3+ "/"));
            cliente.execute(requiscao);
            HttpResponse response = cliente.execute(requiscao);
            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            sb = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line + NL);
            }
            in.close();
            String page = sb.toString();
        } catch (Exception erro) {
            excecao = true;
            msg_excecao = erro;
        }

    }

}