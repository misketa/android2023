package com.example.puzzle.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.puzzle.MainActivity;
import com.example.puzzle.R;
import com.example.puzzle.database.MyDatabaseHelper;

public class RegistrationActivity extends Activity {

    private EditText emailEditText, usernameEditText, passwordEditText;
    private Button registerButton;

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Initialize UI elements
        emailEditText = findViewById(R.id.email_edit_text);
        usernameEditText = findViewById(R.id.username_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        registerButton = findViewById(R.id.register_button);

        dbHelper = new MyDatabaseHelper(this);



        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString().trim();
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Check if email already exists in the database
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                String[] projection = {MyDatabaseHelper.COLUMN_EMAIL};
                String selection = MyDatabaseHelper.COLUMN_EMAIL + " = ?";
                String[] selectionArgs = {email};
                Cursor cursor = db.query(MyDatabaseHelper.TABLE_USER, projection, selection, selectionArgs, null, null, null);
                boolean emailExists = cursor.getCount() > 0;
                cursor.close();
                db.close();

                if (emailExists) {
                    // If email already exists, display an error message
                    Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT).show();
                } else {
                    // If email does not exist, insert the user into the database
                    dbHelper.insertData(email, username, password);


                    // Display a success message and redirect to MainActivity
                    Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Close the database connection when the activity is destroyed
        dbHelper.close();
    }
 /* registerButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String email = emailEditText.getText().toString().trim();
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        int tokens = 5; // set default tokens value to 5

        // Check if email already exists in the database
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {MyDatabaseHelper.COLUMN_EMAIL};
        String selection = MyDatabaseHelper.COLUMN_EMAIL + " = ?";
        String[] selectionArgs = {email};
        Cursor cursor = db.query(MyDatabaseHelper.TABLE_USER, projection, selection, selectionArgs, null, null, null);
        boolean emailExists = cursor.getCount() > 0;
        cursor.close();

        if (emailExists) {
            // If email already exists, display an error message
            Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT).show();
            db.close();
        } else {
            // If email does not exist, insert the user into the database
            ContentValues values = new ContentValues();
            values.put(MyDatabaseHelper.COLUMN_EMAIL, email);
            values.put(MyDatabaseHelper.COLUMN_USERNAME, username);
            values.put(MyDatabaseHelper.COLUMN_PASSWORD, password);
            values.put(MyDatabaseHelper.COLUMN_TOKENS, tokens); // add tokens value to ContentValues

            // Add default values to ContentValues for other columns
            values.put(MyDatabaseHelper.COLUMN_BROJ_PARTIJA, 0);
            values.put(MyDatabaseHelper.COLUMN_PROCENAT_POBEDA, 0);
            values.put(MyDatabaseHelper.COLUMN_POENI_ASOCIJACIJE, 0);
            values.put(MyDatabaseHelper.COLUMN_POENI_POVEZIVANJE, 0);
            values.put(MyDatabaseHelper.COLUMN_POENI_KOZNAZNA, 0);
            values.put(MyDatabaseHelper.COLUMN_POENI_SKOCKO, 0);
            values.put(MyDatabaseHelper.COLUMN_POENI_MOJ_BROJ, 0);
            values.put(MyDatabaseHelper.COLUMN_POENI_KORAK_PO_KORAK, 0);
            values.put(MyDatabaseHelper.COLUMN_BROJ_ZVEZDA, 0);

            long newRowId = db.insert(MyDatabaseHelper.TABLE_USER, null, values);
            db.close();

            if (newRowId != -1) {
                // Display a success message and redirect to MainActivity
                Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            } else {
                // Display an error message if the user was not successfully added to the database
                Toast.makeText(getApplicationContext(), "Registration failed", Toast.LENGTH_SHORT).show();
            }
        }
    }
});
 */


}
