package com.example.nauman.insertionsort;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int key=0,i=0,comparisons=0,totalComparisons=0;
    ArrayList<Integer> _data =new ArrayList<>();
    TextView comparisonsTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText=(EditText)findViewById(R.id.et);
        final TextView textView=(TextView) findViewById(R.id.result);
        comparisonsTv =(TextView) findViewById(R.id.et1);

        findViewById(R.id.search_close_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _data.clear();
                _data.add(0);
                String[] _datasetArray = editText.getText().toString().split(",");
                for (int i=0;i<_datasetArray.length;i++){
                    _data.add(Integer.valueOf(_datasetArray[i]));
                }

                perfromInsertionSort();
                textView.setText("");
                for (int i=1; i<_data.size();i++){
                    textView.setText(textView.getText().toString()+","+_data.get(i));
                }
                textView.setText(textView.getText().toString()+" And Total Comparisons = "+totalComparisons);
            }
        });
    }
    void perfromInsertionSort(){
        for (int j=2;j<_data.size();j++){
            comparisons=0;
            key = _data.get(j);
            i = j-1;
            if (_data.get(i)<key)
                ++comparisons;
            while (i>0 && _data.get(i)>key){
                _data.set(i+1,_data.get(i));
                i=i-1;
                ++comparisons;
            }
            totalComparisons=totalComparisons+comparisons;
            comparisonsTv.setText(comparisonsTv.getText().toString()+"+"+comparisons);
            _data.set(i+1,key);
        }
    }
}
