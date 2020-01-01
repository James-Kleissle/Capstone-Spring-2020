//Worked on by James Kleissle 1/1/2020
package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.View;
import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    //Here we are setting the initial pause time for the splash screen
    private static int SPLASH_TIME_OUT = 4000;

    //This part already comes when you create any new project....
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
        new Handler().postDelayed(new Runnable() {
            @Override
            //using public void run because a runnable object was used.
            public void run() {
                //Here we are essentially telling the app how to start the activity. This is
                //because Intent is used when performing an action.
                Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    public final String APP_TAG = "capstone";
    public final static int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1034;
    public String photoFileName = "photo.jpg";
    File photoFile;

    public void onLaunchCamera(View view) {
        //Create Intent to take a picture and return control to the calling application
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //Create a file reference to access future access
        photoFile = getPhotoFileUri(photoFileName);

        //wrap File object into a content provider
        //require for API >= 24
        //See https://guides.codepath.com/android/Sharing-Content-with-Intents#sharing-files-with-api-24-or-higher
        Uri fileProvider = FileProvider.getUriForFIle(MainActivity.this, "com.codepath.fileprovider", photoFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider);

        //If you call startActivityForResult() using an intent that no app can handle, then our app will crash.
        //So as long as the result is not null, its safe to use intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            //Start the image capture intent to take photo
            startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
        }
    }

    public File getPhotoFileUri(String filename) {
        //Get safe storage directory for photos
        //Use `getExternalFilesDir on context to access  package-specific directories
        //This way, we do not need to request external read/write runtime permissions
        File mediaStorageDir = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), APP_TAG);

        //Create the storage directory if it does not exist
        if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()) {
            Log.d(APP_TAG, "Failed to create directory");
        }

        //Return the file target for the photo based on filename
        File file = new File(mediaStorageDir.getPath() + File.separator + filename);

        return file;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // by this point we have the camera photo on disk
                Bitmap takenImage = BitmapFactory.decodeFile(photoFile.getAbsolutePath());
                // RESIZE BITMAP, see section below
                // Load the taken image into a preview
                ImageView ivPreview = (ImageView) findViewById(R.id.ivPreview);
                ivPreview.setImageBitmap(takenImage);
            } else { // Result was a failure
                Toast.makeText(this, "Picture wasn't taken!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    //PICK_PHOTO_CODE is a constant  integer
    public final static int PICK_PHOTO_CODE = 1046;

    //trigger gallery selection for a photo
    public void onPickPhoto(View view) {
        //create intent for picking a photo from the gallery
        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        //if you call startActivityForResult() using an intent that no app can handle, our app will crash
        //so as long as the result is not null, its safe to use the intent.
        if (intent.resolveActivity(getPackageManager()) != null) {
            //Bring  up gallery to select a photo
            startActivityForResult(intent, PICK_PHOTO_CODE);
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            Uri photoUri = data.getData();
            //Do something with the photo based on Uri
            try {
                Bitmap selectedImage = MediaStore.Images.Media.getBitmap(MainActivity.this.getContentResolver(), photoUri);
                ImageView Preview = (ImageView) findViewById(R.id.Preview);
                Preview.setImageBitmap(selectedImage);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
