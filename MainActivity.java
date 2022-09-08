package com.cookandroid.baseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity<Internet> extends AppCompatActivity {

    Button button1, button2;
    EditText text1;
    Intent mlntent;
    ImageView image1, image2;
    RadioButton radio1, radio2;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button1.setBackgroundColor(Color.GRAY);
        button2 = (Button) findViewById(R.id.button2);
        button2.setBackgroundColor(Color.GRAY);

        text1 = (EditText) findViewById(R.id.text1);
        image1 = (ImageView) findViewById(R.id.imageView1);
        image2 = (ImageView) findViewById(R.id.imageView2);

        radio1 = (RadioButton) findViewById(R.id.rg_btn1);
        radio2 = (RadioButton) findViewById(R.id.rg_btn2);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),text1.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mlntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+String.valueOf(text1.getText())));
                startActivity(mlntent);
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i) {
                    case R.id.rg_btn1:
                        image1.setVisibility(View.VISIBLE);
                        image2.setVisibility(View.GONE);
                        break;
                    case R.id.rg_btn2:
                        image2.setVisibility(View.VISIBLE);
                        image1.setVisibility(View.GONE);
                        break;
                }
            }
        });
    }
}