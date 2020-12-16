package com.example.calcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String in, out;
    private int fl=0;
    TextView tvOut,tvIn;
    Button one,two,three,four,five,six,seven,eight,nine,zero,plus,minus,equals;
    private String cur="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvOut = (TextView) findViewById(R.id.out);
        tvIn = (TextView) findViewById(R.id.inp);
        one= (Button) findViewById(R.id.one);
        two= (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        equals = (Button) findViewById(R.id.equals);

        // создание обработчика
        View.OnClickListener oclBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // по id определеяем кнопку, вызвавшую этот обработчик
                switch (v.getId()) {
                    case R.id.one:
                        cur+="1";
                        if(fl==1){
                            tvIn.setText("");
                            fl=0;
                        }
                        else{
                            tvIn.setText(cur);
                        }
                       // tvIn.setText(cur);
                        break;
                    case R.id.two:
                        cur+="2";
                        if(fl==1){
                            tvIn.setText("");
                            fl=0;
                        }
                        else{
                            tvIn.setText(cur);
                        }
                        //tvIn.setText(cur);
                        break;
                    case R.id.three:
                        cur+="3";
                        if(fl==1){
                            tvIn.setText("");
                            fl=0;
                        }
                        else{
                            tvIn.setText(cur);
                        }
                        break;
                    case R.id.four:
                        cur+="4";
                        if(fl==1){
                            tvIn.setText("");
                            fl=0;
                        }
                        else{
                            tvIn.setText(cur);
                        }
                        break;
                    case R.id.five:
                        cur+="5";
                        if(fl==1){
                            tvIn.setText("");
                            fl=0;
                        }
                        else{
                            tvIn.setText(cur);
                        }
                        break;
                    case R.id.six:
                        cur+="6";
                        if(fl==1){
                            tvIn.setText("");
                            fl=0;
                        }
                        else{
                            tvIn.setText(cur);
                        }
                        break;
                    case R.id.seven:
                        cur+="7";
                        if(fl==1){
                            tvIn.setText("");
                            fl=0;
                        }
                        else{
                            tvIn.setText(cur);
                        }
                        break;
                    case R.id.eight:
                        cur+="8";
                        if(fl==1){
                            tvIn.setText("");
                            fl=0;
                        }
                        else{
                            tvIn.setText(cur);
                        }
                        break;
                    case R.id.nine:
                        cur+="9";
                        if(fl==1){
                            tvIn.setText("");
                            fl=0;
                        }
                        else{
                            tvIn.setText(cur);
                        }
                        break;
                    case R.id.zero:
                        cur+="0";
                        if(fl==1){
                            tvIn.setText("");
                            fl=0;
                        }
                        else{
                            tvIn.setText(cur);
                        }
                        break;
                    case R.id.plus:
                        cur+="+";
                        if(fl==1){
                            tvIn.setText("");
                            fl=0;
                        }
                        else{
                            tvIn.setText(cur);
                        }
                        break;
                    case R.id.minus:
                        cur+="-";
                        if(fl==1){
                            tvIn.setText("");
                            fl=0;
                        }
                        else{
                            tvIn.setText(cur);
                        }
                        break;
                    case R.id.equals:
                        String s = "";
                        s+=cur;
                        tvIn.setText(cur);
                        cur="";
                        fl=1;
                        //tvOut.setText(String.valueOf(calc(s)));
                        JThread t= new JThread("JThread ",s);
                        t.start();
                        break;
                }
            }
        };
        one.setOnClickListener(oclBtn);
        two.setOnClickListener(oclBtn);
        three.setOnClickListener(oclBtn);
        four.setOnClickListener(oclBtn);
        five.setOnClickListener(oclBtn);
        six.setOnClickListener(oclBtn);
        seven.setOnClickListener(oclBtn);
        eight.setOnClickListener(oclBtn);
        nine.setOnClickListener(oclBtn);
        zero.setOnClickListener(oclBtn);
        plus.setOnClickListener(oclBtn);
        minus.setOnClickListener(oclBtn);
        equals.setOnClickListener(oclBtn);
    }
    class JThread extends Thread {

        private String input;
        private int aggregate = 0;
        JThread(String name, String inp){
            super(name);
            input=inp;
        }

        public void run(){
            input = input.replace(" ","");
            String parsedInteger = "";
            String operator = "";
            for(int i = 0; i < input.length(); i++){
                char c = input.charAt(i);
                if (Character.isDigit(c)) {
                    parsedInteger += c;
                }
                if (!Character.isDigit(c) || i == input.length()-1){
                    int parsed = Integer.parseInt(parsedInteger);
                    if (operator == "") {
                        aggregate = parsed;
                    }
                    else {
                        if (operator.equals("+")) {
                            aggregate += parsed;
                        }else if (operator.equals("-")){
                            aggregate -= parsed;
                        }
                    }

                    parsedInteger ="";
                    operator = ""+c;
                    tvOut.setText(String.valueOf(aggregate));
                }
            }
        }

    }
        public int calc(String input){
            input = input.replace(" ","");
            String parsedInteger = "";
            String operator = "";
            int aggregate = 0;
            for(int i = 0; i < input.length(); i++){
                char c = input.charAt(i);
                if (Character.isDigit(c)) {
                    parsedInteger += c;
                }
                if (!Character.isDigit(c) || i == input.length()-1){
                    int parsed = Integer.parseInt(parsedInteger);
                    if (operator == "") {
                        aggregate = parsed;
                    }
                    else {
                        if (operator.equals("+")) {
                            aggregate += parsed;
                        }else if (operator.equals("-")){
                            aggregate -= parsed;
                        }
                    }

                    parsedInteger ="";
                    operator = ""+c;
                }
            }
           return aggregate;
    }


}