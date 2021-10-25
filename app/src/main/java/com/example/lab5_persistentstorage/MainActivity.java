package com.example.lab5_persistentstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String usernameKey = "username";

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.lab5_persistentstorage", Context.MODE_PRIVATE);

        if (!sharedPreferences.getString(usernameKey, "").equals("")) {
            String username = sharedPreferences.getString(usernameKey, "");
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra(usernameKey, username);
            startActivity(intent);
        } else {
            setContentView(R.layout.activity_main);
        }
    }

    public void goToActivity2(View view) {
        EditText usernameTextField = (EditText) findViewById(R.id.usernameText);
        String usernameStr = usernameTextField.getText().toString();

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.lab5_persistentstorage", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", usernameStr).apply();
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("username", usernameStr);
        startActivity(intent);
    }


}