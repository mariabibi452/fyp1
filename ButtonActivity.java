package com.example.zambeeladmin;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ButtonActivity extends AppCompatActivity {
    CardView cardView, cardview2, cardview3, cardView4, cardView5, cardView6, cardView7;
    TextView counterTextView, restcounter, scholtext, cartext, salontext, gymtext,latesttext;
    DatabaseReference counterRef, restref, schoolref, carref, salonref, gymref,latestref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        cardView = findViewById(R.id.card);
        cardview2 = findViewById(R.id.card2);
        cardview3 = findViewById(R.id.card3);
        cardView4 = findViewById(R.id.card4);
        cardView5 = findViewById(R.id.card5);
        cardView6 = findViewById(R.id.card6);
        cardView7 = findViewById(R.id.card7);
        counterTextView = findViewById(R.id.counterTextView);
        restcounter = findViewById(R.id.restcounter);
        scholtext = findViewById(R.id.scholtext);
        cartext = findViewById(R.id.cartext);
        salontext = findViewById(R.id.salontext);
        gymtext = findViewById(R.id.gymtext);
        latesttext=findViewById(R.id.latesttext);

        counterRef = FirebaseDatabase.getInstance().getReference("Hospital Data");
        restref = FirebaseDatabase.getInstance().getReference("Resturant Data");
        schoolref = FirebaseDatabase.getInstance().getReference("School Data");
        carref = FirebaseDatabase.getInstance().getReference("Car Data");
        salonref = FirebaseDatabase.getInstance().getReference("Salon Data");
        gymref = FirebaseDatabase.getInstance().getReference("Gym Data");
        latestref=FirebaseDatabase.getInstance().getReference("Latest News");


        latestref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Get total count of entries
                long count = dataSnapshot.getChildrenCount();

                // Update the TextView with the count
                latesttext.setText("" + count);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle error
            }
        });
        counterRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Get total count of entries
                long count = dataSnapshot.getChildrenCount();

                // Update the TextView with the count
                counterTextView.setText("" + count);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle error
            }
        });

        restref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Get total count of entries
                long count = dataSnapshot.getChildrenCount();

                // Update the TextView with the count
                restcounter.setText("" + count);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle error
            }
        });

        gymref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Get total count of entries
                long count = dataSnapshot.getChildrenCount();

                // Update the TextView with the count
                gymtext.setText("" + count);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle error
            }
        });


        schoolref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Get total count of entries
                long count = dataSnapshot.getChildrenCount();

                // Update the TextView with the count
                scholtext.setText("" + count);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle error
            }
        });

        carref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Get total count of entries
                long count = dataSnapshot.getChildrenCount();

                // Update the TextView with the count
                cartext.setText("" + count);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle error
            }
        });

        salonref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Get total count of entries
                long count = dataSnapshot.getChildrenCount();

                // Update the TextView with the count
                salontext.setText("" + count);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle error
            }
        });
cardView7.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = (new Intent(ButtonActivity.this, MainLatesNews.class));
        startActivity(intent);
    }
});

        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(ButtonActivity.this, MainGymActivity.class));
                startActivity(intent);
            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(ButtonActivity.this, MainSalonActivity.class));
                startActivity(intent);
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(ButtonActivity.this, MainCarActivity.class));
                startActivity(intent);
            }
        });
        cardview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(ButtonActivity.this, MainSchoolActivity.class));
                startActivity(intent);
            }
        });
        cardview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(ButtonActivity.this, MainResturntActivity.class));
                startActivity(intent);
            }
        });
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(ButtonActivity.this, MainActivity.class));
                startActivity(intent);
            }
        });
    }
}