package com.problem.firebasereconnectissue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Source;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ProgressBar progressBar;
    private FirebaseFirestore mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);


    }


    @Override
    protected void onResume() {
        super.onResume();


        progressBar.setVisibility(View.VISIBLE);
        textView.setText("");

        mDatabase = FirebaseFirestore.getInstance();
        Source source = Source.SERVER;
        mDatabase.collection("Test")
                .document("222")
                .get(source)
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot documentSnapshot = task.getResult();
                            if (documentSnapshot != null) {

                                progressBar.setVisibility(View.GONE);
                                textView.setText(documentSnapshot.getString("result"));

                            }
                        }
                    }
                });


    }
}