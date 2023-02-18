package com.ettounani.monsupercalculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ICalcul {

    private TextView screen;
    private double firstNumber = 0;
    private double secondNumber = 0;
    private String operator;
    private boolean isOperator = false;
    private boolean isPercent = false;
    boolean point =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = findViewById(R.id.Screen);
        Button resButton = findViewById(R.id.buttonRes);
        Button clearButton = findViewById(R.id.buttonAC);
        Button percentButton = findViewById(R.id.buttonPercent);
        Button pointButton = findViewById(R.id.buttonPoint);
        ImageView remOneButton = findViewById(R.id.buttonRemove);
        // Set the click listener for the result button
        resButton.setOnClickListener(v->result());
        clearButton.setOnClickListener(v->clearAll());
        percentButton.setOnClickListener(v->percent());
        pointButton.setOnClickListener(v->pointToDouble());
        remOneButton.setOnClickListener(v->removeOne());
    }

    @Override
    public void clearAll() {
        screen.setText("0");
        operator = null;
        isOperator = false;
        secondNumber = 0.0;
        firstNumber=0;
        point=false;
        isPercent=false;
    }

    @Override
    public void pointToDouble() {
        point=true;
        ShowInScreen();
    }

    @Override
    public void ClickedNumber(View view) {
        double val = Double.parseDouble(((Button) view).getText().toString());
        if(point){
            if (isOperator) {
                secondNumber = secondNumber + 0.10* val;
            } else {
                firstNumber = firstNumber + 0.10* val;
            }
        }
        else {
            if (isOperator) {
                secondNumber = secondNumber * 10 + val;
            } else {
                firstNumber = firstNumber * 10 + val;
            }
        }
        ShowInScreen();
    }

    @Override
    public void result() {
        if (isPercent)
        {
            operator="/";
            secondNumber=100;
        }
        if(operator==null){
            return;
        }
        switch (operator) {
            case "+":
                screen.setText(String.valueOf(firstNumber + secondNumber));
                break;
            case "-":
                screen.setText(String.valueOf(firstNumber - secondNumber));
                break;
            case "x":
                screen.setText(String.valueOf(firstNumber * secondNumber));
                break;
            case "/":
                if (secondNumber != 0) {
                    screen.setText(String.valueOf(firstNumber / secondNumber));
                } else {
                    screen.setText("divided by zero");
                }
                break;
        }
        // Reset the operator and secondNumber after the calculation
        operator = null;
        isOperator = false;
        secondNumber = 0.0;
        firstNumber=0;
        point=false;
        isPercent=false;
    }

    @Override
    public void removeOne() {
        if(isOperator){
            secondNumber=(int)(secondNumber/10);
        }else{
            firstNumber=(int)(firstNumber/10);
        }
        ShowInScreen();
    }

    @Override
    public void operation(View view) {
        String op = ((Button) view).getText().toString();
        operator = op;
        isOperator = true;
        point=false;
        ShowInScreen();
    }

    @Override
    public void percent() {
        screen.setText(String.valueOf(firstNumber+"%"));
        isPercent=true;
    }

    @Override
    public void ShowInScreen() {
        if(point){
            if (isOperator) {
                screen.setText(String.format("%.2f %s %.2f", firstNumber, operator, secondNumber));
            } else {
                screen.setText(String.format("%.2f", firstNumber));
            }
        }else{
            if (isOperator) {
                screen.setText(String.format("%.0f %s %.0f", firstNumber, operator, secondNumber));
            } else {
                screen.setText(String.format("%.0f", firstNumber));
            }
        }

    }
}
