package com.example.tugasuts_10120045;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.tugasuts_10120045.adapter.Adapter10120045FifitSitiNurfitriyatiBasyariIF2;
import com.example.tugasuts_10120045.helper.Helper10120045FifitSitiNurfitriyatiBasyariIF2;
import com.example.tugasuts_10120045.model.Data10120045FifitSitiNurfitriyatiBasyariIF2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    AlertDialog.Builder dialog;
    List<Data10120045FifitSitiNurfitriyatiBasyariIF2> lists = new ArrayList<>();
    Adapter10120045FifitSitiNurfitriyatiBasyariIF2 adapter;
    Helper10120045FifitSitiNurfitriyatiBasyariIF2 db = new Helper10120045FifitSitiNurfitriyatiBasyariIF2(this);
    Button btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new Helper10120045FifitSitiNurfitriyatiBasyariIF2(getApplicationContext());
        btnAdd = findViewById(R.id.btn_Add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        listView = findViewById(R.id.list_item);
        adapter = new Adapter10120045FifitSitiNurfitriyatiBasyariIF2(MainActivity.this, lists);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String id = lists.get(i).getId();
                final String name = lists.get(i).getNama();
                final String email = lists.get(i).getEmail();
                final CharSequence[] dialogItem = {"Edit", "Hapus"};
                dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:
                                Intent intent = new Intent(MainActivity.this, Editor10120045FifitSitiNurfitriyatiBasyariIF2.class);
                                intent.putExtra("id", id);
                                intent.putExtra("name", name);
                                intent.putExtra("email", email);
                                startActivity(intent);
                                break;
                            case 1:
                                db.delete(Integer.parseInt(id));
                                lists.clear();
                                //panggil data
                                break;
                        }
                    }
                }).show();
                return false;
            }
        });
        getData();
    }
    private void getData(){
        ArrayList<HashMap<String, String >> rows = db.getAll();
        for (int i = 0; i<rows.size(); i++){
            String id = rows.get(i).get("id");
            String name = rows.get(i).get("name");
            String email = rows.get(i).get("email");

            Data10120045FifitSitiNurfitriyatiBasyariIF2 data = new Data10120045FifitSitiNurfitriyatiBasyariIF2();
            data.setId(id);
            data.setId(name);
            data.setId(email);
            lists.add(data);

        }
        adapter.notifyDataSetChanged();

    }
}