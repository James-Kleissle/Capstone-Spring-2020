package com.example.cleansweepandsave;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.File;

public class ImageRemover extends AppCompatActivity {

    Toolbar toolbar;
    ListView listView;

    int PERMISSION_READ_WRITE_EXTERNAL_STORAGE = 1000;

    public ImageRemover(File file) {
        this.file = file;
    }

    //Sending code to grab icons as well as telling the icons what to do when clicked on
    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_refresh:
                showImages();
                break;
            case R.id.menu_check:
                for(int i=0;i<listView.getAdapter().getCount();i++)
                    listView.setItemChecked(i, true);
                break;
            case R.id.menu_delete:
                deleteImages();
                break;
        }
        return true;
    }

    private void deleteImages() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_remover);

        initView();
//Telling code to have read and write permissions on start up.
        if ((checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) &&
                (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)) {
            requestPermissions(new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
            }, PERMISSION_READ_WRITE_EXTERNAL_STORAGE);
        } else {
            showImages();
        }
    }

    private void showImages() {
    }
    //Asking user for permission and stating what to do when user clicks okay.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == PERMISSION_READ_WRITE_EXTERNAL_STORAGE)
        {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                showImages();
            }
            else
            {
                Toast.makeText(this,"Until you grant the permission, we cannot display your images ", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Set up the projection (we only need the ID)
    String[] projection = { MediaStore.Images.Media._ID };

    // Match on the file path
    String selection = MediaStore.Images.Media.DATA + " = ?";
    private File file;
    String[] selectionArgs = new String[] { file.getAbsolutePath() };

    // Query for the ID of the media matching the file path
    Uri queryUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    ContentResolver contentResolver = getContentResolver();

    Cursor c = contentResolver.query(queryUri, projection, selection, selectionArgs, null);

    {
        assert c != null;
        if (c.moveToFirst()) {
            // We found the ID. Deleting the item via the content provider will also remove the file
            assert c != null;
            long id = c.getLong(c.getColumnIndexOrThrow(MediaStore.Images.Media._ID));
            Uri deleteUri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id);
            contentResolver.delete(deleteUri, null, null);
        } else {
            // File not found in media store DB
            c.close();
        }
    }

    //Defining the tool bar and the set up of the app.
    private void initView() {
        listView = findViewById(R.id.listView);
        toolbar = findViewById(R.id.toolBar);
        toolbar.setTitle("Image Remover");
        setSupportActionBar(toolbar);
    }
}

