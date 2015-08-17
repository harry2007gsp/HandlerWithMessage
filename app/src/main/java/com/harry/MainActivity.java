package com.harry;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    NetworkConnection networkConnection;
    MyHandler myHandler;
    static TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        myHandler = new MyHandler();

    }

    public void fetchDataOnButton(View view) {
        networkConnection = new NetworkConnection();
        networkConnection.fetchData(myHandler);
        Log.d("test", "entered");
    }

    static class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d("test", "on Handle message");
            String s = msg.getData().getString("string");
            text.setText(s);
        }
    }
}