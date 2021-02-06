package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Services se  ;
    ArrayList<String> listt = new ArrayList();
    Integer id =0;
    HashMap data = new HashMap();
    RadioGroup radioGroup;
    RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnResult = (Button) findViewById(R.id.buttonrst);

        btnResult.setOnClickListener(v -> {
            Operation();
        });
    }
    public  void Operation(){
        EditText ed1 = findViewById(R.id.edittext1);
        EditText ed2 = findViewById(R.id.edittext2);
        EditText ed3 = findViewById(R.id.edittext3);
        EditText ed4 = findViewById(R.id.edittext4);
        radioGroup = findViewById(R.id.radioGroup);
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);


        String param1 = "null", param2 = "null", param3 = "null", param4 = "null";

        param1 = ed1.getText().toString();
        param2 = ed2.getText().toString();
        param3 = ed3.getText().toString();
        param4 = ed4.getText().toString();
        if((param1.equalsIgnoreCase("")||param2.equalsIgnoreCase("")||param3.equalsIgnoreCase("")||param4.equalsIgnoreCase(""))) {
            Toast.makeText(this, " Completed your form PLEASE! " , Toast.LENGTH_SHORT).show();
        }
        else{
            if (radioButton.getText().equals("Page")) {
                Intent intentt = new Intent(this, Affichage.class);
                intentt.putExtra("param1", param1);
                intentt.putExtra("param2", param2);
                intentt.putExtra("param3", param3);
                intentt.putExtra("param4", param4);
                startActivity(intentt);
            }
            if (radioButton.getText().equals("List")) {
                // we includ the class of another Layout for sending the information
                Intent intentt = new Intent(this, Affichage_2.class);
                se = new Services(param1+""+param2+" "+param3+" "+param4);
                int a= id++;
                data.put(a,param1+" "+param2+" "+param3+" "+param4);
                data.put(a+1,"I-Labo"+" "+"Info"+" "+"Devlepment"+" "+"MOBILE");
                data.put(a+2,"B-LABO"+" "+"Cloud"+" "+"Securite"+" "+"FIREWALL");
                data.put(a+3,"S-Labo"+" "+"Reseaux"+" "+"Protocols"+" "+"OSPF-v3");
                data.put(a+4,"S-Labo"+" "+"Reseaux"+" "+"Protocols"+" "+"RIP-v2");
                for (int i = 0; i < data.size(); i++) {
                    listt.add(data.get(i).toString());
                }
                intentt.putStringArrayListExtra("data",listt);
                startActivity(intentt);
            }}
    }
}
