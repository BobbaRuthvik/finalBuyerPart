package com.example.optverification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerView;

    private DatabaseReference myRef;
    private ArrayList<com.example.optverification.Messages> messagesList;
    private com.example.optverification.RecyclerAdapter recyclerAdapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        myRef = FirebaseDatabase.getInstance().getReference();

        messagesList = new ArrayList<>();

        ClearAll();
        GetDataFromFirebase();

    }

    private void GetDataFromFirebase() {
        Query query = myRef.child("sellers");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ClearAll();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    com.example.optverification.Messages messages = new com.example.optverification.Messages();

                    messages.setImage(snapshot.child("image").getValue().toString());
                    messages.setPrice(snapshot.child("price").getValue().toString());
                    messages.setAddress(snapshot.child("address").getValue().toString());
                    messages.setPhonenumber(snapshot.child("phonenumber").getValue().toString());
                    messages.setProduct(snapshot.child("product").getValue().toString());

                    messagesList.add(messages);
                }
                recyclerAdapter = new com.example.optverification.RecyclerAdapter(getApplicationContext(), messagesList);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void ClearAll(){
        if(messagesList != null){
            messagesList.clear();
            if(recyclerAdapter!=null){
                recyclerAdapter.notifyDataSetChanged();
            }
        }
        messagesList = new ArrayList<>();
    }
}