package com.example.fermatfactorization;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText numberInput;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberInput = (EditText) findViewById(R.id.numberInput);
        Button factorize = (Button) findViewById(R.id.button);
        result = (TextView) findViewById(R.id.result);
        factorize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fermatFunction();
            }
        });
    }

    void fermatFunction(){
        if (numberInput.getText().toString().length() == 0) {
            String emptyInput = "Error! Enter a number!";
            result.setText(emptyInput);
        }
        else{
            //Fermat Algorithm
            int number = Integer.parseInt(numberInput.getText().toString());
            int p, q;
            int a = (int) Math.ceil((Math.sqrt(number)));
            int b2 = a * a - number;
            while (b2 % Math.sqrt(b2) != 0){
                a++;
                b2 = a * a - number;
            }
            p = (int) (a - Math.sqrt(b2));
            q = (int) (a + Math.sqrt(b2));
            String finalResult = (String) getString(R.string.result, p, q);
            result.setText(finalResult);
        }

    }
}
