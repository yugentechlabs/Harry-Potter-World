package com.yugentechlabs.harrypotterworld.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.yugentechlabs.harrypotterworld.Adapters.MainAdapter;
import com.yugentechlabs.harrypotterworld.R;
import com.yugentechlabs.harrypotterworld.Utility.LocalUserData;

public class QuizLevels extends AppCompatActivity {

    int currentLevel;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_levels);

        LocalUserData l=new LocalUserData(this);
        currentLevel=Integer.parseInt(l.getLevelNumber());

        updateUI();

    }

    private void updateUI() {

        gridView=findViewById(R.id.grid_view);
        MainAdapter adapter= new MainAdapter(this);
        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if((position+1)>currentLevel){
                    Toast.makeText(QuizLevels.this, "Play to unlock levels.", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(QuizLevels.this, WizardingQuiz.class);
                    intent.putExtra("levelNumber",String.valueOf(position+1));
                    startActivity(intent);
                    //Toast.makeText(MainActivity.this, wallpaperURL.get(position), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}