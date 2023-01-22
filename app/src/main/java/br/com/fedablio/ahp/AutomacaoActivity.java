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
import android.widget.LinearLayout;
import android.widget.TextView;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import br.com.fedablio.dao.PortaDAO;
import br.com.fedablio.model.Porta;

public class AutomacaoActivity extends Activity {

    ArrayList<Porta> listaPortaBanco = null;
    private TextView tvNomeD2;
    private TextView tvNomeD3;
    private TextView tvNomeD5;
    private TextView tvNomeD6;
    private TextView tvNomeD7;
    private TextView tvNomeA0;
    private TextView tvNomeA1;
    private TextView tvNomeA2;
    private TextView tvNomeA3;
    private TextView tvNomeA4;
    String nomeD2, nomeD3, nomeD5, nomeD6, nomeD7, nomeA0, nomeA1, nomeA2, nomeA3, nomeA4 = "";
    private String endereco = "";
    private String porta = "";
    private String palavra = "";
    private String resultado = "";
    private LinearLayout llPorta2;
    private LinearLayout llPorta3;
    private LinearLayout llPorta5;
    private LinearLayout llPorta6;
    private LinearLayout llPorta7;
    private LinearLayout llPortaA0;
    private LinearLayout llPortaA1;
    private LinearLayout llPortaA2;
    private LinearLayout llPortaA3;
    private LinearLayout llPortaA4;
    private HttpClient cliente = null;
    private HttpGet requiscao = null;
    private BufferedReader in = null;
    private StringBuffer sb = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automacao);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            endereco = bundle.getString("_ENDERECO_");
            porta = bundle.getString("_PORTA_");
            palavra = bundle.getString("_PALAVRA_");
        }
        llPorta2 = (LinearLayout) findViewById(R.id.linearLayoutPorta2);
        llPorta3 = (LinearLayout) findViewById(R.id.linearLayoutPorta3);
        llPorta5 = (LinearLayout) findViewById(R.id.linearLayoutPorta5);
        llPorta6 = (LinearLayout) findViewById(R.id.linearLayoutPorta6);
        llPorta7 = (LinearLayout) findViewById(R.id.linearLayoutPorta7);
        llPortaA0 = (LinearLayout) findViewById(R.id.linearLayoutPortaA0);
        llPortaA1 = (LinearLayout) findViewById(R.id.linearLayoutPortaA1);
        llPortaA2 = (LinearLayout) findViewById(R.id.linearLayoutPortaA2);
        llPortaA3 = (LinearLayout) findViewById(R.id.linearLayoutPortaA3);
        llPortaA4 = (LinearLayout) findViewById(R.id.linearLayoutPortaA4);
        tvNomeD2 = (TextView) findViewById(R.id.textViewNomeD2);
        tvNomeD3 = (TextView) findViewById(R.id.textViewNomeD3);
        tvNomeD5 = (TextView) findViewById(R.id.textViewNomeD5);
        tvNomeD6 = (TextView) findViewById(R.id.textViewNomeD6);
        tvNomeD7 = (TextView) findViewById(R.id.textViewNomeD7);
        tvNomeA0 = (TextView) findViewById(R.id.textViewNomeA0);
        tvNomeA1 = (TextView) findViewById(R.id.textViewNomeA1);
        tvNomeA2 = (TextView) findViewById(R.id.textViewNomeA2);
        tvNomeA3 = (TextView) findViewById(R.id.textViewNomeA3);
        tvNomeA4 = (TextView) findViewById(R.id.textViewNomeA4);
        nome_das_portas();
        carregando_portas();
        mostra_situacao2();
        mostra_situacao3();
        mostra_situacao5();
        mostra_situacao6();
        mostra_situacao7();
        mostra_situacaoA0();
        mostra_situacaoA1();
        mostra_situacaoA2();
        mostra_situacaoA3();
        mostra_situacaoA4();
        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
    }

    private void mostra_situacao2() {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://" + endereco +":"+porta+ "/"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                String texto = resultado.substring(0,6);
                if(texto.equals("D2_DES")){
                    _2D();
                }
                if(texto.equals("D2_LIG")){
                    _2L();
                }
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    private void mostra_situacao3() {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://" + endereco +":"+porta+ "/"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                String texto = resultado.substring(6,12);
                if(texto.equals("D3_DES")){
                    _3D();
                }
                if(texto.equals("D3_LIG")){
                    _3L();
                }
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    private void mostra_situacao5() {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://" + endereco +":"+porta+ "/"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                String texto = resultado.substring(12,18);
                if(texto.equals("D5_DES")){
                    _5D();
                }
                if(texto.equals("D5_LIG")){
                    _5L();
                }
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    private void mostra_situacao6() {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://" + endereco +":"+porta+ "/"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                String texto = resultado.substring(18,24);
                if(texto.equals("D6_DES")){
                    _6D();
                }
                if(texto.equals("D6_LIG")){
                    _6L();
                }
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    private void mostra_situacao7() {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://" + endereco +":"+porta+ "/"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                String texto = resultado.substring(24,30);
                if(texto.equals("D7_DES")){
                    _7D();
                }
                if(texto.equals("D7_LIG")){
                    _7L();
                }
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    private void mostra_situacaoA0() {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://" + endereco +":"+porta+ "/"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                String texto = resultado.substring(30,36);
                if(texto.equals("J0_DES")){
                    _A0D();
                }
                if(texto.equals("J0_LIG")){
                    _A0L();
                }
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    private void mostra_situacaoA1() {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://" + endereco +":"+porta+ "/"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                String texto = resultado.substring(36,42);
                if(texto.equals("J1_DES")){
                    _A1D();
                }
                if(texto.equals("J1_LIG")){
                    _A1L();
                }
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    private void mostra_situacaoA2() {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://" + endereco +":"+porta+ "/"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                String texto = resultado.substring(42,48);
                if(texto.equals("J2_DES")){
                    _A2D();
                }
                if(texto.equals("J2_LIG")){
                    _A2L();
                }
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    private void mostra_situacaoA3() {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://" + endereco +":"+porta+ "/"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                String texto = resultado.substring(48,54);
                if(texto.equals("J3_DES")){
                    _A3D();
                }
                if(texto.equals("J3_LIG")){
                    _A3L();
                }
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    private void mostra_situacaoA4() {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://" + endereco +":"+porta+ "/"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                String texto = resultado.substring(54,60);
                if(texto.equals("J4_DES")){
                    _A4D();
                }
                if(texto.equals("J4_LIG")){
                    _A4L();
                }
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    public void liga_porta2(final View view) {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://"+endereco+":"+porta+"/"+palavra+"/L2_LIG"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                resume_situacoes();
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    public void desliga_porta2(View view) {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://"+endereco+":"+porta+"/"+palavra+"/L2_DES"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                resume_situacoes();
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    public void liga_porta3(View view) {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://"+endereco+":"+porta+"/"+palavra+"/L3_LIG"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                resume_situacoes();
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    public void desliga_porta3(View view) {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://"+endereco+":"+porta+"/"+palavra+"/L3_DES"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                resume_situacoes();
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    public void liga_porta5(View view) {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://"+endereco+":"+porta+"/"+palavra+"/L5_LIG"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                resume_situacoes();
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    public void desliga_porta5(View view) {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://"+endereco+":"+porta+"/"+palavra+"/L5_DES"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                resume_situacoes();
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    public void liga_porta6(View view) {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://"+endereco+":"+porta+"/"+palavra+"/L6_LIG"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                resume_situacoes();
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    public void desliga_porta6(View view) {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://"+endereco+":"+porta+"/"+palavra+"/L6_DES"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                resume_situacoes();
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    public void liga_porta7(View view) {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://"+endereco+":"+porta+"/"+palavra+"/L7_LIG"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                resume_situacoes();
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    public void desliga_porta7(View view) {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://"+endereco+":"+porta+"/"+palavra+"/L7_DES"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                resume_situacoes();
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    public void liga_portaA0(View view) {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://"+endereco+":"+porta+"/"+palavra+"/N0_LIG"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                resume_situacoes();
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    public void desliga_portaA0(View view) {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://"+endereco+":"+porta+"/"+palavra+"/N0_DES"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                resume_situacoes();
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    public void liga_portaA1(View view) {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://"+endereco+":"+porta+"/"+palavra+"/N1_LIG"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                resume_situacoes();
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    public void desliga_portaA1(View view) {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://"+endereco+":"+porta+"/"+palavra+"/N1_DES"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                resume_situacoes();
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    public void liga_portaA2(View view) {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://"+endereco+":"+porta+"/"+palavra+"/N2_LIG"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                resume_situacoes();
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    public void desliga_portaA2(View view) {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://"+endereco+":"+porta+"/"+palavra+"/N2_DES"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                resume_situacoes();
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    public void liga_portaA3(View view) {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://"+endereco+":"+porta+"/"+palavra+"/N3_LIG"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                resume_situacoes();
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    public void desliga_portaA3(View view) {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://"+endereco+":"+porta+"/"+palavra+"/N3_DES"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                resume_situacoes();
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    public void liga_portaA4(View view) {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://"+endereco+":"+porta+"/"+palavra+"/N4_LIG"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                resume_situacoes();
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    public void desliga_portaA4(View view) {
        AsyncTask<Void, Void, Void> executaIsso = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                cliente = new DefaultHttpClient();
                requiscao = new HttpGet();
                try {
                    requiscao.setURI(new URI("http://"+endereco+":"+porta+"/"+palavra+"/N4_DES"));
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
                    resultado = page;
                } catch(Exception erro){
                    throw new RuntimeException(erro);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                resume_situacoes();
                super.onPostExecute(result);
            }
        };
        executaIsso.execute((Void[]) null);
    }

    private void _2D() {
        View viewButton = getLayoutInflater().inflate(R.layout.image_view_desligado, null);
        llPorta2.removeAllViews();
        llPorta2.addView(viewButton);
    }
    private void _2L() {
        View viewButton = getLayoutInflater().inflate(R.layout.image_view_ligado, null);
        llPorta2.removeAllViews();
        llPorta2.addView(viewButton);
    }
    private void _3D() {
        View viewButton = getLayoutInflater().inflate(R.layout.image_view_desligado, null);
        llPorta3.removeAllViews();
        llPorta3.addView(viewButton);
    }
    private void _3L() {
        View viewButton = getLayoutInflater().inflate(R.layout.image_view_ligado, null);
        llPorta3.removeAllViews();
        llPorta3.addView(viewButton);
    }
    private void _5D() {
        View viewButton = getLayoutInflater().inflate(R.layout.image_view_desligado, null);
        llPorta5.removeAllViews();
        llPorta5.addView(viewButton);
    }
    private void _5L() {
        View viewButton = getLayoutInflater().inflate(R.layout.image_view_ligado, null);
        llPorta5.removeAllViews();
        llPorta5.addView(viewButton);
    }
    private void _6D() {
        View viewButton = getLayoutInflater().inflate(R.layout.image_view_desligado, null);
        llPorta6.removeAllViews();
        llPorta6.addView(viewButton);
    }
    private void _6L() {
        View viewButton = getLayoutInflater().inflate(R.layout.image_view_ligado, null);
        llPorta6.removeAllViews();
        llPorta6.addView(viewButton);
    }
    private void _7D() {
        View viewButton = getLayoutInflater().inflate(R.layout.image_view_desligado, null);
        llPorta7.removeAllViews();
        llPorta7.addView(viewButton);
    }
    private void _7L() {
        View viewButton = getLayoutInflater().inflate(R.layout.image_view_ligado, null);
        llPorta7.removeAllViews();
        llPorta7.addView(viewButton);
    }
    private void _A0D() {
        View viewButton = getLayoutInflater().inflate(R.layout.image_view_desligado, null);
        llPortaA0.removeAllViews();
        llPortaA0.addView(viewButton);
    }
    private void _A0L() {
        View viewButton = getLayoutInflater().inflate(R.layout.image_view_ligado, null);
        llPortaA0.removeAllViews();
        llPortaA0.addView(viewButton);
    }
    private void _A1D() {
        View viewButton = getLayoutInflater().inflate(R.layout.image_view_desligado, null);
        llPortaA1.removeAllViews();
        llPortaA1.addView(viewButton);
    }
    private void _A1L() {
        View viewButton = getLayoutInflater().inflate(R.layout.image_view_ligado, null);
        llPortaA1.removeAllViews();
        llPortaA1.addView(viewButton);
    }
    private void _A2D() {
        View viewButton = getLayoutInflater().inflate(R.layout.image_view_desligado, null);
        llPortaA2.removeAllViews();
        llPortaA2.addView(viewButton);
    }
    private void _A2L() {
        View viewButton = getLayoutInflater().inflate(R.layout.image_view_ligado, null);
        llPortaA2.removeAllViews();
        llPortaA2.addView(viewButton);
    }
    private void _A3D() {
        View viewButton = getLayoutInflater().inflate(R.layout.image_view_desligado, null);
        llPortaA3.removeAllViews();
        llPortaA3.addView(viewButton);
    }
    private void _A3L() {
        View viewButton = getLayoutInflater().inflate(R.layout.image_view_ligado, null);
        llPortaA3.removeAllViews();
        llPortaA3.addView(viewButton);
    }
    private void _A4D() {
        View viewButton = getLayoutInflater().inflate(R.layout.image_view_desligado, null);
        llPortaA4.removeAllViews();
        llPortaA4.addView(viewButton);
    }
    private void _A4L() {
        View viewButton = getLayoutInflater().inflate(R.layout.image_view_ligado, null);
        llPortaA4.removeAllViews();
        llPortaA4.addView(viewButton);
    }

    private void carregando_portas(){
        View viewButton2 = getLayoutInflater().inflate(R.layout.image_view_neutro, null);
        View viewButton3 = getLayoutInflater().inflate(R.layout.image_view_neutro, null);
        View viewButton5 = getLayoutInflater().inflate(R.layout.image_view_neutro, null);
        View viewButton6 = getLayoutInflater().inflate(R.layout.image_view_neutro, null);
        View viewButton7 = getLayoutInflater().inflate(R.layout.image_view_neutro, null);
        View viewButtonA0 = getLayoutInflater().inflate(R.layout.image_view_neutro, null);
        View viewButtonA1 = getLayoutInflater().inflate(R.layout.image_view_neutro, null);
        View viewButtonA2 = getLayoutInflater().inflate(R.layout.image_view_neutro, null);
        View viewButtonA3 = getLayoutInflater().inflate(R.layout.image_view_neutro, null);
        View viewButtonA4 = getLayoutInflater().inflate(R.layout.image_view_neutro, null);
        llPorta2.addView(viewButton2);
        llPorta3.addView(viewButton3);
        llPorta5.addView(viewButton5);
        llPorta6.addView(viewButton6);
        llPorta7.addView(viewButton7);
        llPortaA0.addView(viewButtonA0);
        llPortaA1.addView(viewButtonA1);
        llPortaA2.addView(viewButtonA2);
        llPortaA3.addView(viewButtonA3);
        llPortaA4.addView(viewButtonA4);
    }

    private void resume_situacoes(){
        mostra_situacao2();
        mostra_situacao3();
        mostra_situacao5();
        mostra_situacao6();
        mostra_situacao7();
        mostra_situacaoA0();
        mostra_situacaoA1();
        mostra_situacaoA2();
        mostra_situacaoA3();
        mostra_situacaoA4();
    }

    private void nome_das_portas(){
        AsyncTask<Void, Void, Void> executaTrem = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                new PortaDAO(AutomacaoActivity.this).abre();
                listaPortaBanco = new PortaDAO(AutomacaoActivity.this).listaPorta(1);
                for(Porta porta : listaPortaBanco){
                    nomeD2 = porta.getNome();
                }
                listaPortaBanco = new PortaDAO(AutomacaoActivity.this).listaPorta(2);
                for(Porta porta : listaPortaBanco){
                    nomeD3 = porta.getNome();
                }
                listaPortaBanco = new PortaDAO(AutomacaoActivity.this).listaPorta(3);
                for(Porta porta : listaPortaBanco){
                    nomeD5 = porta.getNome();
                }
                listaPortaBanco = new PortaDAO(AutomacaoActivity.this).listaPorta(4);
                for(Porta porta : listaPortaBanco){
                    nomeD6 = porta.getNome();
                }
                listaPortaBanco = new PortaDAO(AutomacaoActivity.this).listaPorta(5);
                for(Porta porta : listaPortaBanco){
                    nomeD7 = porta.getNome();
                }
                listaPortaBanco = new PortaDAO(AutomacaoActivity.this).listaPorta(6);
                for(Porta porta : listaPortaBanco){
                    nomeA0 = porta.getNome();
                }
                listaPortaBanco = new PortaDAO(AutomacaoActivity.this).listaPorta(7);
                for(Porta porta : listaPortaBanco){
                    nomeA1 = porta.getNome();
                }
                listaPortaBanco = new PortaDAO(AutomacaoActivity.this).listaPorta(8);
                for(Porta porta : listaPortaBanco){
                    nomeA2 = porta.getNome();
                }
                listaPortaBanco = new PortaDAO(AutomacaoActivity.this).listaPorta(9);
                for(Porta porta : listaPortaBanco){
                    nomeA3 = porta.getNome();
                }
                listaPortaBanco = new PortaDAO(AutomacaoActivity.this).listaPorta(10);
                for(Porta porta : listaPortaBanco){
                    nomeA4 = porta.getNome();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                tvNomeD2.setText(nomeD2);
                tvNomeD3.setText(nomeD3);
                tvNomeD5.setText(nomeD5);
                tvNomeD6.setText(nomeD6);
                tvNomeD7.setText(nomeD7);
                tvNomeA0.setText(nomeA0);
                tvNomeA1.setText(nomeA1);
                tvNomeA2.setText(nomeA2);
                tvNomeA3.setText(nomeA3);
                tvNomeA4.setText(nomeA4);
                super.onPostExecute(aVoid);
            }
        };
        executaTrem.execute((Void[]) null);
    }

    @Override
    public void onResume() {
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            endereco = bundle.getString("_ENDERECO_");
            porta = bundle.getString("_PORTA_");
            palavra = bundle.getString("_PALAVRA_");
        }
        nome_das_portas();
        carregando_portas();
        mostra_situacao2();
        mostra_situacao3();
        mostra_situacao5();
        mostra_situacao6();
        mostra_situacao7();
        mostra_situacaoA0();
        mostra_situacaoA1();
        mostra_situacaoA2();
        mostra_situacaoA3();
        mostra_situacaoA4();
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_automacao, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mnPrincipal) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}