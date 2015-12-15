package com.example.caseymillstein.c_millstein_contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by caseymillstein on 12/14/15.
 */
public class StudentProvider extends ContentProvider {

    private static final String AUTHORITY = "com.example.caseymillstein.c_millstein_contentprovider.studentprovider";
    private static final String BASE_PATH = "student";
    public static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH );

    private static final int STUDENTS = 1;
    private static final int STUDENT_ID = 2;

    private static final UriMatcher uriMatcher =
            new UriMatcher(UriMatcher.NO_MATCH);



    static {
        uriMatcher.addURI(AUTHORITY, BASE_PATH, STUDENTS);
        uriMatcher.addURI(AUTHORITY, BASE_PATH + "/#", STUDENT_ID);

    }

    private SQLiteDatabase database;

    @Override
    public boolean onCreate() {

        DBOpenHelper helper = new DBOpenHelper(getContext());
        database = helper.getWritableDatabase();

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return database.query(DBOpenHelper.STUDENT_INFO, DBOpenHelper.ALL_COLUMNS, selection, null, null, null, DBOpenHelper.NAME + " DESC");
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long id = database.insert(DBOpenHelper.STUDENT_INFO, null, values);

        return Uri.parse(BASE_PATH + "/" + id);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return database.delete(DBOpenHelper.STUDENT_INFO, selection, selectionArgs);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return database.update(DBOpenHelper.STUDENT_INFO, values, selection, selectionArgs);
    }
}
