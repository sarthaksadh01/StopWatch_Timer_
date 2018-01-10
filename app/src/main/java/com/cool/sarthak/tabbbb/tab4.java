package com.cool.sarthak.tabbbb;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;



public class tab4 extends Fragment {

Button button;
Button reset;
TextView textView;
EditText min;
EditText sec;
private int total;
    MediaPlayer mp;
//int total;
    private static final String TAG = "tab1";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.layout1,container,false);
        button=view.findViewById(R.id.button);
        mp=MediaPlayer.create(getActivity(),R.raw.alarm);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        min=getView().findViewById(R.id.min);
                        sec=getView().findViewById(R.id.sec);
//                        int n1=Integer.parseInt(min.getText().toString());
//                        int n2=Integer.parseInt(sec.getText().toString());
//                        int total =(n1*60)+n2;
                        String S1= min.getText().toString();
                        int n1;
                        int n2;
                         if(S1.equals("")) {
                              n1 =0;
                         }
                         else n1= Integer.parseInt(S1);
                        String S2=sec.getText().toString();
                        if(S2.equals("")) {
                             n2 =0;
                        }
                        else  n2=Integer.parseInt(S2);
                         total= (n1*60)+n2;

                        textView=getView().findViewById(R.id.textView2);
                        textView.setText(Integer.toString(total));
                        runTimer();

                    }
                }
        );
        reset=view.findViewById(R.id.reset);
        reset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        min=getView().findViewById(R.id.min);
                        sec=getView().findViewById(R.id.sec);
                        min.getText().clear();;
                        sec.getText().clear();
                        total=-2;
                        textView=getView().findViewById(R.id.textView2);
                        textView.setText("00:00");

                       // mp.start();
                        mp.stop();

                    }
                }
        );


        return view;


    }
    private void runTimer()

    {
        mp=MediaPlayer.create(getActivity(),R.raw.alarm);
        textView =getView().findViewById(R.id.textView2);
        //final TextView timeView= getView().findViewById(R.id.time);
        final Handler handler = new Handler();

        handler.post(new Runnable() {

            @Override

            public void run() {

if(total>=0){

               // String time =

                textView.setText(Integer.toString(total));
                total--;




                handler.postDelayed(this,1000);

            }
            if(total==0)
            {

                mp.start();
            }

            }

        });
    }




}


