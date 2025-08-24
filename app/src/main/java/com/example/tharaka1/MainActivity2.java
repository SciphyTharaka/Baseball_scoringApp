package com.example.tharaka1;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView = findViewById(R.id.welcomeText);
        String role = getIntent().getStringExtra("role");

        if (role == null) role = "guest";

        // Clean the string
        role = role.trim().toLowerCase();

        // Debugging
        Toast.makeText(this, "Role received: " + role, Toast.LENGTH_LONG).show();

        switch (role) {
            case "admin":
                textView.setText("Welcome admin to account");
                break;
            case "coach":
                textView.setText("Welcome coach account");
                break;
            case "player":
                textView.setText("Welcome player account");
                break;
            default:
                textView.setText("Welcome guest account");
                break;
        }
    }
}
