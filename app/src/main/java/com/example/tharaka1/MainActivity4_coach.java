package com.example.tharaka1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4_coach extends AppCompatActivity {

    Button viewPlayerProfile, viewLeaderBoard, editPracticeSchedule,
            watchLiveScore, previousGameStat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4_coach);

        // Initialize buttons
        viewPlayerProfile = findViewById(R.id.view_player_profile_coach);
        viewLeaderBoard = findViewById(R.id.view_leader_board_coach);
        editPracticeSchedule = findViewById(R.id.edit_practice_schedule_coach);
        watchLiveScore = findViewById(R.id.watch_live_score_coach);
        previousGameStat = findViewById(R.id.previous_game_stat_coach);

        // Example click listeners (replace with real functionality later)
        viewPlayerProfile.setOnClickListener(v ->
                Toast.makeText(this, "View Player Profiles clicked", Toast.LENGTH_SHORT).show());

        viewLeaderBoard.setOnClickListener(v ->
                Toast.makeText(this, "View Leaderboard clicked", Toast.LENGTH_SHORT).show());

        editPracticeSchedule.setOnClickListener(v ->
                Toast.makeText(this, "Edit/View Practice Schedule clicked", Toast.LENGTH_SHORT).show());

        watchLiveScore.setOnClickListener(v ->
                Toast.makeText(this, "Watch Live Score clicked", Toast.LENGTH_SHORT).show());

        previousGameStat.setOnClickListener(v ->
                Toast.makeText(this, "Previous Games Stat clicked", Toast.LENGTH_SHORT).show());
    }
}
