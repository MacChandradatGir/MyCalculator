package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final int DIVIDE = 0;
    private final int ADD = 1;
    private final int SUBSTRACT = 2;
    private final int REMAINDER = 3;
    private final int MULTIPLY = 4;
    private final int SIN = 5;
    private final int LN = 6;
    private final int COS = 7;
    private final int LOG = 8;
    private final int TAN = 9;
    private final int SQUARE_ROOT = 10;
    private final int PI = 11;
    private final int EXPONENT = 12;
    private final int COSECANT = 13;
    private final int SECANT = 14;
    private final int COTAN = 15;

    private TextView answerTextview;

    private float answerValue = 0.0f;
    private float firstValue = 0.0f;
    private float seondValue = 0.0f;
    private int operator = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerTextview = findViewById(R.id.main_textview);
    }

    private void clearfield(){
        answerTextview.setText("0");
        seondValue = 0f;
        firstValue = 0f;
        operator = 0;
        answerValue = 0f;
    }

    private void setOperator(int operator){
        this.operator = operator;
        firstValue = Float.parseFloat(answerTextview.getText().toString());
        answerTextview.setText("0");
    }

    private void calculator(){
        seondValue = Float.parseFloat(answerTextview.getText().toString());

        switch (operator){
            case ADD:
                answerValue = firstValue + seondValue;
                break;
            case SUBSTRACT:
                answerValue = firstValue - seondValue;
                break;
            case DIVIDE:
                answerValue = firstValue / seondValue;
                break;
            case REMAINDER:
                answerValue = (int)(firstValue % seondValue);
                break;
            case MULTIPLY:
                answerValue = firstValue * seondValue;
                break;
            case SIN:
                answerValue = (float)Math.sin(firstValue);
                break;
            case LN:
                answerValue = (float)Math.log(firstValue);
                break;
            case COS:
                answerValue = (float)Math.cos(firstValue);
                break;
            case LOG:
                answerValue = (float)Math.log10(firstValue);
                break;
            case TAN:
                answerValue = (float)Math.tan(firstValue);
                break;
            case SQUARE_ROOT:
                answerValue = (float)Math.sqrt(firstValue);
                break;
            case PI:
                answerValue = (float)Math.PI * firstValue;
                break;
            case EXPONENT:
                answerValue = (float)Math.pow(firstValue, seondValue);
                break;
            case COSECANT:
                answerValue = (int)(1 / Math.sin(firstValue));
                break;
            case SECANT:
                answerValue = (int)(1 / Math.cos(firstValue));
                break;
            case COTAN:
                answerValue = (int)(1 / Math.tan(firstValue));
                break;
        }
        answerTextview.setText(answerValue +"");
    }

    private void addNumber(int value){
        if(answerTextview.getText().equals("0"))
            answerTextview.setText("");

        answerTextview.setText(answerTextview.getText().toString() + value);
    }

    private void removeNumber(){
        if(answerTextview.getText().toString().trim().length() > 0 && !answerTextview.getText().toString().equals("0"))
            answerTextview.setText(answerTextview.getText().toString().substring(0, answerTextview.length()-1));
    }


    public void onClick(View view){
        switch (view.getId()){
            case R.id.clear_button:
                clearfield();
                break;

            case R.id.add_button:
                setOperator(ADD);
                break;
            case R.id.substract_button:
                setOperator(SUBSTRACT);
                break;

            case R.id.zero_button:
                addNumber(0);
                break;
            case R.id.one_button:
                addNumber(1);
                break;
            case R.id.two_button:
                addNumber(2);
                break;
            case R.id.three_button:
                addNumber(3);
                break;
            case R.id.four_button:
                addNumber(4);
                break;
            case R.id.five_button:
                addNumber(5);
                break;
            case R.id.six_button:
                addNumber(6);
                break;
            case R.id.seven_button:
                addNumber(7);
                break;
            case R.id.eight_button:
                addNumber(8);
                break;
            case R.id.nine_button:
                addNumber(9);
                break;

            case R.id.back_button:
                removeNumber();
                break;

            case R.id.divide_button:
                setOperator(DIVIDE);
                break;

            case R.id.equals_button:
                calculator();
                break;

            case R.id.multiply_button:
                setOperator(MULTIPLY);
                break;

            case R.id.remainder_button:
                setOperator(REMAINDER);
                break;

            case R.id.sin_button:
                setOperator(SIN);
                break;

            case R.id.ln_button:
                setOperator(LN);
                break;

            case R.id.cos_button:
                setOperator(COS);
                break;

            case R.id.log_button:
                setOperator(LOG);
                break;

            case R.id.tan_button:
                setOperator(TAN);
                break;

            case R.id.sq_button:
                setOperator(SQUARE_ROOT);
                break;

            case R.id.pi_button:
                setOperator(PI);
                break;

            case R.id.exp_button:
                setOperator(EXPONENT);
                break;
            case R.id.cosec_button:
                setOperator(COSECANT);
                break;
            case R.id.sec_button:
                setOperator(SECANT);
                break;
            case R.id.cot_button:
                setOperator(COTAN);
                break;
        }
    }
}
