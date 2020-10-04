package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private double first_val;
    private String operation;
    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
    }

    public void onClickButtons(View view)
    {
        if( ((AppCompatButton)view).getText().equals("1") ||
            ((AppCompatButton)view).getText().equals("2") ||
            ((AppCompatButton)view).getText().equals("3") ||
            ((AppCompatButton)view).getText().equals("4") ||
            ((AppCompatButton)view).getText().equals("5") ||
            ((AppCompatButton)view).getText().equals("6") ||
            ((AppCompatButton)view).getText().equals("7") ||
            ((AppCompatButton)view).getText().equals("8") ||
            ((AppCompatButton)view).getText().equals("9") ||
            ((AppCompatButton)view).getText().equals("0") ||
            ((AppCompatButton)view).getText().equals(".") )
        {
            if(!tv.getText().equals("0"))
            {
                String update = tv.getText() + ((AppCompatButton)view).getText().toString();
                tv.setText(update);
            }
            else
            {
                String update = ((AppCompatButton)view).getText().toString();
                tv.setText(update);
            }
        }
        else if( ((AppCompatButton)view).getText().equals("C") )
        {
            tv.setText("0");
        }
        else if(

                ((AppCompatButton)view).getText().equals("+") ||
                 ((AppCompatButton)view).getText().equals("-") ||
                 ((AppCompatButton)view).getText().equals("x") ||
                 ((AppCompatButton)view).getText().equals("/")


        )
        {


            first_val = Double.parseDouble(tv.getText().toString());
            operation = ((AppCompatButton)view).getText().toString();
            tv.setText("0");
            v = view;
            v.setEnabled(false);
        }
        else if( ((AppCompatButton)view).getText().equals("=") )
        {
            double second_val = Double.parseDouble(tv.getText().toString());
            v.setEnabled(true);

            switch (operation)
            {
                case "+":
                    tv.setText(Double.toString(first_val + second_val));
                    break;

                case "-":
                    tv.setText(Double.toString(first_val - second_val));
                    break;

                case "x":
                    tv.setText(Double.toString(first_val * second_val));
                    break;

                case "/":
                    tv.setText(Double.toString(first_val / second_val));
                    break;
            }
        }
    }
}