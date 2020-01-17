package com.hfad.retrieve;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


class RetrieveDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "verification"; //This is the name of the database
    private static final int DB_VERSION = 1; //This is the version of the database

    //Calls the constructor of the SQLiteOpenHelper superclass and passes it the name and version
    RetrieveDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    //mandatory code
    @Override
    public void onUpgrade (SQLiteDatabase db,int oldVersion, int newVersion){
    }
    //mandatory code
    @Override
    public void onCreate(SQLiteDatabase db) {
        //represents table names and table columns. The id is the Primary key
        db.execSQL("CREATE TABLE VERSION (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "PLATFORM TEXT, "
                + "API TEXT,"
                + "CODE TEXT) ;");
        insertVersion(db, "Android_10.0", "29", "Q");
        insertVersion(db, "Android_9", "28", "P");
        insertVersion(db, "Android_8.1", "27", "0_MR1");
        insertVersion(db, "Android_8.0", "26", "0");
        insertVersion(db, "Android_7.1.1", "25", "N_MR1");
        insertVersion(db, "Android_7.1", "25", "N_MR1");
        insertVersion(db, "Android_7.0", "24", "N");
        insertVersion(db, "Android_6.0", "23", "M");
        insertVersion(db, "Android_5.1", "22", "LOLLIPOP_MR1");
        insertVersion(db, "Android_5.0", "21", "LOLLIPOP");
        insertVersion(db, "Android_4.4", "19", "KITKAT");
        insertVersion(db, "Android_4.3", "18", "Jelly_BEAN_MR2");
        insertVersion(db, "Android_4.2.2", "17", "Jelly_BEAN_MR1");
        insertVersion(db, "Android_4.2", "17", "Jelly_BEAN_MR1");
        insertVersion(db, "Android_4.1.1", "16", "Jell_BEAN");
        insertVersion(db, "Android_4.1", "16", "Jell_BEAN");
        insertVersion(db, "Android_4.0.4", "15", "ICE_CREAM_SANDWICH_MR1");
        insertVersion(db, "Android_4.0.3", "15", "ICE_CREAM_SANDWICH_MR1");
        insertVersion(db, "Android_4.0.2", "14", "ICE_CREAM_SANDWICH");
        insertVersion(db, "Android_4.0.1", "14", "ICE_CREAM_SANDWICH");
        insertVersion(db, "Android_4.0", "14", "ICE_CREAM_SANDWICH");
        insertVersion(db, "Android_3.2", "13", "HONEYCOMB_MR2");
        insertVersion(db, "Android_3.1x", "12", "HONEYCOMB_MR1");
        insertVersion(db, "Android_3.0x", "11", "HONEYCOMB");
        insertVersion(db, "Android_2.3.4", "10", "GINGERBREAD_MR1");
        insertVersion(db, "Android_2.3.3", "10", "GINGERBREAD_MR1");
        insertVersion(db, "Android_2.3.2", "09", "GINGERBREAD");
        insertVersion(db, "Android_2.3.1", "09", "GINGERBREAD");
        insertVersion(db, "Android_2.3", "09", "GINGERBREAD");
        insertVersion(db, "Android_2.2x", "08", "FROYO");
        insertVersion(db, "Android_2.1x", "07", "ECLAIR_MR1");
        insertVersion(db, "Android_2.0.1", "06", "ECLAIR_0_1");
        insertVersion(db, "Android_2.0", "05", "ECLAIR");
        insertVersion(db, "Android_1.6", "04", "DONUT");
        insertVersion(db, "Android_1.5", "03", "CUPCAKE");
        insertVersion(db, "Android_1.1", "02", "BASE_1_1");
        insertVersion(db, "Android_1.0", "01", "BASE");

    }


    private void insertVersion(SQLiteDatabase db, String s, String s1, String q) {
        ContentValues versionValues = new ContentValues();
        versionValues.put("PLATFORM", s);
        versionValues.put("API",s1);
        versionValues.put("CODE",q);
        db.insert("VERSION", null, versionValues);
    }
}

