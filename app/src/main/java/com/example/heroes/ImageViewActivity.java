package com.example.heroes;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class ImageViewActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        imageView = findViewById(R.id.imgView);
        loadUrl();

    }

    private  void loadUrl() {

        android.os.StrictMode.ThreadPolicy policy = new android.os.StrictMode.ThreadPolicy.Builder().permitAll().build();
        android.os.StrictMode.setThreadPolicy(policy);
        try {

            String imgUrl ="https://i.ytimg.com/vi/AGBjI0x9VbM/maxresdefault.jpg";
            URL url= new URL(imgUrl);
            imageView.setImageBitmap(BitmapFactory.decodeStream((InputStream)url.getContent()));

        }catch (Exception e){
            System.out.println(e);
        }
    }

}
