package com.example.scrollingtext_task13;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class EditarTexto extends AppCompatActivity {



        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_secundario);
            EditText edit2 = findViewById(R.id.editText02);
            edit2.setVisibility(View.VISIBLE);

            Intent receivedIntent = getIntent();
            String receivedString = receivedIntent.getStringExtra("ARTICULO");
            edit2.setText(receivedString);

        }
            @Override
            public void onBackPressed() {
                new AlertDialog.Builder(this)
                        .setTitle("Confirm Exit")
                        .setMessage("Are you sure you want to go back?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditarTexto.super.onBackPressed(); // Call the default behavior
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }



}
