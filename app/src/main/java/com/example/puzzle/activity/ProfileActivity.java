package com.example.puzzle.activity;

import android.app.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.puzzle.MainActivity;
import com.example.puzzle.R;
import com.example.puzzle.database.MyDatabaseHelper;

public class ProfileActivity extends Activity {

    private TextView usernameEditText, emailEditText, brojPartijaEditText, procenatPobedaEditText, poeniAsocijacijeEditText,poeniPovezivanjeEditText
            ,poeniKoZnaZnaEditText ,poeniSkockoEditText , poeniMojBrojEditText, poeniKorakPoKorakEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize UI elements
        usernameEditText = findViewById(R.id.username_text_view);
        emailEditText = findViewById(R.id.email_text_view);
        brojPartijaEditText = findViewById(R.id.brojPartija);
        procenatPobedaEditText = findViewById(R.id.procenatPobeda);
        poeniAsocijacijeEditText = findViewById(R.id.poeniAsocijacije);
        poeniPovezivanjeEditText = findViewById(R.id.poeniPovezivnaje);
        poeniKoZnaZnaEditText = findViewById(R.id.poeniKoZnaZna);
        poeniSkockoEditText = findViewById(R.id.poeniSkocko);
        poeniMojBrojEditText = findViewById(R.id.poeniMojBroj);
        poeniKorakPoKorakEditText = findViewById(R.id.poeniKorakPoKorak);

        populateProfileFields();
    }


    private void populateProfileFields() {
        // Get the email address of the currently logged-in user from the database
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String currentUserEmail = dbHelper.getCurrentUserEmail(db);

        // Query the user table to retrieve the data for the currently logged-in user
        String[] projection = {
                MyDatabaseHelper.COLUMN_USERNAME,
                MyDatabaseHelper.COLUMN_EMAIL,
                MyDatabaseHelper.COLUMN_BROJ_PARTIJA,
                MyDatabaseHelper.COLUMN_PROCENAT_POBEDA,
                MyDatabaseHelper.COLUMN_POENI_ASOCIJACIJE,
                MyDatabaseHelper.COLUMN_POENI_POVEZIVANJE,
                MyDatabaseHelper.COLUMN_POENI_KOZNAZNA,
                MyDatabaseHelper.COLUMN_POENI_SKOCKO,
                MyDatabaseHelper.COLUMN_POENI_MOJ_BROJ,
                MyDatabaseHelper.COLUMN_POENI_KORAK_PO_KORAK
        };
        String selection = MyDatabaseHelper.COLUMN_EMAIL + " = ?";
        String[] selectionArgs = { currentUserEmail };
        Cursor cursor = db.query(
                MyDatabaseHelper.TABLE_USER,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        // Populate the text fields with the retrieved data
        if (cursor.moveToFirst()) {
            usernameEditText.setText(cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.COLUMN_USERNAME)));
            emailEditText.setText(cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.COLUMN_EMAIL)));
            brojPartijaEditText.setText(cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.COLUMN_BROJ_PARTIJA)));
            procenatPobedaEditText.setText(cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.COLUMN_PROCENAT_POBEDA)));
            poeniAsocijacijeEditText.setText(cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.COLUMN_POENI_ASOCIJACIJE)));
            poeniPovezivanjeEditText.setText(cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.COLUMN_POENI_POVEZIVANJE)));
            poeniKoZnaZnaEditText.setText(cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.COLUMN_POENI_KOZNAZNA)));
            poeniSkockoEditText.setText(cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.COLUMN_POENI_SKOCKO)));
            poeniMojBrojEditText.setText(cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.COLUMN_POENI_MOJ_BROJ)));
            poeniKorakPoKorakEditText.setText(cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.COLUMN_POENI_KORAK_PO_KORAK)));
        }

        // Close the cursor and database
        cursor.close();
        db.close();
    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_logout) {
            // Handle logout button click here
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

