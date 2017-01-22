package com.example.korisnik.nfcreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class SubjectsActivity extends AppCompatActivity {

    private FirebaseUser user;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private FirebaseAuth auth;
    private static final String TAG = "CLASSES";
    private String uid;
    private HashMap<Integer, String> classes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("userdata").child(uid);
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            uid = user.getUid();

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                    classes = new HashMap<Integer, String>();
                    int i = 0;
                    for (DataSnapshot child : children) {
                        if(child.getKey() != "name")
                            classes.put(i++,child.child("name").getValue().toString());
                    }
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException());
                }
            });
        }

        //logika za ispisivanje item-a
        // ime_predmeta= nalazi se u classes!
        //za onaj intent kad radiš onaj clickListener (zabb sam koji točno i di no se točno stavlja, jbga)
        // stavi intent.putExtra("Predmet", child.getKey()), jer će možda tribat
    }
}
