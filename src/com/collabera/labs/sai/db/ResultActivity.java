package com.collabera.labs.sai.db;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by res on 28/9/14.
 */
public class ResultActivity extends Activity {

    TextView t1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        t1 = (TextView) findViewById(R.id.details);
        Intent i = getIntent();
        String user = i.getStringExtra("Name");
        String pass = i.getStringExtra("Pass");

        t1.setText("Logged in as "+user+ " with password: "+ pass);


    }
}