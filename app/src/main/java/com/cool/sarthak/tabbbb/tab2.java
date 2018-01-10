package com.cool.sarthak.tabbbb;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by sarthak on 27/12/17.
 */

public class tab2 extends Fragment {
    private static final String TAG = "tab2";
    private int miliseconds=0;
    private int seconds;

    private int count=0;
    private boolean running;
private ImageView start;
private  ImageView reset;
//Button
private TextView textView1;
private TextView textView2;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout2, container, false);

        start =view.findViewById(R.id.start);
        reset=view.findViewById(R.id.reset);
       // runTimer();
        start.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        textView1=getView().findViewById(R.id.starttime);
                        if (count == 0) {

                            running = true;
                            runTimer();
                            count++;


                            start.setImageResource(R.drawable.stop);
                            textView1.setText("STOP");
                           // runTimer();
                        }
                        else if(count>0){
                            count=0;



                            start.setImageResource(R.drawable.start);
                            textView1.setText("START");
                            running=false;
                            runTimer();
                        }
                    }
                }
        );

        reset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        start.setImageResource(R.drawable.start);
                        textView1.setText("START");
                        count=0;

                        running=false;
                        runTimer();

                        miliseconds=0;
                        seconds=0;
                    }
                }
        );


        return view;

    }
    private void runTimer()
    {
        final TextView timeView= getView().findViewById(R.id.time);
        final Handler handler = new Handler();

        handler.post(new Runnable() {

            @Override

            public void run() {

                int hours = seconds / 3600;

                int minutes = (seconds % 3600) / 60;

                int secs = seconds % 60;
                int msec = miliseconds%10;

                String time = String.format("%2d:%02d:%02d:%02d", hours, minutes, secs,msec);

                timeView.setText(time);

                if (running) {

                    miliseconds++;
                    seconds = miliseconds/10;


                }

                handler.postDelayed(this,100);

            }

        });
    }
}

