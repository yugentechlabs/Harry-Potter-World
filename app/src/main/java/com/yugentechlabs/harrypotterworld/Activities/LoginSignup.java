package com.yugentechlabs.harrypotterworld.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.yugentechlabs.harrypotterworld.Models.User;
import com.yugentechlabs.harrypotterworld.R;
import com.yugentechlabs.harrypotterworld.Utility.LocalUserData;

public class LoginSignup extends AppCompatActivity {
    private FirebaseAuth mAuth;
    FirebaseFirestore db;
    TextView login,signup;
    EditText signupNickname, signupEmailAddress,signupPassword,loginEmailAddress, loginPassword;
    TextView signupButton,loginButton;
    ProgressDialog progress;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null) {
           startActivity(new Intent(LoginSignup.this, MainActivity.class));
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        getViews();
        showSignup();

    }


    private void showSignup() {

        login.setTextColor(ContextCompat.getColor(this, R.color.text_dark));
        signup.setTextColor(ContextCompat.getColor(this, R.color.white));

        loginEmailAddress.setVisibility(View.INVISIBLE);
        loginPassword.setVisibility(View.INVISIBLE);
        loginButton.setVisibility(View.INVISIBLE);

        signupEmailAddress.setVisibility(View.VISIBLE);
        signupPassword.setVisibility(View.VISIBLE);
        signupNickname.setVisibility(View.VISIBLE);
        signupButton.setVisibility(View.VISIBLE);
    }


    private void showLogin() {

        signup.setTextColor(ContextCompat.getColor(this, R.color.text_dark));
        login.setTextColor(ContextCompat.getColor(this, R.color.white));

        loginEmailAddress.setVisibility(View.VISIBLE);
        loginPassword.setVisibility(View.VISIBLE);
        loginButton.setVisibility(View.VISIBLE);

        signupEmailAddress.setVisibility(View.INVISIBLE);
        signupPassword.setVisibility(View.INVISIBLE);
        signupNickname.setVisibility(View.INVISIBLE);
        signupButton.setVisibility(View.INVISIBLE);
     }




    private void startLogin() {

        String email=loginEmailAddress.getText().toString();
        String password=loginPassword.getText().toString();

        if(email.equals("")){
            Toast.makeText(LoginSignup.this, "Email required for login!", Toast.LENGTH_SHORT).show();
        }
        else if(password.length()<6){
            Toast.makeText(LoginSignup.this, "Password should have minimum 6 characters", Toast.LENGTH_SHORT).show();
        }
        else {

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(LoginSignup.this, "Signup Authentication Success", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                getUserDoc(email);
                            } else {
                                progress.dismiss();
                                // If sign in fails, display a message to the user.
                                Log.w("TAG", "signInWithEmail:failure", task.getException());
                                Toast.makeText(LoginSignup.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(LoginSignup.this, "Please check your internet connection.",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void getUserDoc(String email) {

        DocumentReference docRef = db.collection("User").document(email);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                User u = documentSnapshot.toObject(User.class);
                LocalUserData localUserData=new LocalUserData(LoginSignup.this,u.getEmail(),u.getHouse(),u.getWand(),u.getPatronus(),u.getCharacter(),u.getLevelnumber(),u.getNickname());
                progress.dismiss();
                startActivity(new Intent(LoginSignup.this,MainActivity.class));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progress.dismiss();
                Toast.makeText(LoginSignup.this, "Please check your internet connection.",
                        Toast.LENGTH_SHORT).show();
            }
        });



    }


    private void startSignup() {

        String email=signupEmailAddress.getText().toString();
        String password=signupPassword.getText().toString();

        if(email.equals("")){
            Toast.makeText(LoginSignup.this, "Email required for signup!", Toast.LENGTH_SHORT).show();
        }
        else if(password.length()<6){
            Toast.makeText(LoginSignup.this, "Password should have minimum 6 characters", Toast.LENGTH_SHORT).show();
        }
        else {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(LoginSignup.this, "Signup Authentication Success", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                makeUserDoc();
                            } else {
                                progress.dismiss();
                                // If sign in fails, display a message to the user.
                                Log.w("TAG", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(LoginSignup.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }

    }







    private void makeUserDoc() {

        String email=signupEmailAddress.getText().toString();
        String nickname=signupNickname.getText().toString();


        User u=new User(email,nickname,"","","","","1");
        LocalUserData localUserData=new LocalUserData(LoginSignup.this,u.getEmail(),u.getHouse(),u.getWand(),u.getPatronus(),u.getCharacter(),u.getLevelnumber(),u.getNickname());
        Toast.makeText(LoginSignup.this, localUserData.getEmail()+localUserData.getLevelNumber(), Toast.LENGTH_SHORT).show();
        db.collection("User").document(email).set(u).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginSignup.this, "Signup Success", Toast.LENGTH_SHORT).show();
                    progress.dismiss();
                    startActivity(new Intent(LoginSignup.this,MainActivity.class));
                }
                else{
                    progress.dismiss();
                    Toast.makeText(LoginSignup.this, "Signup Failed", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progress.dismiss();
                Toast.makeText(LoginSignup.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
            }
        });

    }






    private void getViews() {
        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);
        signupNickname=findViewById(R.id.signupNickname);
        signupEmailAddress=findViewById(R.id.signupEmailAddress);
        signupPassword=findViewById(R.id.signupPassword);
        signupButton=findViewById(R.id.signup_btn);
        loginButton=findViewById(R.id.login_btn);
        loginEmailAddress=findViewById(R.id.loginEmailAddress);
        loginPassword=findViewById(R.id.loginPassword);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress=new ProgressDialog(LoginSignup.this);
                progress.setCancelable(false);
                progress.show();
                progress.setContentView(R.layout.loading_dialog);
                progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                startSignup();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress=new ProgressDialog(LoginSignup.this);
                progress.setCancelable(false);
                progress.show();
                progress.setContentView(R.layout.loading_dialog);
                progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                startLogin();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignup();
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLogin();
            }
        });

    }

    @Override
    public void onBackPressed() {

    }
}