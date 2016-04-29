package com.example.cracking.groupproj;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

/**
 * This Is project's third Activity's Java File
 */
public class galleryActivity extends Activity {

    private static int LOAD_IMAGE_RESULTS = 1;

    ImageView loaded_img;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_view);

        loaded_img = (ImageView)findViewById(R.id.loaded_img);
    }

    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == LOAD_IMAGE_RESULTS && resultCode == RESULT_OK && data != null){
            Uri pickedImg = data.getData();
            String[] filePath = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(pickedImg,filePath,null,null,null);
            cursor.moveToFirst();
            String imagePath = cursor.getString(cursor.getColumnIndex(filePath[0]));
            loaded_img.setImageBitmap(BitmapFactory.decodeFile(imagePath));
            cursor.close();
        }
    }

    public void insertImg(View v) {
        Intent i =new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i,LOAD_IMAGE_RESULTS);
    }


}
