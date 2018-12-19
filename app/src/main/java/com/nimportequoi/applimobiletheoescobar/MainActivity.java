package com.nimportequoi.applimobiletheoescobar;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button buttonEdit;
    NameListAdapter nameListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initList();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1)
        {
            if (resultCode == RESULT_OK && data.getExtras() != null)
            {
                Bundle args = data.getExtras();
                String name = args.getString("USERNAME");
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        nameListAdapter.updateList(DataManager.getInstance().getNameList());
    }

    private void initView(){

        nameListAdapter = new NameListAdapter();
        recyclerView = findViewById(R.id.activity_main_recyclerview);
        buttonEdit = findViewById(R.id.activity_main_button_edit);
        final Context context = this;
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Form_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void initList(){
        final LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(nameListAdapter);
    }
}
