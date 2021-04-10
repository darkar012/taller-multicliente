package com.example.cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements OnMessageListener, View.OnClickListener, View.OnTouchListener {

    private TcpConnection tcp;
    private ImageButton up, down, left, right;
    private Button fire;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tcp = TcpConnection.getInstance();
        tcp.setObserver(this);

        up = findViewById(R.id.upBtn);
        down = findViewById(R.id.downBtn);
        right = findViewById(R.id.rightBtn);
        left = findViewById(R.id.leftBtn);
        fire = findViewById(R.id.fireBtn);

        up.setOnTouchListener(this);
        down.setOnTouchListener(this);
        left.setOnTouchListener(this);
        right.setOnTouchListener(this);
        fire.setOnClickListener(this);
    }

    public void OnMessage(String msg) {
    }

    public void onClick(View v) {
        Gson gson = new Gson();

        Message fire = new Message("FIRE");
        String jsonfire = gson.toJson(fire);
        tcp.enviar(jsonfire);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Gson gson = new Gson();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                switch (v.getId()) {
                    case R.id.upBtn:
                        Message up = new Message("UPYES");
                        String jsonup = gson.toJson(up);
                        tcp.enviar(jsonup);
                        break;
                    case R.id.downBtn:
                        Message down = new Message("DOWNYES");
                        String jsondown = gson.toJson(down);
                        tcp.enviar(jsondown);
                        break;
                    case R.id.leftBtn:
                        Message left = new Message("LEFTYES");
                        String jsonleft = gson.toJson(left);
                        tcp.enviar(jsonleft);
                        break;
                    case R.id.rightBtn:
                        Message right = new Message("RIGHTYES");
                        String jsonright = gson.toJson(right);
                        tcp.enviar(jsonright);
                        break;
                }
                break;
            case MotionEvent.ACTION_UP:
                switch (v.getId()) {
                    case R.id.upBtn:
                        Message upNo = new Message("UPNO");
                        String jsonupNo = gson.toJson(upNo);
                        tcp.enviar(jsonupNo);
                        break;
                    case R.id.downBtn:
                        Message downNo = new Message("DOWNNO");
                        String jsondownNo = gson.toJson(downNo);
                        tcp.enviar(jsondownNo);
                        break;
                    case R.id.leftBtn:
                        Message leftNo = new Message("LEFTNO");
                        String jsonleftNo = gson.toJson(leftNo);
                        tcp.enviar(jsonleftNo);
                        break;
                    case R.id.rightBtn:
                        Message rightNo = new Message("RIGHTNO");
                        String jsonrightNo = gson.toJson(rightNo);
                        tcp.enviar(jsonrightNo);
                        break;
                }
                break;
        }

        return false;
    }
}