package com.example.cleansweepsave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.example.cleansweepsave.R;
import com.example.cleansweepsave.Helper.ContactHelper;

public class PartialWipe extends AppCompatActivity {

    Toolbar toolbar;
    ListView listView;
    SimpleCursorAdapter adapter;

    int PERMISSION_READ_WRITE_CONTACT = 1000;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_refresh:
                showContacts();
                break;
            case R.id.menu_check:
                for (int i = 0; i < listView.getAdapter().getCount(); i++)
                    listView.setItemChecked(i, true);
                break;
            case R.id.menu_delete:
                deleteContacts();
                break;
        }
        return true;
    }

    //Declaring method for deleting contacs
    private void deleteContacts() {
        Cursor phones = null;
        SparseBooleanArray checked = listView.getCheckedItemPositions();
        for (int i = 0; i < checked.size(); i++) {
            if (checked.valueAt(i) == true) {
                phones = (Cursor) adapter.getItem(i);
                String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                ContactHelper.deleteContact(getContentResolver(), phoneNumber);
            }
        }
        phones.close();
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Contact(s) deleted", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partial_wipe);

        initView();

        if ((checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) &&
                (checkSelfPermission(Manifest.permission.WRITE_CONTACTS) != PackageManager.PERMISSION_GRANTED)) {
            requestPermissions(new String[]{
                    Manifest.permission.WRITE_CONTACTS,
                    Manifest.permission.READ_CONTACTS
            }, PERMISSION_READ_WRITE_CONTACT);
        } else {
            showContacts();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_READ_WRITE_CONTACT) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showContacts();
                ;
            } else {
                Toast.makeText(this, "Until you grant the permission, we cannot display your contactshow ", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showContacts() {
        Cursor cursor = ContactHelper.getContactCursor(getContentResolver(), "");
        String[] fields = new String[]{ContactsContract.Data.DISPLAY_NAME};

        adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_multiple_choice,
                cursor, fields, new int[]{android.R.id.text1});
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listView);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle("Contact Removal");
        setSupportActionBar(toolbar);

        //
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEnd();
            }
        });
    //
    }

    public void openEnd(){
        Intent endIntent = new Intent(this, End.class);
        startActivity(endIntent);
    }
}
