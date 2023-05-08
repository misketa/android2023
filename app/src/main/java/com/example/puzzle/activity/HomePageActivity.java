package com.example.puzzle.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;


import com.example.puzzle.MainActivity;
import com.example.puzzle.R;

public class HomePageActivity extends Activity {

    private ImageButton logoutButton;
    private Button profileButton, friendsListButton, rangListButton, startGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // Initialize buttons
        logoutButton = findViewById(R.id.logout_button);
        profileButton = findViewById(R.id.profile_button);
        friendsListButton = findViewById(R.id.friends_list_button);
        rangListButton = findViewById(R.id.rang_list_button);
        startGameButton = findViewById(R.id.start_game_button);

        // Set onClickListeners for buttons
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle logout and redirect user to MainActivity
                Intent intent = new Intent(HomePageActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect user to Profile page
                Intent intent = new Intent(HomePageActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        friendsListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect user to FriendsList page
                Intent intent = new Intent(HomePageActivity.this, FriendsListActivity.class);
                startActivity(intent);
            }
        });

        rangListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect user to RangList page
                Intent intent = new Intent(HomePageActivity.this, RangListActivity.class);
                startActivity(intent);
            }
        });

        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect user to GamesNavigation page
                Intent intent = new Intent(HomePageActivity.this, GamesNavigationActivity.class);
                startActivity(intent);
            }
        });

        // Initialize dropdown menu for logout button
        PopupMenu popupMenu = new PopupMenu(this, logoutButton);
        popupMenu.getMenuInflater().inflate(R.menu.logout_menu, popupMenu.getMenu());

        // Set onMenuItemClickListener for logout button
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Handle logout and redirect user to MainActivity
                Intent intent = new Intent(HomePageActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;
            }
        });

        // Set onClickListener for logout button to show dropdown menu
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu.show();
            }
        });
    }
}


