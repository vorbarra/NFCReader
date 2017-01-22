package com.example.korisnik.nfcreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SubjectsActivity extends AppCompatActivity {

    private  String user;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private static final String TAG = "CLASSES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            user = extras.getString("userId");
        }
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("userdata").child(user);
        DataStorage.fillData();


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                long value = dataSnapshot.getChildrenCount();
                Log.d(TAG, "Value is: " + value);
                if (value == 0){
                    writeInitialData();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }

    private void writeInitialData() {
        String[] list =(String[]) DataStorage.listClasses.keySet().toArray();

        for(int i = 0; i<list.length;i++) {
            myRef.setValue(DataStorage.listClasses);
            Toast.makeText(SubjectsActivity.this, "Data written!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
