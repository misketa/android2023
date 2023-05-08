package com.example.puzzle.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.puzzle.R;
import com.example.puzzle.adapters.FriendListAdapter;
import com.example.puzzle.model.Friend;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FriendsListActivity extends Activity {

    private ArrayList<Friend> friendList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);

        // Initialize the friend list with dummy data
        friendList = new ArrayList<>();
        friendList.add(new Friend("John Doe", 102));
        friendList.add(new Friend("Jane Smith", 87));
        friendList.add(new Friend("Bob Johnson", 72));
        friendList.add(new Friend("Alice Williams", 56));
        friendList.add(new Friend("Tom Davis", 33));

        // Initialize the ListView and set its adapter to a custom adapter for friend list items
        listView = findViewById(R.id.list_view);
        FriendListAdapter adapter = new FriendListAdapter(this, R.layout.friend_list_item, friendList);
        listView.setAdapter(adapter);

        // Set click listener for the floating action button to add new friends
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddFriendDialog();
            }
        });
    }

    private void showAddFriendDialog() {
        // Create a dialog for adding new friends
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Friend");

        // Inflate the layout for the dialog and retrieve the EditText fields
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_friend, null);
        final EditText usernameEditText = dialogView.findViewById(R.id.username_edit_text);
        final EditText starsEditText = dialogView.findViewById(R.id.stars_edit_text);

        builder.setView(dialogView);

        // Set up the buttons for adding a new friend or cancelling the dialog
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String username = usernameEditText.getText().toString().trim();
                String starsString = starsEditText.getText().toString().trim();
                int stars = 0;

                if (!username.isEmpty() && !starsString.isEmpty()) {
                    try {
                        stars = Integer.parseInt(starsString);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }

                    Friend friend = new Friend(username, stars);
                    friendList.add(friend);

                    // Notify the adapter of the new friend added to the list
                    ((FriendListAdapter) listView.getAdapter()).notifyDataSetChanged();
                }

                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // Show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

