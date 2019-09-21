package com.ad.evsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private static final String TAG = "EvsDemo";

    private Button mGearParkingBtn;
    private Button mGearReverseBtn;
    private Button mGearDriveBtn;
    private Button mTurnNoneBtn;
    private Button mTurnLeftBtn;
    private Button mTurnRightBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGearParkingBtn = findViewById(R.id.btn_gear_parking);
        mGearReverseBtn = findViewById(R.id.btn_gear_reverse);
        mGearDriveBtn = findViewById(R.id.btn_gear_drive);
        mTurnNoneBtn = findViewById(R.id.btn_turn_none);
        mTurnLeftBtn = findViewById(R.id.btn_turn_left);
        mTurnRightBtn = findViewById(R.id.btn_turn_right);

        ShellUtils.CommandResult resultSu = ShellUtils.execCommand("setprop vendor.vehicle.gear.event 2",false);
        Log.i(TAG,"resultSu.result = " + resultSu.result);
        Log.i(TAG,"resultSu.successMsg = " + resultSu.successMsg);
        Log.i(TAG,"resultSu.errorMsg = " + resultSu.errorMsg);

        mGearParkingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShellUtils.CommandResult resultSu = ShellUtils.execCommand("setprop vendor.vehicle.gear.event 1",false);
            }
        });
        mGearReverseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShellUtils.CommandResult resultSu = ShellUtils.execCommand("setprop vendor.vehicle.gear.event 2",false);
            }
        });
        mGearDriveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShellUtils.CommandResult resultSu = ShellUtils.execCommand("setprop vendor.vehicle.gear.event 4",false);
            }
        });
        mTurnNoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShellUtils.CommandResult resultSu = ShellUtils.execCommand("setprop vendor.vehicle.turn.event 0",false);
            }
        });
        mTurnLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShellUtils.CommandResult resultSu = ShellUtils.execCommand("setprop vendor.vehicle.turn.event 1",false);
            }
        });
        mTurnRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShellUtils.CommandResult resultSu = ShellUtils.execCommand("setprop vendor.vehicle.turn.event 2",false);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause");
        ShellUtils.CommandResult resultSu = ShellUtils.execCommand("setprop vendor.vehicle.gear.event 4",false);
        Log.i(TAG,"resultSu.result = " + resultSu.result);
        Log.i(TAG,"resultSu.successMsg = " + resultSu.successMsg);
        Log.i(TAG,"resultSu.errorMsg = " + resultSu.errorMsg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy");
        ShellUtils.CommandResult resultSu = ShellUtils.execCommand("setprop vendor.vehicle.gear.event 4",false);
        Log.i(TAG,"resultSu.result = " + resultSu.result);
        Log.i(TAG,"resultSu.successMsg = " + resultSu.successMsg);
        Log.i(TAG,"resultSu.errorMsg = " + resultSu.errorMsg);
    }
}
