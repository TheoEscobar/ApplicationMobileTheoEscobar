package com.nimportequoi.applimobiletheoescobar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Form_Activity extends AppCompatActivity {

    Button validate;
    EditText editTextName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_);

        editTextName = findViewById(R.id.activity_form_editText_username);
        validate = findViewById(R.id.activity_form_button_validate);
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    private void saveData()
    {
        String name = editTextName.getText().toString();
        if (!name.isEmpty()){
            DataManager.getInstance().addItem(name);
        }else{
            Toast.makeText(this,
                    "Vous n'avez rien saisi",
                    Toast.LENGTH_SHORT).show();
        }


        finish();
    }
}
