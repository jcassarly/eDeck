package com.example.SmartCards;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void sendQuery(View view) {
        EditText codeView = (EditText) findViewById(R.id.code_input);
        int code = Integer.valueOf(codeView.getText().toString());
        LandingPageActivity.bluetooth_service.sendQuery(code);
        Pair<Integer, Integer> response = LandingPageActivity.bluetooth_service.receiveResponse();
        TextView respView = (TextView) findViewById(R.id.json_view);
        String display_text = "";
        switch(response.first) {
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
        display_text = display_text + response.second.toString();
        respView.setText(display_text);
    }

    @Override
    public void finish() {
        super.finish();
    }

}
