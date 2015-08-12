package br.com.hisamoto.threadAsyncTask;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Leandro Shindi Ekamoto
 * @version 1.0 12/08/15.
 * AsyncTask <Parâmetro doInBackground, Parâmetro para onProgressUpdate, Retorno doInBackground>
 */
public class ThreadAsyncTask extends AsyncTask<Bundle, Bundle, Void> {

    private TextView textView;
    private Context context;
    private boolean process;
    private int cont;

    public ThreadAsyncTask(Context context, TextView textView) {

        this.textView = textView;
        this.context = context;
        this.process = true;
        this.cont = 1;
    }

    @Override
    protected Void doInBackground(Bundle... params) {

        Log.i("Hisamoto","" + params[0].get("msg"));

        while(process) {

            Bundle bundle = new Bundle();

            if(cont%2 == 0) {

                bundle.putString("nome", "Leandro");
            } else {

                bundle.putString("nome", "Priscila");
            }

            bundle.putString("cont", "" + cont);

            publishProgress(bundle);
            try {

                Thread.sleep(10000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            cont++;
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Bundle... values) {

        Toast.makeText(context, "Nome["+values[0].get("cont") + "]: " + values[0].get("nome"), Toast.LENGTH_LONG).show();
        this.textView.setText(values[0].get("nome").toString());

        if(this.cont == 5) {

            Toast.makeText(context, "Parando processo", Toast.LENGTH_LONG).show();
            this.process =false;
        }

    }
}
