package com.example.modbusrtu;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static TextView textView;
    EditText edt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        textView = findViewById(R.id.tv);
        edt = findViewById(R.id.edt);
        btn = findViewById(R.id.btn);
        SerialPortUtil.openSrialPort();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSend();
            }
        });
    }

    /**
     * 发送串口数据
     */
    private void onSend() {
        String input = edt.getText().toString();
        if(TextUtils.isEmpty(input)){
            edt.setError("要发送的数据不能为空");
            return;
        }
        SerialPortUtil.sendSerialPort(input);
    }


    public static void showText(String data){
        textView.setText(textView.getText().toString()+";"+data);
    }

}
