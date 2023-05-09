package com.example.puzzle.model;

public class User {

    private String _email;
    private String _username;
    private String _password;
    private String _tokens;
    private String _brojPartija;
    private String _procenatPobeda;
    private String _poeniAsocijacije;
    private String _poeniPovezivanje;
    private String _poeniKoZnaZna;
    private String _poeniSkocko;
    private String _poeniMojBroj;
    private String _poeniKorakPoKorak;
    private String _brojZvezda;



    public User() {
    }

    public User(String _email, String _username, String _password, String _tokens, String _brojPartija, String _procenatPobeda, String _poeniAsocijacije, String _poeniPovezivanje, String _poeniKoZnaZna, String _poeniSkocko, String _poeniMojBroj, String _poeniKorakPoKorak, String _brojZvezda) {
        this._email = _email;
        this._username = _username;
        this._password = _password;
        this._tokens = _tokens;
        this._brojPartija = _brojPartija;
        this._procenatPobeda = _procenatPobeda;
        this._poeniAsocijacije = _poeniAsocijacije;
        this._poeniPovezivanje = _poeniPovezivanje;
        this._poeniKoZnaZna = _poeniKoZnaZna;
        this._poeniSkocko = _poeniSkocko;
        this._poeniMojBroj = _poeniMojBroj;
        this._poeniKorakPoKorak = _poeniKorakPoKorak;
        this._brojZvezda = _brojZvezda;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_username() {
        return _username;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public String get_tokens() {
        return _tokens;
    }

    public void set_tokens(String _tokens) {
        this._tokens = _tokens;
    }

    public String get_brojPartija() {
        return _brojPartija;
    }

    public void set_brojPartija(String _brojPartija) {
        this._brojPartija = _brojPartija;
    }

    public String get_procenatPobeda() {
        return _procenatPobeda;
    }

    public void set_procenatPobeda(String _procenatPobeda) {
        this._procenatPobeda = _procenatPobeda;
    }

    public String get_poeniAsocijacije() {
        return _poeniAsocijacije;
    }

    public void set_poeniAsocijacije(String _poeniAsocijacije) {
        this._poeniAsocijacije = _poeniAsocijacije;
    }

    public String get_poeniPovezivanje() {
        return _poeniPovezivanje;
    }

    public void set_poeniPovezivanje(String _poeniPovezivanje) {
        this._poeniPovezivanje = _poeniPovezivanje;
    }

    public String get_poeniKoZnaZna() {
        return _poeniKoZnaZna;
    }

    public void set_poeniKoZnaZna(String _poeniKoZnaZna) {
        this._poeniKoZnaZna = _poeniKoZnaZna;
    }

    public String get_poeniSkocko() {
        return _poeniSkocko;
    }

    public void set_poeniSkocko(String _poeniSkocko) {
        this._poeniSkocko = _poeniSkocko;
    }

    public String get_poeniMojBroj() {
        return _poeniMojBroj;
    }

    public void set_poeniMojBroj(String _poeniMojBroj) {
        this._poeniMojBroj = _poeniMojBroj;
    }

    public String get_poeniKorakPoKorak() {
        return _poeniKorakPoKorak;
    }

    public void set_poeniKorakPoKorak(String _poeniKorakPoKorak) {
        this._poeniKorakPoKorak = _poeniKorakPoKorak;
    }

    public String get_brojZvezda() {
        return _brojZvezda;
    }

    public void set_brojZvezda(String _brojZvezda) {
        this._brojZvezda = _brojZvezda;
    }
}
