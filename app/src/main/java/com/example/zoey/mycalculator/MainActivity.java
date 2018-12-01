package com.example.zoey.mycalculator;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mExit;
    private Button mNext;
    private EditText mFirstNum;
    private EditText mSecondNum;
    private String first;
    private String second;
    private static final String TAG = "main";
    public static final String FIRST_INTENT = "first";
    public static final String SECOND_INTENT = "second";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate()");
        mExit = findViewById(R.id.exit_button);
        mNext = findViewById(R.id.next_button);
        mExit.setOnClickListener(this);
        mNext.setOnClickListener(this);


        mFirstNum = findViewById(R.id.first_num);
        mSecondNum = findViewById(R.id.second_num);

        Intent intent = getIntent();
        if(intent.getExtras() != null){
            first = intent.getExtras().getString(FIRST_INTENT);
            second = intent.getExtras().getString(SECOND_INTENT);
            mFirstNum.setText(String.valueOf(first));
            mSecondNum.setText(String.valueOf(second));
            Log.d(TAG, "onCreate: with intent");
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onRestore() " + this.getClass().getSimpleName());
        first = String.valueOf(mFirstNum.getText());
        second = String.valueOf(mSecondNum.getText());
        outState.putString(FIRST_INTENT, first);
        outState.putString(SECOND_INTENT, second);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        first = savedInstanceState.getString(FIRST_INTENT, "");
        second = savedInstanceState.getString(SECOND_INTENT, "");
        Log.d(TAG, "onRestore() " + this.getClass().getSimpleName());
        mFirstNum.setText(first);
        mSecondNum.setText(second);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.exit_button:
                System.exit(0);
                break;
            case R.id.next_button:
                String text1 = String.valueOf(mFirstNum.getText());
                String text2 = String.valueOf(mSecondNum.getText());
                if(!(text1.equals("") && text2.equals(""))){
                    first =text1;
                    second = text2;
                    Intent intent = new Intent(this,OperationChoose.class);
                    intent.putExtra(FIRST_INTENT, first);
                    intent.putExtra(SECOND_INTENT, second);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(this, "Please at least input one nummber in the  inputText.", Toast.LENGTH_SHORT).show();           //显示对话框
                }
                break;
            default:
                break;

        }
    }
}
