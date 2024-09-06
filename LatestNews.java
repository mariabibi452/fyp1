package com.example.zambeeladmin;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.zambeeladmin.Adapter.Dataclassnews;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class LatestNews extends AppCompatActivity {
    ImageView uploadImage;
    Button saveButton;
    EditText uploaddescrption,uploadheading;
    String imageURL;
    Uri uri;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latest_news);
        uploadImage=findViewById(R.id.uploadimge);
        uploadheading=findViewById(R.id.uploadheading);
        uploaddescrption=findViewById(R.id.uploaddescription);
        saveButton=findViewById(R.id.savebutton);
        progressDialog=new ProgressDialog(this);
        ActivityResultLauncher<Intent> activityResultLauncher=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode()== Activity.RESULT_OK){
                            Intent data=result.getData();
                            uri=data.getData();
                            uploadImage.setImageURI(uri);
                        }else {
                            Toast.makeText(LatestNews.this, "no imge selected", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photopicker=new Intent(Intent.ACTION_PICK);
                photopicker.setType("image/*");
                activityResultLauncher.launch(photopicker);
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveData();
            }
        });
    }
    public  void saveData(){
        StorageReference storageReference= FirebaseStorage.getInstance().getReference().child("Latest Images")
                .child(uri.getLastPathSegment());
        progressDialog.setTitle("please wait....");
        progressDialog.setMessage("process in progress");
        progressDialog.setCancelable(false);
        progressDialog.show();


        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask=taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isComplete());
                Uri urlImage=uriTask.getResult();
                imageURL=urlImage.toString();
                uploadData();
                progressDialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                progressDialog.dismiss();
                Toast.makeText(LatestNews.this, e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    public  void uploadData(){
        String Description=uploaddescrption.getText().toString();
        String Heading=uploadheading.getText().toString();

        if (Description.isEmpty() || Heading.isEmpty()) {
            Toast.makeText(LatestNews.this, " cannot be empty", Toast.LENGTH_SHORT).show();

            return;

//
        }
        Dataclassnews dataClass = new Dataclassnews(Description,Heading, imageURL);

        // Save the data to Firebase under the hospital name
        FirebaseDatabase.getInstance().getReference("Latest News").child(Heading)
                .setValue(dataClass)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(LatestNews.this, "Saved successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(LatestNews.this, "Failed to save data: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(e -> Toast.makeText(LatestNews.this, "Failed to save data: " + e.getMessage(), Toast.LENGTH_SHORT).show());
    }

}