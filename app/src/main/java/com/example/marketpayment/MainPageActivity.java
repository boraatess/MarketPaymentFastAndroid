package com.example.marketpayment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

public class MainPageActivity extends AppCompatActivity
{
    Switch aSwitch;
    EditText editText ;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        aSwitch = findViewById(R.id.switch3);
        editText = findViewById(R.id.PersonName3);
        imageButton = findViewById(R.id.imageButton3);

        editText.setEnabled(false);

        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aSwitch.isChecked())
                {
                 editText.setEnabled(true);
                }
                else
                {
                    editText.setEnabled(false);
                }
            }
        });

    }

    public void TakePhoto(View view)
    {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            imageButton.setEnabled(true);
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.CAMERA,

                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, 0);

        }

        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // Resim çekme isteği ve activity başlatılıp id'si tanımlandı
        startActivityForResult(camera,33);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 33) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            //Çekilen resim id olarak bitmap şeklinde alındı ve imageview'e atandı
            ImageView resim= (ImageView)findViewById(R.id.imageView); resim.setImageBitmap(image);
        }
    }



    public void ReadBarcode(View view)
    {
        //TakePhoto(view);

    }

}