package com.example.tharaka1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    EditText emailField, passwordField;
    Button loginBtn, registerBtn;
    FirebaseAuth mAuth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        emailField = findViewById(R.id.send);
        passwordField = findViewById(R.id.passwordField);
        loginBtn = findViewById(R.id.myButton);
        registerBtn = findViewById(R.id.registerBtn);

        // LOGIN BUTTON
        loginBtn.setOnClickListener(v -> {
            String email = emailField.getText().toString().trim();
            String password = passwordField.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null) {
                                String uid = user.getUid();
                                // Fetch role from Firestore
                                db.collection("users").document(uid).get()
                                        .addOnSuccessListener(doc -> {
                                            if (doc.exists()) {
                                                String role = doc.getString("role");
                                                if (role == null) role = "guest";

                                                // Debugging
                                                Toast.makeText(this, "Fetched role: " + role, Toast.LENGTH_SHORT).show();

                                                // Role-based navigation
                                                Intent intent;
                                                switch (role.toLowerCase()) {
                                                    case "admin":
                                                        intent = new Intent(MainActivity.this, MainActivity3_admin.class);
                                                        break;
                                                    case "coach":
                                                        intent = new Intent(MainActivity.this,MainActivity4_coach.class);
                                                        break;
                                                    //case "player":
                                                      //  intent = new Intent(MainActivity.this, PlayerDashboard.class);
                                                       // break;
                                                    default:
                                                        intent = new Intent(MainActivity.this, MainActivity5_user.class);
                                                        break;
                                                }

                                                startActivity(intent);
                                                finish();

                                            } else {
                                                Toast.makeText(this, "No Firestore document found for this user", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .addOnFailureListener(e ->
                                                Toast.makeText(this, "Error getting role: " + e.getMessage(), Toast.LENGTH_SHORT).show()
                                        );
                            }
                        } else {
                            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                        }
                    });
        });

        // REGISTER BUTTON (new users default to guest)
        registerBtn.setOnClickListener(v -> {
            String email = emailField.getText().toString().trim();
            String password = passwordField.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                return;
            }
            if (password.length() < 6) {
                Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null) {
                                String uid = user.getUid();
                                db.collection("users").document(uid).set(new User(email, "guest"))
                                        .addOnSuccessListener(aVoid ->
                                                Toast.makeText(this, "Registration successful (role: guest)", Toast.LENGTH_SHORT).show()
                                        )
                                        .addOnFailureListener(e ->
                                                Toast.makeText(this, "Error saving user role: " + e.getMessage(), Toast.LENGTH_SHORT).show()
                                        );
                            }
                        } else {
                            Toast.makeText(this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }

    // Helper class for saving user data
    public static class User {
        public String email;
        public String role;

        public User() {} // empty constructor needed for Firestore

        public User(String email, String role) {
            this.email = email;
            this.role = role;
        }
    }
}
