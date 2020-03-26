package com.example.ontapcustomlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<NhanVien> nhanViens;
    CustomAdapter adapter;
    ListView list;
    EditText edit_manv, edit_namenv;
    RadioButton rdbt_nam,rdbt_nu;
    Button bt_add;
    ImageButton img_deleteall;
    static ArrayList<Integer> a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWWidth();
        setEventAdd();
        setEventDelete();
    }

    void setWWidth(){
        nhanViens = new ArrayList<>();
        adapter = new CustomAdapter(MainActivity.this, R.layout.activity_main,nhanViens);
         edit_manv = findViewById(R.id.edit_manv);
         edit_namenv = findViewById(R.id.edit_namenv);
         rdbt_nam = findViewById(R.id.rdbt_nam);
         rdbt_nu = findViewById(R.id.rdbt_nu);
         bt_add = findViewById(R.id.bt_add);
         img_deleteall = findViewById(R.id.img_deleteall);
         list = findViewById(R.id.list);
         list.setAdapter(adapter);
         a = new ArrayList<>();
    }

    void setEventAdd(){
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int gt;
                String maNV = edit_manv.getText().toString();
                String ten = edit_namenv.getText().toString();

                if(rdbt_nam.isChecked()){
                    gt = 1;
                }else gt = 0;

                NhanVien nv = new NhanVien(gt,maNV,ten);
                nhanViens.add(nv);
                adapter.notifyDataSetChanged();
                edit_manv.setText("");
                edit_namenv.setText("");
                rdbt_nam.setChecked(false);
                rdbt_nu.setChecked(false);
            }
        });
    }

    void setEventDelete(){
        img_deleteall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                while(a.size() > 0){
                    nhanViens.remove((a.size()) -1);
                    a.remove(a.size() - 1);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}
