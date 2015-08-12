package br.com.hisamoto.threadAsyncTask;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MyActivity extends Activity {

    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textView = (TextView) findViewById(R.id.campo);

        ThreadAsyncTask threadAsyncTask = new ThreadAsyncTask(getApplicationContext(), textView);

        Bundle bundle = new Bundle();
        bundle.putString("msg", "Passando parâmetro para o processamento");

        threadAsyncTask.execute(bundle);
    }
}
