package com.singh.integrated_book;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.filament.View;

import java.io.FileNotFoundException;
import java.io.InputStream;
public class MainActivity extends AppCompatActivity {
private boolean yes=false;
        ImageView img;
        ImageView img2;
        Button b;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            img = (ImageView)findViewById(R.id.Image);
            img2=(ImageView) findViewById(R.id.Imagetest);

            b=findViewById(R.id.BTn);

        b.setOnClickListener(view -> {
            Intent intent =new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            startActivityForResult(intent,100);
            img2=img;
            yes=true;
        });
            if(yes==true) {
                Intent intent = new Intent(this,ArCore_Img.class);
            }
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode==100 && resultCode==RESULT_OK)
            {
                Uri uri = data.getData();
                img.setImageURI(uri);
            }
        }
}

