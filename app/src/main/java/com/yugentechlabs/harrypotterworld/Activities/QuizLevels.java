package com.yugentechlabs.harrypotterworld.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.yugentechlabs.harrypotterworld.Adapters.MainAdapter;
import com.yugentechlabs.harrypotterworld.Models.Level;
import com.yugentechlabs.harrypotterworld.R;
import com.yugentechlabs.harrypotterworld.Utility.LocalUserData;
import java.util.ArrayList;

public class QuizLevels extends AppCompatActivity {

    int currentLevel;
    GridView gridView;
    ArrayList<Level> levels;
    FirebaseFirestore db;
    ProgressDialog progress;
    TextView nickname;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_levels);

        LocalUserData l=new LocalUserData(this);
        currentLevel=Integer.parseInt(l.getLevelNumber());

        nickname=findViewById(R.id.nickname);
        nickname.setText(l.getNickname());
        back=findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizLevels.super.onBackPressed();
            }
        });

        levels=new ArrayList<Level>();
        db = FirebaseFirestore.getInstance();

        //updateUI();
        getLevels();

    }


    private void getLevels() {

        progress=new ProgressDialog(this);
        progress.setTitle("Please Wait...");
        progress.setCancelable(false);
        progress.show();
        progress.setContentView(R.layout.loading_dialog);
        progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        db.collection("WizardingQuizLevels").orderBy("levelnum")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                //Log.d(TAG, document.getId() + " => " + document.getData());
                                Level level=document.toObject(Level.class);
                                levels.add(level);
                            }
                            progress.dismiss();
                            int cl=getIntent().getIntExtra("levelnum",0);
                            if(cl!=0){
                                Intent intent = new Intent(QuizLevels.this, WizardingQuiz.class);
                                intent.putExtra("level", levels.get((cl-1)));
                                startActivity(intent);
                            }
                            updateUI();
                        } else {
                            //Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });




    }

    private void updateUI() {

        gridView=findViewById(R.id.grid_view);
        MainAdapter adapter= new MainAdapter(this,levels);
        gridView.setAdapter(adapter);




        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if((position+1)>currentLevel){
                    Toast.makeText(QuizLevels.this, "Play to unlock levels.", Toast.LENGTH_SHORT).show();
                }else {
                    YoYo.with(Techniques.Tada).duration(400).repeat(0).playOn(view);
                    Intent intent = new Intent(QuizLevels.this, WizardingQuiz.class);
                    intent.putExtra("level", levels.get(position));
                    startActivity(intent);

//                    Intent intent = new Intent(QuizLevels.this, WizardingQuiz.class);
//                    intent.putExtra("levelNumber",String.valueOf(position+1));
//                    startActivity(intent);
                    //Toast.makeText(MainActivity.this, wallpaperURL.get(position), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(QuizLevels.this,MainActivity.class));
    }
}