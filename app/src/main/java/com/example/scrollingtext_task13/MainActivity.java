package com.example.scrollingtext_task13;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final Button rb1 = findViewById(R.id.comment);
        final EditText edit = findViewById(R.id.editText01);
        final TextView article = findViewById(R.id.article);

        rb1.setOnClickListener(v -> comprobarVisibilidad(rb1, edit, article));

    }

    protected void comprobarVisibilidad(Button rb1, EditText edit, TextView article) {

        Log.d("MainActivity", "Button is activated");

        if (edit.getVisibility() == View.INVISIBLE) {
            edit.setVisibility(View.VISIBLE);
            rb1.setText("Insert comment");
        } else {
            edit.setVisibility(View.INVISIBLE);
            article.append(""+edit.getText());
            rb1.setText("Add a comment");

        }
    }


}