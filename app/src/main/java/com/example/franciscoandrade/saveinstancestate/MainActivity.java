package com.example.franciscoandrade.saveinstancestate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    EditText textET;
    TextView textName;

    int number;

    String nameET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txt=(TextView)findViewById(R.id.txtTV);

        textET=(EditText)findViewById(R.id.textET);
        textName=(TextView)findViewById(R.id.textName);




        if(savedInstanceState!=null){
            number= savedInstanceState.getInt("number");
            txt.setText(number+"");

            nameET= savedInstanceState.getString("name");
            textName.setText(nameET);


        }
        else {
            number=0;
            txt.setText(number+"");

        }


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("number", number);
        outState.putString("name", textName.getText().toString());


        super.onSaveInstanceState(outState);
    }

    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btn1:
                number++;
                txt.setText(number+"");
                break;

            case R.id.btn2:
                textName.setText(textET.getText().toString());
                textET.setText("");
                textET.setHint("Enter Name: ");
                break;
        }




    }
}
