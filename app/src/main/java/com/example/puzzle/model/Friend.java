package com.example.puzzle.model;

public class Friend {

    private String _username;
    private int _numberOfStars;

    public Friend() {
    }

    public Friend(String _username, int _numberOfStars) {
        this._username = _username;
        this._numberOfStars = _numberOfStars;
    }

    public String get_username() {
        return _username;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public int get_numberOfStars() {
        return _numberOfStars;
    }

    public void set_numberOfStars(int _numberOfStars) {
        this._numberOfStars = _numberOfStars;
    }
}
