package com.example.tharaka1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3_admin extends AppCompatActivity {

    Button editPlayerProfile, markAttendance, leaderBoardManagement,
            editPracticeSchedule, gameScoring, dbManagement, editMatchSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_admin);

        // Initialize buttons
        editPlayerProfile = findViewById(R.id.edit_player_profile);
        markAttendance = findViewById(R.id.mark_attendance);
        leaderBoardManagement = findViewById(R.id.leader_board_management);
        editPracticeSchedule = findViewById(R.id.edit_practice_schedule);
        gameScoring = findViewById(R.id.game_scoring);
        dbManagement = findViewById(R.id.db_management);
        editMatchSchedule = findViewById(R.id.edit_match_shedule);

        // Example click listeners (for testing)
        editPlayerProfile.setOnClickListener(v ->
                Toast.makeText(this, "Edit Player Profile clicked", Toast.LENGTH_SHORT).show());

        markAttendance.setOnClickListener(v ->
                Toast.makeText(this, "Mark Attendance clicked", Toast.LENGTH_SHORT).show());

        leaderBoardManagement.setOnClickListener(v ->
                Toast.makeText(this, "Leaderboard Management clicked", Toast.LENGTH_SHORT).show());

        editPracticeSchedule.setOnClickListener(v ->
                Toast.makeText(this, "Edit Practice Schedule clicked", Toast.LENGTH_SHORT).show());

        gameScoring.setOnClickListener(v ->
                Toast.makeText(this, "Live Game Scoring clicked", Toast.LENGTH_SHORT).show());

        dbManagement.setOnClickListener(v ->
                Toast.makeText(this, "Database Management clicked", Toast.LENGTH_SHORT).show());

        editMatchSchedule.setOnClickListener(v ->
                Toast.makeText(this, "Edit Match Schedule clicked", Toast.LENGTH_SHORT).show());
    }
}
