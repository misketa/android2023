package com.example.puzzle.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.puzzle.R;
import com.example.puzzle.model.Friend;

import java.util.ArrayList;

public class FriendListAdapter extends ArrayAdapter<Friend> {

    private ArrayList<Friend> friendList;
    private Context context;

    public FriendListAdapter(Context context, int friend_list_item, ArrayList<Friend> friendList) {
        super(context, 0, friendList);
        this.friendList = friendList;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.friend_list_item, parent, false);
        }

        TextView usernameTextView = convertView.findViewById(R.id.username_text_view);
        TextView numberOfStarsTextView = convertView.findViewById(R.id.number_of_stars_text_view);

        Friend friend = friendList.get(position);

        usernameTextView.setText(friend.get_username());
        numberOfStarsTextView.setText(String.valueOf(friend.get_numberOfStars()));

        return convertView;
    }
}

