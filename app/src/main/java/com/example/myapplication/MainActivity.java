package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener {

    private String text;
    private TextView boja;
    public static final String COL_PREF="sharedPref";
    public static final String TEXT="text";
    String[] lista = {"green","yellow","red","blue","magenta"};
    String broj;
    private Activity aktivnost;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        boja= findViewById(R.id.boja);
        setContentView(R.layout.activity_main);

        NumberPicker odabirv=findViewById(R.id.odabir);
        odabirv.setMinValue(0);
        odabirv.setMaxValue(4);
        odabirv.setDisplayedValues(lista);
        odabirv.setOnValueChangedListener(this);

        //loadData();
        //updateView();

    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

        ConstraintLayout layout=findViewById(R.id.naziv);
        if (newVal == 1) {
            broj=lista[newVal];
            layout.setBackgroundColor(Color.YELLOW);
        } else if (newVal == 0) {
            broj=lista[newVal];
            layout.setBackgroundColor(Color.GREEN);
        }
        else if (newVal == 2) {
            broj=lista[newVal];
            layout.setBackgroundColor(Color.RED);
        }
        else if (newVal == 3) {
            broj=lista[newVal];
            layout.setBackgroundColor(Color.BLUE);
        }
        else{
            broj=lista[newVal];
            layout.setBackgroundColor(Color.MAGENTA);
        }
        //saveData();
    }

   /* private void saveData() {
    SharedPreferences sharedPreferences=getSharedPreferences(COL_PREF, MODE_PRIVATE);
    SharedPreferences.Editor editor=sharedPreferences.edit();
    editor.putString(TEXT, broj);
    editor.apply();
    }

    public void loadData(){
        SharedPreferences sharedPreferences=getSharedPreferences(COL_PREF, MODE_PRIVATE);
       text=sharedPreferences.getString(TEXT,"GREEN");
    }

    public void updateView(){
        boja.setText("text");
    }*/
}
