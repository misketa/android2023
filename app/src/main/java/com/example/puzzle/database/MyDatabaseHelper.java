package com.example.puzzle.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDatabaseHelper extends SQLiteOpenHelper {



    private static final String DATABASE_NAME = "myapp.db";
    private static final int DATABASE_VERSION = 1;

    // Constant fields for user table
    public static final String TABLE_USER = "user";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";

    public static final String COLUMN_TOKENS = "tokens";

    public static final String COLUMN_BROJ_PARTIJA = "brojPartija";

    public static final String COLUMN_PROCENAT_POBEDA = "procenatPobeda";

    public static final String COLUMN_POENI_ASOCIJACIJE = "poeniAsocijacije";

    public static final String COLUMN_POENI_POVEZIVANJE = "poeniPovezivanje";

    public static final String COLUMN_POENI_KOZNAZNA = "poeniKoZnaZna";

    public static final String COLUMN_POENI_SKOCKO = "poeniSkocko";

    public static final String COLUMN_POENI_MOJ_BROJ = "poeniMojBroj";

    public static final String COLUMN_POENI_KORAK_PO_KORAK = "poeniKorakPoKorak";

    public static final String COLUMN_BROJ_ZVEZDA = "brojZvezda";

    // Constant fields for FRIEND table
    public static final String TABLE_FRIEND = "user";

    public static final String COLUMN_NUMBER_OF_STARS = "email";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        // Check if the "user" table already exists

        // Drop the "user" table if it exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);

        // Drop the "friend" table if it exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FRIEND);


        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM sqlite_master WHERE type='table' AND name=?", new String[] {TABLE_USER});
        boolean tableExists = false;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int count = cursor.getInt(0);
                tableExists = (count > 0);
            }
            cursor.close();
        }

        if (!tableExists) {
            // Create the "user" table if it does not exist
            db.execSQL("CREATE TABLE " + TABLE_USER + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_EMAIL + " TEXT, " +
                    COLUMN_USERNAME + " TEXT, " +
                    COLUMN_PASSWORD + " TEXT, " +
                    COLUMN_TOKENS + " TEXT, " +
                    COLUMN_BROJ_PARTIJA + " TEXT, " +
                    COLUMN_PROCENAT_POBEDA + " TEXT, " +
                    COLUMN_POENI_ASOCIJACIJE + " TEXT, " +
                    COLUMN_POENI_POVEZIVANJE + " TEXT, " +
                    COLUMN_POENI_KOZNAZNA + " TEXT, " +
                    COLUMN_POENI_SKOCKO + " TEXT, " +
                    COLUMN_POENI_MOJ_BROJ + " TEXT, " +
                    COLUMN_POENI_KORAK_PO_KORAK + " TEXT, " +
                    COLUMN_BROJ_ZVEZDA + " TEXT) " );
        }

        db.execSQL("CREATE TABLE " + TABLE_FRIEND + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_NUMBER_OF_STARS + " INT)");
    }

    public void insertData(String email, String username, String password) {
        // get a writable database
        SQLiteDatabase db = getWritableDatabase();

        // create a ContentValues object to store the data to be inserted
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASSWORD, password);
        values.put(MyDatabaseHelper.COLUMN_TOKENS, "5"); // add tokens value to ContentValues

        // Add default values to ContentValues for other columns
        values.put(MyDatabaseHelper.COLUMN_BROJ_PARTIJA, "0");
        values.put(MyDatabaseHelper.COLUMN_PROCENAT_POBEDA, "0");
        values.put(MyDatabaseHelper.COLUMN_POENI_ASOCIJACIJE, "0");
        values.put(MyDatabaseHelper.COLUMN_POENI_POVEZIVANJE, "0");
        values.put(MyDatabaseHelper.COLUMN_POENI_KOZNAZNA, "0");
        values.put(MyDatabaseHelper.COLUMN_POENI_SKOCKO, "0");
        values.put(MyDatabaseHelper.COLUMN_POENI_MOJ_BROJ, "0");
        values.put(MyDatabaseHelper.COLUMN_POENI_KORAK_PO_KORAK, "0");
        values.put(MyDatabaseHelper.COLUMN_BROJ_ZVEZDA, "0");

        // insert the data into the table
        long rowId = db.insert(TABLE_USER, null, values);

        if (rowId == -1) {
            Log.e("MyDatabaseHelper", "Failed to insert data");
        } else {
            Log.d("MyDatabaseHelper", "Inserted data: " + email + ", " + username + ", " + password + ", " + COLUMN_TOKENS) ;
        }

        // close the database connection
        db.close();
    }

    public String getCurrentUserEmail(SQLiteDatabase db) {
        //TODO  promeniti metodu tako da pronalazi ulogovanog korisnika kroz nasu bazu a ne firebase
        String currentUserEmail = null;
       /* FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            String currentUserUid = user.getUid();
            String[] projection = { COLUMN_EMAIL };
            String selection = COLUMN_TOKENS + " LIKE '%" + currentUserUid + "%'";
            Cursor cursor = db.query(TABLE_USER, projection, selection, null, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                currentUserEmail = cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL));
                cursor.close();
            }
        }*/
        return currentUserEmail;

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database schema upgrades here
    }
}
