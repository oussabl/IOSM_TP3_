package com.example.tp4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Affichage_2 extends Activity {
    ArrayList data = new ArrayList<>();
    ArrayList list = new ArrayList();

    int i=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage2);
        ListView listVRes = findViewById(R.id.listViewRes1);
        Bundle bundle = getIntent().getExtras();

        list = bundle.getStringArrayList("data");
        for (int i = 0 ;i<list.size(); i++) {
            System.out.println(list.get(i).toString());
        }


        // adapted from treatment
        listVRes.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, data));
        int a=i++;
                                 for (int i = 0 ;i<list.size(); i++) {
                                     data.add(i, list.get(i).toString());
                                 }


        listVRes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(Affichage_2.this, "Clicked Item "+i+" "+data.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onClick(View view) {
        back();
    }
    void back(){
        Intent intent = new Intent(this, MainActivity.class);
       // intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
       startActivity(intent);
    }
}
