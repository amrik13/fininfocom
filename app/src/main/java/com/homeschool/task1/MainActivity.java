package com.homeschool.task1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    EditText email, pass;
    Button submitBtn;
    RecyclerView recyclerView;
    LinearLayout listHead;
    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        submitBtn = findViewById(R.id.btn);
        recyclerView = findViewById(R.id.recyclerView);
        listHead = findViewById(R.id.listHead);
        listHead.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
        AdapterRV adapterRV = new AdapterRV(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterRV);
        recyclerView.setHasFixedSize(true);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailS = email.getText().toString();
                String passS = pass.getText().toString();
                if (TextUtils.isEmpty(emailS) || TextUtils.isEmpty(passS)){
                    Toast.makeText(getBaseContext(), "Empty Field!!", Toast.LENGTH_SHORT).show();
                }else {
                    if (!emailS.contains("@") || !emailS.contains(".")){
                        Toast.makeText(getBaseContext(), "Wrong Field!!", Toast.LENGTH_SHORT).show();
                    }else if (passS.length() <= 3){
                        Toast.makeText(getBaseContext(), "Password Must be more than 3 characters!!", Toast.LENGTH_SHORT).show();
                    } else{
                        if (adapterRV != null){
                            list.add(emailS+"@-@-@"+passS);
                            adapterRV.setData(list);
                            if (list.size() > 0){
                                recyclerView.setVisibility(View.VISIBLE);
                                listHead.setVisibility(View.VISIBLE);
                            }else{
                                recyclerView.setVisibility(View.GONE);
                                listHead.setVisibility(View.GONE);
                            }
                            adapterRV.notifyDataSetChanged();

                        }
                    }
                }
            }
        });
    }


}