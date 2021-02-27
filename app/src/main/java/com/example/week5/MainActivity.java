package com.example.week5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {





    TextView tv;
    MyViewModel viewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv = findViewById(R.id.increamentTV);



        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.getNumber().observe(this, currentValue -> {
            Log.d("TAG" , "" + currentValue);
        });
        int number = viewModel.getValue();

        tv.setText(String.valueOf(number));




    }

    public void increamentValue(View view){

        viewModel.increament();

        viewModel.increamentNumber();

        int number = viewModel.getValue();
        tv.setText(String.valueOf(number));




    }

    public void showAlertDialog(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(" Title ").setMessage(" Delete the image ").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNeutralButton("Remind Me", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Remind me", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();

        alertDialog.show();



    }
}