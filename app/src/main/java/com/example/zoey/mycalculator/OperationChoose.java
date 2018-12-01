package com.example.zoey.mycalculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OperationChoose extends AppCompatActivity implements View.OnClickListener {
    private Button maddBt;//mAddBt
    private Button msubBt;
    private Button mmulBt;
    private Button mdivBt;
    private Button msinBt;
    private Button mcosBt;
    private Button mtanBt;
    private Button mexit;
    private Button mnext;
    private Button mpreBt;
    private String first;
    private String second;
    private String operation;
    public static final String OPERATION = "operation";
    public static final String FIRST_INTENT = "first";
    public static final String SECOND_INTENT = "second";
    public static final String EXPRESSION = "expression";
    private static final String TAG = "OperationChoose";
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.operationchoose);
        Log.d(TAG, "onCreate()");
        mContext = OperationChoose.this;

        mpreBt = findViewById(R.id.previous_button);
        mpreBt.setOnClickListener(this);

        maddBt = findViewById(R.id.bt_add);
        maddBt.setOnClickListener(this);

        msubBt = findViewById(R.id.bt_sub);
        msubBt.setOnClickListener(this);

        mmulBt = findViewById(R.id.bt_mul);
        mmulBt.setOnClickListener(this);

        mdivBt = findViewById(R.id.bt_div);
        mdivBt.setOnClickListener(this);

        msinBt = findViewById(R.id.bt_sin);
        msinBt.setOnClickListener(this);

        mcosBt = findViewById(R.id.bt_cos);
        mcosBt.setOnClickListener(this);

        mtanBt = findViewById(R.id.bt_tan);
        mtanBt.setOnClickListener(this);

        mexit = findViewById(R.id.exit_button);
        mexit.setOnClickListener(this);

        mnext = findViewById(R.id.next_button);
        mnext.setOnClickListener(this);

        Intent intent = getIntent();
        if(intent.getExtras() != null){
            first = intent.getExtras().getString(FIRST_INTENT);
            second = intent.getExtras().getString(SECOND_INTENT);
            operation = intent.getExtras().getString(OPERATION);
            if(operation != null){
                switch (operation){
                    case "+":
                        maddBt.setEnabled(false);
                        msubBt.setEnabled(true);
                        mmulBt.setEnabled(true);
                        mdivBt.setEnabled(true);
                        break;
                    case "-":
                        maddBt.setEnabled(true);
                        msubBt.setEnabled(false);
                        mmulBt.setEnabled(true);
                        mdivBt.setEnabled(true);
                        break;
                    case "*":
                        maddBt.setEnabled(true);
                        msubBt.setEnabled(true);
                        mmulBt.setEnabled(false);
                        mdivBt.setEnabled(true);
                        break;
                    case "/":
                        maddBt.setEnabled(true);
                        msubBt.setEnabled(true);
                        mmulBt.setEnabled(true);
                        mdivBt.setEnabled(false);
                        break;
                }
            }

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
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        first = savedInstanceState.getString(FIRST_INTENT,"");
        second = savedInstanceState.getString(SECOND_INTENT,"");
        operation = savedInstanceState.getString(OPERATION, "");
    }

    @Override
    public void onClick(View v) {
        Intent intent ;
        switch(v.getId()){
            case R.id.bt_add:
                if(first.equals("") ||second.equals("")){
                    Toast.makeText(this, "Can only perform trigonometric functions!", Toast.LENGTH_SHORT).show();
                }
                else {
                    operation = "+";
                    maddBt.setEnabled(false);
                    msubBt.setEnabled(true);
                    mmulBt.setEnabled(true);
                    mdivBt.setEnabled(true);
                    msinBt.setEnabled(true);
                    mcosBt.setEnabled(true);
                    mtanBt.setEnabled(true);
                }
                    break;

            case R.id.bt_sub:
                if(first.equals("") ||second.equals("")){
                    Toast.makeText(this, "Can only perform trigonometric functions!", Toast.LENGTH_SHORT).show();
                }
                else{
                operation ="-";
                maddBt.setEnabled(true);
                msubBt.setEnabled(false);
                mmulBt.setEnabled(true);
                mdivBt.setEnabled(true);
                msinBt.setEnabled(true);
                mcosBt.setEnabled(true);
                mtanBt.setEnabled(true);
                }
                break;
            case R.id.bt_mul:
                if(first.equals("") ||second.equals("")){
                    Toast.makeText(this, "Can only perform trigonometric functions!", Toast.LENGTH_SHORT).show();
                }
                else {
                    operation = "*";
                    maddBt.setEnabled(true);
                    msubBt.setEnabled(true);
                    mmulBt.setEnabled(false);
                    mdivBt.setEnabled(true);
                    msinBt.setEnabled(true);
                    mcosBt.setEnabled(true);
                    mtanBt.setEnabled(true);
                }
                break;
            case R.id.bt_div:
                if(first.equals("") ||second.equals("")){
                    Toast.makeText(this, "Can only perform trigonometric functions!", Toast.LENGTH_SHORT).show();
                }
                else {
                    operation = "/";
                    maddBt.setEnabled(true);
                    msubBt.setEnabled(true);
                    mmulBt.setEnabled(true);
                    mdivBt.setEnabled(false);
                    msinBt.setEnabled(true);
                    mcosBt.setEnabled(true);
                    mtanBt.setEnabled(true);
                }
                break;
            case R.id.bt_sin:
                operation = "sin";
                maddBt.setEnabled(true);
                msubBt.setEnabled(true);
                mmulBt.setEnabled(true);
                mdivBt.setEnabled(true);
                msinBt.setEnabled(false);
                mcosBt.setEnabled(true);
                mtanBt.setEnabled(true);
                break;
            case R.id.bt_cos:
                operation = "cos";
                maddBt.setEnabled(true);
                msubBt.setEnabled(true);
                mmulBt.setEnabled(true);
                mdivBt.setEnabled(true);
                msinBt.setEnabled(true);
                mcosBt.setEnabled(false);
                mtanBt.setEnabled(true);
                break;
            case R.id.bt_tan:
                operation = "tan";
                maddBt.setEnabled(true);
                msubBt.setEnabled(true);
                mmulBt.setEnabled(true);
                mdivBt.setEnabled(true);
                msinBt.setEnabled(true);
                mcosBt.setEnabled(true);
                mtanBt.setEnabled(false);
                break;
            case R.id.previous_button:
                    intent = new Intent(this, MainActivity.class);
                    intent.putExtra(FIRST_INTENT, first);
                    intent.putExtra(SECOND_INTENT, second);
                    startActivity(intent);
                break;
            case R.id.exit_button:
                System.exit(0);
                break;
            case R.id.next_button:
                Log.d(TAG, "operation:" + operation);
                if (operation == null){
                    Toast.makeText(this, "Please select an operator!", Toast.LENGTH_SHORT).show();
                } else {
                    intent = new Intent(this, ResultActivity.class);
                    intent.putExtra(FIRST_INTENT, first);
                    intent.putExtra(SECOND_INTENT, second);
                    intent.putExtra(OPERATION, operation);
                    intent.putExtra(EXPRESSION, CalculateExpression());
                    startActivity(intent);
                }
                break;
            default:
                break;
        }
    }

    private String CalculateExpression(){
        Double result = 0.0;
        String resultStr = "";
        if(first == null){
            first = second;
        }
        switch (operation){
            case "+":
                result = Double.valueOf(first)+ Double.valueOf(second);
                resultStr = first + operation + second + "  =  " + String.valueOf(result);
                break;
            case "-":
                result = Double.valueOf(first)- Double.valueOf(second);
                resultStr = first + operation + second + "  =  " + String.valueOf(result);
                break;
            case"*":
                result = Double.valueOf(first)* Double.valueOf(second);
                resultStr = first + operation + second + "  =  " + String.valueOf(result);
                break;
            case "/":
                result = Double.valueOf(first)/ Double.valueOf(second);
                resultStr = first + operation + second + "  =  " + String.valueOf(result);
                break;
            case "sin":
                result = Math.sin(Double.valueOf(first));
                resultStr = operation +"("+ first+ ")" + "  =  " + String.valueOf(result);
                break;
            case "cos":
                result = Math.cos(Double.valueOf(first));
                resultStr = operation +"("+ first+ ")" + "  =  " + String.valueOf(result);
                break;
            case "tan":
                result = Math.tan(Double.valueOf(first));
                resultStr = operation +"("+ first+ ")" + "  =  " + String.valueOf(result);
                break;

        }
        return resultStr;
    }
}
