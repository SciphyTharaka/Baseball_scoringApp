package com.example.tharaka1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5_user extends AppCompatActivity {

    Button watchLiveScore, matchSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity5_user);

        // Initialize buttons
        watchLiveScore = findViewById(R.id.watch_live_score_user);
        matchSchedule = findViewById(R.id.match_schedule_user);

        // Example click listeners (replace with real features later)
        watchLiveScore.setOnClickListener(v ->
                Toast.makeText(this, "Watch Live Score clicked", Toast.LENGTH_SHORT).show());

        matchSchedule.setOnClickListener(v ->
                Toast.makeText(this, "Match Schedule clicked", Toast.LENGTH_SHORT).show());
    }
}
