package com.example.ejercicio4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText number1EditText;
    private EditText number2EditText;
    private Button addButton;
    private Button subtractButton;
    private Button multiplyButton;
    private Button divideButton;
    private TextView resultTextView;
    private Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1EditText = findViewById(R.id.number1EditText);
        number2EditText = findViewById(R.id.number2EditText);
        addButton = findViewById(R.id.addButton);
        subtractButton = findViewById(R.id.subtractButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        divideButton = findViewById(R.id.divideButton);
        resultTextView = findViewById(R.id.resultTextView);
        exitButton = findViewById(R.id.exitButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult("+");
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult("-");
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult("*");
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult("/");
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void calculateResult(String operator) {
        String number1String = number1EditText.getText().toString().trim();
        String number2String = number2EditText.getText().toString().trim();

        if (number1String.isEmpty() || number2String.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese ambos números", Toast.LENGTH_SHORT).show();
            return;
        }

        int number1 = Integer.parseInt(number1String);
        int number2 = Integer.parseInt(number2String);
        int result = 0;

        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }

        resultTextView.setText("Resultado: " + result);
    }
}
