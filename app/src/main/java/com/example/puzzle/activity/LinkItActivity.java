package com.example.puzzle.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.puzzle.R;

public class LinkItActivity extends Activity {

    // Left column of terms
    private TextView leftTerm1;
    private TextView leftTerm2;
    private TextView leftTerm3;
    private TextView leftTerm4;
    private TextView leftTerm5;

    // Right column of terms
    private TextView rightTerm1;
    private TextView rightTerm2;
    private TextView rightTerm3;
    private TextView rightTerm4;
    private TextView rightTerm5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.link_it);

        // Get references to TextViews
        leftTerm1 = findViewById(R.id.left_term_1);
        leftTerm2 = findViewById(R.id.left_term_2);
        leftTerm3 = findViewById(R.id.left_term_3);
        leftTerm4 = findViewById(R.id.left_term_4);
        leftTerm5 = findViewById(R.id.left_term_5);

        rightTerm1 = findViewById(R.id.right_term_1);
        rightTerm2 = findViewById(R.id.right_term_2);
        rightTerm3 = findViewById(R.id.right_term_3);
        rightTerm4 = findViewById(R.id.right_term_4);
        rightTerm5 = findViewById(R.id.right_term_5);
    }
}

