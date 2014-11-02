package com.collabera.labs.sai.db;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CRUDonDB extends Activity {
	
	private final String SAMPLE_DB_NAME = "myFriendsDb";
	private final String SAMPLE_TABLE_NAME = "friends";
    ArrayList<String> results = new ArrayList<String>();
    SQLiteDatabase sampleDB = null;
    
    EditText uName,uPass;
    Button submit;
    
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crudondb);
    	sampleDB =  this.openOrCreateDatabase(SAMPLE_DB_NAME, MODE_PRIVATE, null);

    	uName = (EditText) findViewById(R.id.userName);
    	uPass = (EditText) findViewById(R.id.passWord);
    	
    	submit =  (Button) findViewById(R.id.submit);
    	
    	
    	submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplication(), "tesxt"+uName.getText().toString()+uPass.getText().toString(), Toast.LENGTH_LONG).show();
				doAuth(uName.getText().toString(),uPass.getText().toString());
				
			}

		
		});

        try {
        	sampleDB.execSQL("CREATE TABLE IF NOT EXISTS " +
        			SAMPLE_TABLE_NAME +
        			" (LastName VARCHAR, FirstName VARCHAR" +");");
        	
        	sampleDB.execSQL("INSERT INTO " +
        			SAMPLE_TABLE_NAME +
        			" Values ('anto','joseph');");
        	sampleDB.execSQL("INSERT INTO " +
        			SAMPLE_TABLE_NAME +
        			" Values ('Chittur','Raman');");
        	sampleDB.execSQL("INSERT INTO " +
        			SAMPLE_TABLE_NAME +
        			" Values ('Solutions','Collabera');");

        	
        } catch (SQLiteException se ) {
        	Log.e(getClass().getSimpleName(), "Could not create or Open the database");
        } finally {
//        	if (sampleDB != null)
//        		sampleDB.execSQL("DELETE FROM " + SAMPLE_TABLE_NAME);
        		//sampleDB.close();
        }
    }
    
 	void doAuth(String string, String string2) {
		// TODO Auto-generated method stub
    	Cursor c = sampleDB.rawQuery("SELECT LastName,FirstName FROM " +
    			SAMPLE_TABLE_NAME +
    			" where LastName='"+string+"'"+" and FirstName='"+string2+"';", null);


    	if (c != null  && c.getCount()>0) {
            c.moveToFirst();
            Intent i = new Intent(getApplicationContext(), ResultActivity.class);
            i.putExtra("Name",c.getString(0));
            i.putExtra("Pass",c.getString(1));
            startActivity(i);
        }else{
            Intent i = new Intent(getApplicationContext(), FailureActivity.class);
            startActivity(i);
        }
 	}

	}
	
