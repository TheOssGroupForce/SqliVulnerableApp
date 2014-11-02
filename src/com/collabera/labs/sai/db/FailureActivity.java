package com.collabera.labs.sai.db;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by res on 29/9/14.
 */
public class FailureActivity extends Activity {
    TextView t1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        t1 = (TextView) findViewById(R.id.details);
        t1.setText("Failed");
    }
}