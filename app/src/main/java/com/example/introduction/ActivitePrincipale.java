package com.example.introduction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivitePrincipale extends AppCompatActivity {

    // Initialisation des variables globals pour le calcul
    // Variable pour stocker le résultat actuel
    public static String result = "";
    // Variable pour stocker le nombre en cours
    public static Float number = 0f;
    // Variable pour stocker l'opération en cours
    public static String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupération des références des boutons et des TextViews
        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);

        Button btnC = findViewById(R.id.btnC);
        Button btnAC = findViewById(R.id.btnAC);
        Button btnDiv = findViewById(R.id.btnDiv);
        Button btnMult = findViewById(R.id.btnMult);
        Button btnSous = findViewById(R.id.btnSous);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnResult = findViewById(R.id.btnEgale);

        Button btnPlusMoins = findViewById(R.id.btnplusmoins);
        Button btnPourcentage = findViewById(R.id.btnPourcent);
        Button btnVirgule = findViewById(R.id.btnVirgule);

        TextView textViewResult = findViewById(R.id.tvResult);
        TextView textViewLastResult = findViewById(R.id.textViewLastResult);

        textViewResult.setText(result);
        textViewLastResult.setText("");

        // Fonction pour les boutons numériques (0-9)
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumber(0, textViewResult);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumber(1, textViewResult);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumber(2, textViewResult);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumber(3, textViewResult);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumber(4, textViewResult);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumber(5, textViewResult);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumber(6, textViewResult);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumber(7, textViewResult);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumber(8, textViewResult);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNumber(9, textViewResult);
            }
        });

        //Fonction pour le bouton "AC" (All Clear)
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "";
                number = 0f;
                textViewResult.setText(result);
            }
        });

        //Fonction pour le bouton "C" (Clear)
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!result.isEmpty()) {
                    result = result.substring(0, result.length() - 1);
                    textViewResult.setText(result);
                }
            }
        });

        //Fonction pour le bouton "+" (addition)
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calcul(textViewLastResult, textViewResult, "+");
            }
        });

        //Fonction pour le bouton "-" (soustraction)
        btnSous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calcul(textViewLastResult, textViewResult, "-");
            }
        });

        //Fonction pour le bouton "/" (division)
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calcul(textViewLastResult, textViewResult, "/");
            }
        });

        //Fonction pour le bouton "*" (multiplication)
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calcul(textViewLastResult, textViewResult, "*");
            }
        });

        //Fonction pour le bouton "=" (résultat)
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewLastResult.setText("");

                if(operation == "+"){
                    number = number + Float.valueOf(result);
                }else if(operation == "*"){
                    number = number * Float.valueOf(result);
                } else if (operation == "/") {
                    number = number / Float.valueOf(result);
                }else if (operation == "-") {
                    number = number - Float.valueOf(result);
                }else {
                    number = Float.valueOf(result);
                }

                result = String.valueOf(number);
                textViewResult.setText(result);
                operation = "=";
                number = 0f;
            }
        });

        //Fonction pour le bouton "+/-" (Plus ou moins)
        btnPlusMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!result.isEmpty()) {
                    float value = Float.parseFloat(result);
                    value = -value;
                    result = String.valueOf(value);
                    textViewResult.setText(result);
                }
            }
        });

        //Fonction pour le bouton "%" (Pourcentage)
        btnPourcentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!result.isEmpty()) {
                    float value = Float.parseFloat(result);
                    value = value / 100;
                    result = String.valueOf(value);
                    textViewResult.setText(result);
                }
            }
        });

        //Fonction pour le bouton "," (Virgule)
        btnVirgule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!result.contains(".")) {
                    if (result.isEmpty()) {
                        result = "0.";
                    } else {
                        result = result + ".";
                    }
                    textViewResult.setText(result);
                }
            }
        });
    }

    // Fonction pour ajouter un chiffre au résultat
    public static void AddNumber(int num, TextView textView){
        if(operation == "="){
            result = String.valueOf(num);
            operation = "";
        }else {
            result = result + String.valueOf(num);
        }
        textView.setText(result);

    }

    //Effectue la dernière opération avant de faire celle souhaiter
    // Ex : ( 2 * 5 + ....) commence par faire 2*5 avant de passer à l'addition
    public static void LastOperation(TextView textViewLastResult){
        if(operation == "+"){
            number = number + Float.valueOf(result);
        }else if(operation == "*"){
            number = number * Float.valueOf(result);
        } else if (operation == "/") {
            number = number / Float.valueOf(result);
        }else if (operation == "-") {
            number = number - Float.valueOf(result);
        }else {
            number = Float.valueOf(result);
        }

        result = String.valueOf(number);
        textViewLastResult.setText(result);
    }

    // Effectue le calcul en fonction de l'opération
    public static void Calcul(TextView textViewLastResult, TextView textViewResult, String _operation){
        // Vérifie si un calcul n'est pas déjà en cours (Ex : 2 + ... )
        if(VerifyLastCalcul(textViewLastResult, textViewResult, _operation)){
            return;
        }

        if(number != 0f){
            LastOperation(textViewLastResult);
            operation = _operation;
            textViewLastResult.setText(number + operation);
        }else{
            operation = _operation;
            textViewLastResult.setText(result + operation);
            number = Float.valueOf(result);
        }

        result = "";
        textViewResult.setText(result);
    }

    // Vérifie si un calcul est en cours. Si oui on change le calcul en cours
    // (par exemple on peut passer d'une addition à une soustraction)
    public static boolean VerifyLastCalcul(TextView textViewLastResult, TextView textViewResult, String _operation){
        String sResult = textViewResult.getText().toString();
        String sLastResult = textViewLastResult.getText().toString();

        if(sResult == ""){
            if(sLastResult.endsWith("*") || sLastResult.endsWith("/")|| sLastResult.endsWith("+") || sLastResult.endsWith("-")){
                operation = _operation;
                sLastResult = sLastResult.substring(0, sLastResult.length() - 1);
                sLastResult+= _operation;
                textViewLastResult.setText(sLastResult);
            }

            return true;
        }
        return false;
    }
}