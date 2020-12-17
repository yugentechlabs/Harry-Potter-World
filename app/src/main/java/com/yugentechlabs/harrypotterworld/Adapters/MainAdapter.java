package com.yugentechlabs.harrypotterworld.Adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.yugentechlabs.harrypotterworld.Models.Level;
import com.yugentechlabs.harrypotterworld.R;
import com.yugentechlabs.harrypotterworld.Utility.LocalUserData;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ImageView imageView;
    TextView level;
    ArrayList<Level> levels;

    public MainAdapter(Context c, List<Level> arr) {
        levels=new ArrayList<Level>();
        for(int i=0;i<arr.size();i++){
            levels.add(arr.get(i));
        }
        context=c;
    }

    @Override
    public int getCount() {
        return levels.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater==null)
            inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null)
            convertView=inflater.inflate(R.layout.grid_item,null);
        imageView=convertView.findViewById(R.id.imageView);
        level=convertView.findViewById(R.id.level);

        level.setText(String.valueOf(levels.get(position).getLevelnum()));

        LocalUserData l=new LocalUserData(context);
        if(position<Integer.parseInt(l.getLevelNumber()))
            imageView.setImageResource(R.drawable.levels);
        else
            imageView.setImageResource(R.drawable.levels_locked);



        return convertView;



    }


}
