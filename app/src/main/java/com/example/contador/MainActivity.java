package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonSumar;
    private Button buttonRestar;
    private TextView contadorFragment;
    private String getText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InciaizaButtonsWithFindview();
        getText = contadorFragment.getText().toString();
        final Integer numero = Integer.parseInt(getText);

        buttonSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer suma = numero + 1;
                contadorFragment.setText(suma.toString());


            }
        });

    }

    private void aplicarFragment(Fragment fragmento){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layoutContenedorFragmentContador, fragmento).addToBackStack(null).commit();
    }

    private void InciaizaButtonsWithFindview() {
        buttonSumar = findViewById(R.id.buttonSumar);
        buttonRestar = findViewById(R.id.buttonRestar);
        contadorFragment = findViewById(R.id.texViewContadorFragment);
    }
}
