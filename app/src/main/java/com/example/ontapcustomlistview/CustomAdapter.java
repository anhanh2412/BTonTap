package com.example.ontapcustomlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<NhanVien> {
    Context context;
    int resource;
    ArrayList<NhanVien> arrayList;
    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.arrayList = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_listview,parent,false);
        ImageView img_avatar = convertView.findViewById(R.id.img_avatar);
        TextView text_name = convertView.findViewById(R.id.text_name);
        CheckBox check_delete = convertView.findViewById(R.id.check_delete);

        NhanVien nv = arrayList.get(position);
        if(nv.getGt() == 1){
            img_avatar.setImageResource(R.drawable.boy);
        }else img_avatar.setImageResource(R.drawable.girl);
        text_name.setText(nv.getName());

        check_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.a.add(position);
            }
        });
        return convertView;
    }

}
