package com.example.marketpayment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onDefaultToggleClick(View view)
    {
        Intent intent = new Intent(MainActivity.this,Registration.class);
        startActivity(intent);

        Toast.makeText(this,"default toggle",Toast.LENGTH_LONG).show();
    }

    public void SignIN(View view)
    {
        Intent intent = new Intent(this,MainPageActivity.class);
        startActivity(intent);


    }
}