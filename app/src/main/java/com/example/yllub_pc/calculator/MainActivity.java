package com.example.yllub_pc.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText result;
    private EditText input;
    private TextView displayOperation;
    private TextView display;


    private Double op1 = null;
    private Double op2 = null;
    private String pendingOperation = "=";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (EditText) findViewById(R.id.result);
        input = (EditText) findViewById((R.id.input));
        displayOperation = (TextView) findViewById((R.id.operation));
        display          =(TextView)  findViewById((R.id.textView));


        Button button1 = (Button) findViewById((R.id.button1));
        Button button2 = (Button) findViewById((R.id.button2));
        Button button3 = (Button) findViewById((R.id.button3));
        Button button4 = (Button) findViewById((R.id.button4));
        Button button5 = (Button) findViewById((R.id.button5));
        Button button6 = (Button) findViewById((R.id.button6));
        Button button7 = (Button) findViewById((R.id.button7));
        Button button8 = (Button) findViewById((R.id.button8));
        Button button9 = (Button) findViewById((R.id.button9));
        Button button_plus = (Button) findViewById((R.id.button_plus));
        Button button_minus = (Button) findViewById((R.id.button_minus));
        Button button_mult = (Button) findViewById((R.id.button_multiply));
        Button button_divide = (Button) findViewById((R.id.button_divide));
        Button button_equal = (Button) findViewById((R.id.button_equal));
        Button button_comma = (Button) findViewById((R.id.button_comma));
        Button button_c = (Button) findViewById((R.id.button_c));

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                input.append(b.getText().toString());
                if(b.getText().toString().equals("C")){
                    op1=null;
                    op2=null;
                    input.setText("");
                    result.setText("");
                    displayOperation.setText("");
                }
            }
        };


        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        button_c.setOnClickListener(listener);
        button_comma.setOnClickListener(listener);


        View.OnClickListener opListerner = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                String op = b.getText().toString();
                String value = input.getText().toString();
                input.setText("");

                if (value.length() != 0) {
                    performOperation(value, op);
                }
                pendingOperation = op;
                displayOperation.setText(pendingOperation);


            }
        };

        button_divide.setOnClickListener(opListerner);
        button_mult.setOnClickListener(opListerner);
        button_minus.setOnClickListener(opListerner);
        button_plus.setOnClickListener(opListerner);
        button_equal.setOnClickListener(opListerner);
    }

    private void performOperation(String value, String op) {

       if(op2==null){
            op2=Double.parseDouble(value);
            }

       else {
           if(pendingOperation.equals("=")){
                pendingOperation=op;
           }

           op1=Double.parseDouble(value);
           switch (pendingOperation) {
               case "+":
                    op2+=op1;
                   break;
               case "-":
                    op2-=op1;
                   break;
               case "*":
                    op2*=op1;
                   break;
               case "/":
                    op2/=op1;
                   break;
               case "=":
                  op2=op1;
                   break;
           }

       }
        result.setText(op2.toString());
       input.setText("");


    }
}