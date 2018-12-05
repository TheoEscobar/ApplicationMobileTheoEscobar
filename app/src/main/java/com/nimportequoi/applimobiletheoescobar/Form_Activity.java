package com.nimportequoi.applimobiletheoescobar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Form_Activity extends AppCompatActivity {

    Button validate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_);

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
        Intent intent = new Intent();
        intent.putExtra("USERNAME","Bob");
        setResult(RESULT_OK,intent);
        finish();
    }
}
