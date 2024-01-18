package com.toporead.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.EventLog;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mybtn =findViewById(R.id.mybtn);

        EditText editText = findViewById(R.id.edittext);

        RecyclerView recyclerView =findViewById(R.id.myrecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataList = new ArrayList<>(Arrays.asList("a","b","c"));
        MyAdapter myAdapter =new MyAdapter(dataList);
        recyclerView.setAdapter(myAdapter);


        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((actionId == EditorInfo.IME_ACTION_DONE ||actionId ==EditorInfo.IME_ACTION_SEND)||(event !=null && event.getAction()==KeyEvent.ACTION_DOWN && event.getKeyCode()==KeyEvent.KEYCODE_ENTER)){
                    mybtn.performClick();
                    return true;
                }
                return false;
            }
        });
        mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if (!text.isEmpty()){

                    dataList.add(editText.getText().toString());
                    editText.setText("");
                    int newPosition =dataList.size()-1;
                    myAdapter.notifyItemChanged(newPosition);
                }
            }
        });
    }
}