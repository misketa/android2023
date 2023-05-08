package com.example.puzzle.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.puzzle.R;

public class AssociationsActivity extends Activity {

    private EditText answerEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.associations);

        // Round timer
        TextView tvRoundTimer = findViewById(R.id.tv_round_timer);
        tvRoundTimer.setText("2:00");

        // Maximum points and current points
        TextView tvMaxPoints = findViewById(R.id.tv_max_points);
        tvMaxPoints.setText("Max Points: 60");

        TextView tvCurrentPoints = findViewById(R.id.tv_current_points);
        tvCurrentPoints.setText("Current Points: 0");

        // Column layout
        GridLayout gridColumns = findViewById(R.id.grid_columns);

        // Column 1
        LinearLayout llColumn1 = findViewById(R.id.ll_column1);

        LinearLayout llColumn1Boxes = findViewById(R.id.ll_column1_boxes);
        TextView tvColumn1Box1 = findViewById(R.id.tv_column1_box1);
        TextView tvColumn1Box2 = findViewById(R.id.tv_column1_box2);
        TextView tvColumn1Box3 = findViewById(R.id.tv_column1_box3);
        TextView tvColumn1Box4 = findViewById(R.id.tv_column1_box4);

        TextView tvColumn1Solution = findViewById(R.id.tv_column1_solution);

        // Column 2
        LinearLayout llColumn2 = findViewById(R.id.ll_column2);

        LinearLayout llColumn2Boxes = findViewById(R.id.ll_column2_boxes);
        TextView tvColumn2Box1 = findViewById(R.id.tv_column2_box1);
        TextView tvColumn2Box2 = findViewById(R.id.tv_column2_box2);
        TextView tvColumn2Box3 = findViewById(R.id.tv_column2_box3);
        TextView tvColumn2Box4 = findViewById(R.id.tv_column2_box4);

        TextView tvColumn2Solution = findViewById(R.id.tv_column2_solution);

        // Column 3
        LinearLayout llColumn3 = findViewById(R.id.ll_column3);

        LinearLayout llColumn3Boxes = findViewById(R.id.ll_column3_boxes);
        TextView tvColumn3Box1 = findViewById(R.id.tv_column3_box1);
        TextView tvColumn3Box2 = findViewById(R.id.tv_column3_box2);
        TextView tvColumn3Box3 = findViewById(R.id.tv_column3_box3);
        TextView tvColumn3Box4 = findViewById(R.id.tv_column3_box4);

        TextView tvColumn3Solution = findViewById(R.id.tv_column3_solution);

        // Column 4
        LinearLayout llColumn4 = findViewById(R.id.ll_column4);

        LinearLayout llColumn4Boxes = findViewById(R.id.ll_column4_boxes);
        TextView tvColumn4Box1 = findViewById(R.id.tv_column4_box1);
        TextView tvColumn4Box2 = findViewById(R.id.tv_column4_box2);
        TextView tvColumn4Box3 = findViewById(R.id.tv_column4_box3);
        TextView tvColumn4Box4 = findViewById(R.id.tv_column4_box4);

        TextView tvColumn4Solution = findViewById(R.id.tv_column4_solution);

        answerEditText = findViewById(R.id.answer_edit_text);

        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = answerEditText.getText().toString();
                // Do something with the answer
            }
        });
    }
}

