package com.example.finalrecycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActvity extends AppCompatActivity {

    ImageView imageView;
    TextView name;
    TextView price;
    String data1,data2;
    int images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_actvity);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        imageView = findViewById(R.id.myimageView);
        getdata();
        setdata();
    }

    private void getdata(){
        if (getIntent().hasExtra("data1") && getIntent().hasExtra("data2")&&getIntent().hasExtra("images")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            images = getIntent().getIntExtra("images",1);
        }
        else {
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
        }
    }

    private void setdata(){
        name.setText(data1);
        price.setText(data2);
        imageView.setImageResource(images);
    }
}