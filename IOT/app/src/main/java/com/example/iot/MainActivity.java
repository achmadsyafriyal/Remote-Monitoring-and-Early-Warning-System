package com.example.iot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {
//inisialisasi text nilai
    private TextView nilai1;
    private TextView nilai2;
    private TextView nilai3;
    private TextView nilai4;
    private TextView Status;


    //buat reference untuk firebase (koneksi server / host firebase

    private Firebase mRef1;
    private Firebase mRef2;
    private Firebase mRef3;
    private Firebase mRef4;
    private Firebase mRef5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nilai1 = (TextView) findViewById (R.id.nilai1);
        nilai2 = (TextView) findViewById (R.id.nilai2);
        nilai3 = (TextView) findViewById (R.id.nilai3);
        nilai4 = (TextView) findViewById (R.id.nilai4);
        Status = (TextView) findViewById (R.id.Status);


        mRef1 = new Firebase ("https://iot1-333fb.firebaseio.com/suhu");
        mRef2 = new Firebase ("https://iot1-333fb.firebaseio.com/asap");
        mRef3 = new Firebase ("https://iot1-333fb.firebaseio.com/api");
        mRef4 = new Firebase ("https://iot1-333fb.firebaseio.com/gas");
        mRef5 = new Firebase ("https://iot1-333fb.firebaseio.com/status");




        mRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String suhu = dataSnapshot.getValue(String.class);
                nilai1.setText(suhu);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        mRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String asap = dataSnapshot.getValue(String.class);
                        nilai2.setText(asap);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        mRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String asap = dataSnapshot.getValue(String.class);
                nilai3.setText(asap);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        mRef4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String gas = dataSnapshot.getValue(String.class);
                nilai4.setText(gas);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });

        mRef5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String status = dataSnapshot.getValue(String.class);
                Status.setText(status);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });


    }
}
