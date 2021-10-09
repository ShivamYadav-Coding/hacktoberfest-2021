package com.example.calculatorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private Button buttonAC;
    private Button buttonDelete;
    private Button buttonDivide;
    private Button buttonMultiply;
    private Button buttonAdd;
    private Button buttonMinus;
    private Button buttonEquals;
    private Button buttonDot;
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private TextView textViewResult;
    private TextView textViewHistory;
    private String finalAnswer = "";
    private String answerInHistory = "";
    private ArrayList<String> arrayList = new ArrayList<>();
    DecimalFormat decimalFormat = new DecimalFormat("######.######");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

        buttonAC = findViewById(R.id.buttonAC);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonDot = findViewById(R.id.buttonDot);
        buttonEquals = findViewById(R.id.buttonEquals);
        textViewHistory = findViewById(R.id.textViewHistory);
        textViewResult = findViewById(R.id.textViewResult);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNumber("0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNumber("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNumber("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNumber("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNumber("4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNumber("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNumber("6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNumber("7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNumber("8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNumber("9");
            }
        });
        clickSigns();
        finalAnswer = "0";

        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalAnswer = "0";
                textViewResult.setText("0");
                textViewHistory.setText(null);
                clickSigns();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalAnswer = finalAnswer.substring(0,finalAnswer.length()-1);
                textViewResult.setText(finalAnswer);
                clickSigns();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonMinus.setClickable(false);
                buttonMultiply.setClickable(false);
                buttonDivide.setClickable(false);
                finalAnswer += "+";
                textViewResult.setText(finalAnswer);
                addToArrayList();
                DMASOrder();
                print();
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonAdd.setClickable(false);
                buttonMultiply.setClickable(false);
                buttonDivide.setClickable(false);
                finalAnswer += "-";
                textViewResult.setText(finalAnswer);
                addToArrayList();
                DMASOrder();
                print();
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonMinus.setClickable(false);
                buttonAdd.setClickable(false);
                buttonMultiply.setClickable(false);
                finalAnswer += "/";
                textViewResult.setText(finalAnswer);
                addToArrayList();
                DMASOrder();
                print();
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonMinus.setClickable(false);
                buttonAdd.setClickable(false);
                buttonDivide.setClickable(false);
                finalAnswer += "*";
                textViewResult.setText(finalAnswer);
                addToArrayList();
                DMASOrder();
                print();
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToArrayList();
                int index1 = finalAnswer.lastIndexOf("+");
                int index2 = finalAnswer.lastIndexOf("/");
                int index3 = finalAnswer.lastIndexOf("*");
                int index4 = finalAnswer.lastIndexOf("-");
                int number1 = Math.max(index1,index2);
                int number2 = Math.max(index3,index4);
                int number3 = Math.max(number1,number2);
                String sub = finalAnswer.substring(number3+1);
                arrayList.add(sub);
                DMASOrder();
                double answer = Double.parseDouble(arrayList.get(0));
                textViewHistory.setText(decimalFormat.format(answer));
                textViewResult.setText(decimalFormat.format(answer));
                finalAnswer = answer + "";
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNumber(".");
            }
        });

    }

    public void clickNumber(String number) {
        if (finalAnswer.equals("0")) {
            finalAnswer = "";
        }
        finalAnswer += number;
        textViewResult.setText(finalAnswer);
        clickSigns();
    }

    public void addToArrayList() {
        arrayList = new ArrayList<>();
        String string = "";
        for (int i=0;i<finalAnswer.length();i++) {
            if (finalAnswer.charAt(i) == '+' || finalAnswer.charAt(i) == '-' || finalAnswer.charAt(i) == '*' || finalAnswer.charAt(i) == '/') {
                arrayList.add(string);
                arrayList.add(finalAnswer.charAt(i) + "");
                string = "";
            }else {
                string += (finalAnswer.charAt(i) + "");
            }
        }
    }

    public void division() {
        for (int i=0;i<arrayList.size()-1;i++) {
            if (arrayList.get(i).equals("/")) {
                double firstNumber = Double.parseDouble(arrayList.get(i-1));
                double secondNumber = Double.parseDouble(arrayList.get(i+1));
                double division = firstNumber/secondNumber;
                String div = division + "";
                arrayList.remove(i);
                arrayList.remove(i);
                arrayList.set(i-1,div);
                i=0;
            }
        }
    }

    public void multiply() {
        for (int i=0;i<arrayList.size()-1;i++) {
            if (arrayList.get(i).equals("*")) {
                double firstNumber = Double.parseDouble(arrayList.get(i-1));
                double secondNumber = Double.parseDouble(arrayList.get(i+1));
                double multiply = firstNumber * secondNumber;
                String multi = multiply + "";
                arrayList.remove(i);
                arrayList.remove(i);
                arrayList.set(i-1,multi);
                i=0;
            }
        }
    }

    public void minus() {
        for (int i=0;i<arrayList.size()-1;i++) {
            if (arrayList.get(i).equals("-")) {
                double firstNumber = Double.parseDouble(arrayList.get(i-1));
                double secondNumber = Double.parseDouble(arrayList.get(i+1));
                double subtract = firstNumber - secondNumber;
                String minus = subtract + "";
                arrayList.remove(i);
                arrayList.remove(i);
                arrayList.set(i-1,minus);
                i=0;
            }
        }
    }

    public void add() {
        for (int i=0;i<arrayList.size();i++) {
            if (arrayList.get(i).equals("+") && i!=arrayList.size()-1) {
                double firstNumber = Double.parseDouble(arrayList.get(i-1));
                double secondNumber = Double.parseDouble(arrayList.get(i+1));
                double addition = firstNumber + secondNumber;
                String add = addition + "";
                arrayList.set(i-1,add);
                arrayList.remove(i);
                arrayList.remove(i);
                i=0;
            }
        }
    }

    public void DMASOrder() {
        division();
        multiply();
        minus();
        add();
    }

    public void print() {
        StringBuilder text = new StringBuilder();
        if (arrayList.size() == 1) {
            textViewHistory.setText("=" + "0");
        }else {
            text.append(arrayList.get(0));
            double number = Double.parseDouble(text.toString());
            String finalNumber = decimalFormat.format(number);
            textViewHistory.setText("=" + finalNumber);
        }
    }

    public void clickSigns() {
        buttonMultiply.setClickable(true);
        buttonDivide.setClickable(true);
        buttonMinus.setClickable(true);
        buttonAdd.setClickable(true);
    }

}