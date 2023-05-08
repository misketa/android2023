package com.example.puzzle.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.puzzle.R;

public class GamesNavigationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.games_navigation_layout);

        Button whoKnowsButton = findViewById(R.id.who_knows_button);
        Button linkItButton = findViewById(R.id.link_it_button);
        Button associationsButton = findViewById(R.id.associations_button);

        whoKnowsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GamesNavigationActivity.this, WhoKnowsActivity.class);
                startActivity(intent);
            }
        });

        linkItButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GamesNavigationActivity.this, LinkItActivity.class);
                startActivity(intent);
            }
        });

        associationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GamesNavigationActivity.this, AssociationsActivity.class);
                startActivity(intent);
            }
        });
    }
}
