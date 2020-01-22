package com.momen.firebasedatastoreretrievedelete;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private Button choseBtn, saveBtn, displayBtn;
    private ImageView imageView;
    private EditText imageNameEt;
    private ProgressBar progressBar;
    private Uri imageUri;

    private  static  final  int IMAGE_REQUEST = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        choseBtn= findViewById(R.id.chose_btn_id);
        saveBtn= findViewById(R.id.Save_btn_id);
        displayBtn= findViewById(R.id.display_btn_id);
        imageView= findViewById(R.id.imageView_id);
        imageNameEt= findViewById(R.id.editText_name_id);
        progressBar= findViewById(R.id.progressBar_id);



        saveBtn.setOnClickListener(this);
        displayBtn.setOnClickListener(this);
        choseBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case  R.id.chose_btn_id:

                openFilechosser();


            break;

            case  R.id.Save_btn_id:

            break;

            case  R.id.display_btn_id:

            break;
        }

    }

 void openFilechosser() {

     Intent intent= new Intent();
     intent.setType("image/*");
     intent.setAction(Intent.ACTION_GET_CONTENT);
      startActivityForResult(intent,IMAGE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==IMAGE_REQUEST&&resultCode==RESULT_OK && data!=null && data.getData()!=null)
        {
            imageUri= data.getData();
          Picasso.get().load(imageUri).into(imageView);
        }
    }
}
