package com.example.mohammed.qa_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.mohammed.qa_app.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Save info button */
    public void saveInfo(View view) {/*
        SharedPreferences settings = getSharedPreferences(R.string.saved_data, 0);
        String first_name = settings.getString("first_name", false);
        String last_name  = settings.getString("last_name", false);
        String phone_number = settings.getString("phone_number", false);
        String passport_issue = settings.getString("passport_issue", false);
        String pasport_expiry = settings.getString("passport_expiry", false);
        String location = settings.getString("location", false);*/
    }

    /** Called when the user taps the Send info button */
    public void sendInfo(View view) {
        Intent intent = new Intent(this, SendInfoActivity.class);
        EditText editText = (EditText) findViewById(R.id.first_name);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    protected void onStop(){
        super.onStop();

        SharedPreferences settings = getSharedPreferences(String.valueOf(R.string.saved_data), 0);
        SharedPreferences.Editor editor = settings.edit();

        // Commit the edits!
        editor.commit();
    }
}
