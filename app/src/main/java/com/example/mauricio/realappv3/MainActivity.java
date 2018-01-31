package com.example.mauricio.realappv3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etPhoneNumber;
    private Spinner spnCountryCode;
    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView Image = (ImageView) findViewById(R.id.imgReal);
        Spinner spnCountryCode = (Spinner)findViewById(R.id.spinner);
        btnSiguiente = (Button)findViewById(R.id.btnSiguiente);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animlogo);
        Image.startAnimation(animation);
        try{
            etPhoneNumber  = (EditText)findViewById(R.id.etPhoneNumber);
            ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.CountryCodes, R.layout.spinner_item);
            spnCountryCode.setAdapter(adapter);
        }catch (Exception e){
            Toast.makeText(this,"Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CodePhoneActivity.class);
                startActivity(i);
            }
        });
    }
}