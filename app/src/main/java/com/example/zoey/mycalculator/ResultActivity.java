package com.example.zoey.mycalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mpreBt;
    private Button mexitBt;
    private TextView mresText;
    private String first;
    private String second;
    private String operation;
    private String expression;
    public static final String OPERATION = "operation";
    public static final String FIRST_INTENT = "first";
    public static final String SECOND_INTENT = "second";
    public static final String EXPRESSION = "expression";
    public static final String TAG ="ResultActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        Log.d(TAG, "onCreate()");
        mpreBt = findViewById(R.id.previous_button);
        mpreBt.setOnClickListener(this);

        mexitBt = findViewById(R.id.exit_button);
        mexitBt.setOnClickListener(this);

        mresText = findViewById(R.id.result_text_view);

        Intent intent  = getIntent();
        if(intent.getExtras() != null){
            first = intent.getExtras().getString(FIRST_INTENT);
            second = intent.getExtras().getString(SECOND_INTENT);
            operation = intent.getExtras().getString(OPERATION);
            expression = intent.getExtras().getString(EXPRESSION);
            mresText.setText(expression);
            Log.d(TAG, "onCreate: with intent");

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onRestore() " + this.getClass().getSimpleName());
        outState.putString(FIRST_INTENT, first);
        outState.putString(SECOND_INTENT, second);
        outState.putString(OPERATION, operation);
        outState.putString(EXPRESSION,expression);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: " + this.getClass().getSimpleName());
        first = savedInstanceState.getString(FIRST_INTENT,"");
        second = savedInstanceState.getString(SECOND_INTENT,"");
        operation = savedInstanceState.getString(OPERATION, "");
        expression = savedInstanceState.getString(EXPRESSION,"");
        mresText.setText(expression);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.exit_button:
                System.exit(0);
            case R.id.previous_button:
                intent = new Intent(this, OperationChoose.class);
                intent.putExtra(FIRST_INTENT, first);
                intent.putExtra(SECOND_INTENT, second);
                intent.putExtra(OPERATION, operation);
                intent.putExtra(EXPRESSION, expression);
                startActivity(intent);
        }
    }
}
