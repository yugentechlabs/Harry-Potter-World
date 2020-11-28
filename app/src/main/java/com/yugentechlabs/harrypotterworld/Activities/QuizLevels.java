package com.yugentechlabs.harrypotterworld.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.yugentechlabs.harrypotterworld.Adapters.MainAdapter;
import com.yugentechlabs.harrypotterworld.R;

public class QuizLevels extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_levels);
        updateUI();

    }

    private void updateUI() {

        gridView=findViewById(R.id.grid_view);
        MainAdapter adapter= new MainAdapter(this);
        gridView.setAdapter(adapter);


//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent=new Intent(getContext(), com.yugentechlabs.walled.Activities.Wallpaper.class);
//                intent.putExtra("url",wallpaperURL.get(position));
//                intent.putExtra("blurUrl",wallpaperBlurURL.get(position));
//                startActivity(intent);
//                //Toast.makeText(MainActivity.this, wallpaperURL.get(position), Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}