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
import com.yugentechlabs.harrypotterworld.R;

import java.util.ArrayList;

public class MainAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ImageView imageView;
    TextView level;

    public MainAdapter(Context c) {
        context=c;
    }

    @Override
    public int getCount() {
        return 30;
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

        level.setText(String.valueOf(position+1));

        if(position==0)
            imageView.setImageResource(R.drawable.levels);
        else
            imageView.setImageResource(R.drawable.levels_locked);



        return convertView;



    }


}
