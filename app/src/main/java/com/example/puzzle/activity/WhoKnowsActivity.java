package com.example.puzzle.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.puzzle.R;

public class WhoKnowsActivity extends Activity {

    private TextView mTitleTextView;
    private TextView mDescriptionTextView;
    private TextView mTimerTextView;
    private TextView mScoreTextView;
    private TextView mQuestionTextView;
    private RadioGroup mAnswersRadioGroup;
    private RadioButton mAnswerARadioButton;
    private RadioButton mAnswerBRadioButton;
    private RadioButton mAnswerCRadioButton;
    private RadioButton mAnswerDRadioButton;
    private Button mSubmitButton;
    private Button mNextButton;

    private int mQuestionNumber;
    private int mScore;
    private boolean mAnswered;
    private boolean mIsCorrect;
    private long mTimeLeft;
   // private QuestionBank mQuestionBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.who_knows_knows);

        mTitleTextView = findViewById(R.id.title_text_view);
        mDescriptionTextView = findViewById(R.id.description_text_view);
        mTimerTextView = findViewById(R.id.timer_text_view);
        mScoreTextView = findViewById(R.id.score_text_view);
        mQuestionTextView = findViewById(R.id.question_text_view);
        mAnswersRadioGroup = findViewById(R.id.answers_radio_group);
        mAnswerARadioButton = findViewById(R.id.answer_a_radio_button);
        mAnswerBRadioButton = findViewById(R.id.answer_b_radio_button);
        mAnswerCRadioButton = findViewById(R.id.answer_c_radio_button);
        mAnswerDRadioButton = findViewById(R.id.answer_d_radio_button);
        mSubmitButton = findViewById(R.id.submit_button);
        mNextButton = findViewById(R.id.next_button);

      //  mQuestionBank = new QuestionBank();

        mQuestionNumber = 0;
        mScore = 0;
        mAnswered = false;
        mIsCorrect = false;

        //showQuestion();
    }


}
