package com.example.SmartCards;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void sendQuery(View view) {
        EditText codeView = (EditText) findViewById(R.id.code_input);
        //String filename = codeView.getText().toString();
        //LandingPageActivity.bluetooth_service.sendFile(filename);

        int retCode = LandingPageActivity.bluetooth_service.override();

        //Python py = Python.getInstance();

        //PyObject imgur = py.getModule("imgur_test");
        //String display_text = imgur.callAttr("upload_image", "/data/user/0/com.example.herroworld/app_deck/1").toString();
        //PyObject requests = py.getModule("requests");
        //PyObject response = requests.callAttr("get", "https://i.imgur.com/h8NGQEx.jpg");

        //String display_text = response.get("text").toString();

        String display_text = "ACK (" + retCode + ")\n";

        //LandingPageActivity.bluetooth_service.receiveFile("decklist.json");
        TextView respView = (TextView) findViewById(R.id.json_view);

        /*File imgFile = new File(this.getFilesDir(), "test.json");
        try {
            Scanner s = new Scanner(imgFile);
            while (s.hasNextLine())
            {
                display_text += s.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        /*switch(response.first) {
            case 1:
                display_text = "Query: ";
                break;
            case 2:
                display_text = "Receive File: ";
                break;
            case 3:
                display_text = "Error: ";
                break;
            case 0xBEEFCAFE:
                display_text = "ACK";
                break;
        }
        display_text = display_text + response.second.toString();*/
        respView.setText(display_text);
    }

    /** Code for viewing an image **/
//    public void viewImg(View view) {
//        File imgFile = new File(this.getFilesDir(), file_name);
//        if(imgFile.exists()){
//
//            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
//
//            ImageView myImage = (ImageView) findViewById(R.id.dbgImageView);
//
//            myImage.setImageBitmap(myBitmap);
//
//        }
//    }

    @Override
    public void finish() {
        super.finish();
    }

}
